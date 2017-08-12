package jp.co.rakus.ec_cite.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import jp.co.rakus.ec_cite.domain.Item;
import jp.co.rakus.ec_cite.domain.Photo;

/**
 * itemsテーブルを操作するリポジトリクラス.
 * 
 * @author hiroki.mae
 *
 */
@Repository
public class ItemRepository {

	@Autowired
	private NamedParameterJdbcTemplate template;

	/**
	 * 画像付きの商品リストを返す.
	 */
	@Autowired
	private static final ResultSetExtractor<List<Item>> ITEM_LIST_RESULT_SET_EXTRACTOR = (rs) -> {

		Item item = new Item();
		Photo photo = new Photo();
		List<Item> itemList = new ArrayList<>();
		List<Photo> photoList = null;

		int beforeItemId = 0;

		while (rs.next()) {

			if (rs.getInt("item_id") != beforeItemId) {
				item = new Item();
				photoList = new ArrayList<>();

				item.setId(rs.getInt("item_id"));
				item.setName(rs.getString("item_name"));
				item.setInfoTitle(rs.getString("item_info_title"));
				item.setInfo(rs.getString("item_info"));
				item.setPrice(rs.getInt("item_price"));
				item.setStock(rs.getInt("item_stock"));
				item.setNumberSold(rs.getInt("item_number_sold"));
				item.setPlayerMin(rs.getInt("item_player_min"));
				item.setPlayerMax(rs.getInt("item_player_max"));
				item.setTimeMin(rs.getInt("item_time_min"));
				item.setTimeMax(rs.getInt("item_time_max"));
				item.setSoldout(rs.getBoolean("item_is_soldout"));

				item.setPhotoList(photoList);
				itemList.add(item);
			}
			// itemId更新
			beforeItemId = item.getId();

			// 商品の代表画像か見分ける
			if (item.getId() == rs.getInt("photo_master_item_id")) {
				photo = new Photo();
				photo.setId(rs.getInt("photo_id"));
				photo.setInfoBase64(rs.getString("p_info_base64"));
				photo.setItemId(rs.getInt("photo_item_id"));
				photo.setMasterItemId(rs.getInt("photo_master_item_id"));
				item.setMasterPhoto(photo);

				continue;
			}

			photo = new Photo();
			photo.setId(rs.getInt("photo_id"));
			photo.setInfoBase64(rs.getString("p_info_base64"));
			photo.setItemId(rs.getInt("photo_item_id"));
			photo.setMasterItemId(rs.getInt("photo_master_item_id"));
			photoList.add(photo);
		}
		return itemList;
	};

	/**
	 * 全件検索.
	 * 
	 * @return 全商品リスト
	 */
	public List<Item> findAll() {
		String sql = "select i.id AS item_id,i.name AS item_name,i.info_title AS item_info_title,i.info AS item_info,	i.price AS item_price,i.stock AS item_stock,	i.number_sold AS item_number_sold,i.player_min AS item_player_min,i.player_max AS item_player_max,	i.time_min AS item_time_min,	i.time_max AS item_time_max,	i.is_soldout AS item_is_soldout,	p.id as photo_id,	p.info_base64 AS p_info_base64,	p.item_id AS photo_item_id,	p.master_item_id AS photo_master_item_id from items as i left outer join photos as p on i.id = p.master_item_id order by i.id desc ;";
		List<Item> itemList = template.query(sql, ITEM_LIST_RESULT_SET_EXTRACTOR);
		return itemList;
	}

	/**
	 * 主キー検索.
	 *
	 * @return 受け取ったidに該当する単品商品
	 */
	public Item load(Integer itemId) {
		String sql = " select i.id AS item_id,	i.name AS item_name,i.info_title AS item_info_title,i.info AS item_info,i.price AS item_price,i.stock AS item_stock,i.number_sold AS item_number_sold,	i.player_min AS item_player_min,	i.player_max AS item_player_max,	i.time_min AS item_time_min,	i.time_max AS item_time_max,	i.is_soldout AS item_is_soldout,	p.id as photo_id,	p.info_base64 AS p_info_base64,	p.item_id AS photo_item_id,	p.master_item_id AS photo_master_item_id from items as i left outer join photos as p on i.id = p.item_id where i.id = :itemId ;";
		SqlParameterSource paramMap = new MapSqlParameterSource().addValue("itemId", itemId);

		List<Item> itemList = template.query(sql, paramMap, ITEM_LIST_RESULT_SET_EXTRACTOR);
		Item item = itemList.get(0);

		return item;
	}

	/**
	 * 商品名であいまい検索.
	 *
	 * @param inputWord
	 *            検索に使う文字列
	 * @return 条件に合っている商品リスト
	 */
	public List<Item> findByInputWord(String inputWord) {

		String sql = "select i.id AS item_id,i.name AS item_name,i.info_title AS item_info_title,i.info AS item_info,i.price AS item_price,i.stock AS item_stock,i.number_sold AS item_number_sold,i.player_min AS item_player_min,i.player_max AS item_player_max,i.time_min AS item_time_min,i.time_max AS item_time_max,i.is_soldout AS item_is_soldout,p.id as photo_id,p.info_base64 AS p_info_base64,p.item_id AS photo_item_id,p.master_item_id AS photo_master_item_id from items as i left join photos as p on i.id = p.item_id where i.name like :inputWord ;";

		SqlParameterSource paramMap = new MapSqlParameterSource().addValue("inputWord", "%" + inputWord + "%");
		List<Item> itemList = template.query(sql, paramMap, ITEM_LIST_RESULT_SET_EXTRACTOR);

		return itemList;
	}

	/**
	 * プレイ人数で検索.
	 * 
	 * @param numberOfPlayers
	 *            プレイしたい人数
	 * @return 条件に合っている商品リスト
	 */
	public List<Item> findByNumberOfPlayers(Integer numberOfPlayers) {

		String sql = "select i.id AS item_id,i.name AS item_name,i.info_title AS item_info_title,i.info AS item_info,i.price AS item_price,i.stock AS item_stock,i.number_sold AS item_number_sold,i.player_min AS item_player_min,i.player_max AS item_player_max,i.time_min AS item_time_min,i.time_max AS item_time_max,i.is_soldout AS item_is_soldout,p.id as photo_id,p.info_base64 AS p_info_base64,p.item_id AS photo_item_id,p.master_item_id AS photo_master_item_id from items as i left join photos as p on i.id = p.item_id where i.player_min <= :numberOfPlayers and :numberOfPlayers <= i.player_max ;";

		SqlParameterSource paramMap = new MapSqlParameterSource().addValue("numberOfPlayers", numberOfPlayers);
		List<Item> itemList = template.query(sql, paramMap, ITEM_LIST_RESULT_SET_EXTRACTOR);

		return itemList;
	}

	/**
	 * プレイ時間で検索.
	 * 
	 * @param numberOfPlayers
	 *            プレイかかる時間
	 * @return 条件に合っている商品リスト
	 */
	public List<Item> findByPlayTime(Integer playTime) {

		String sql = "select i.id AS item_id,i.name AS item_name,i.info_title AS item_info_title,i.info AS item_info,i.price AS item_price,i.stock AS item_stock,i.number_sold AS item_number_sold,i.player_min AS item_player_min,i.player_max AS item_player_max,i.time_min AS item_time_min,i.time_max AS item_time_max,i.is_soldout AS item_is_soldout,p.id as photo_id,p.info_base64 AS p_info_base64,p.item_id AS photo_item_id,p.master_item_id AS photo_master_item_id from items as i left join photos as p on i.id = p.item_id where i.time_min <= :playTime and :playTime <= i.time_max ;";

		SqlParameterSource paramMap = new MapSqlParameterSource().addValue("playTime", playTime);
		List<Item> itemList = template.query(sql, paramMap, ITEM_LIST_RESULT_SET_EXTRACTOR);

		return itemList;
	}

	/**
	 * 価格で検索.
	 * 
	 * @param price
	 *            購入予算
	 * @return 条件に合っている商品リスト
	 */
	public List<Item> findByPrice(Integer price) {

		String sql = "select i.id AS item_id,i.name AS item_name,i.info_title AS item_info_title,i.info AS item_info,i.price AS item_price,i.stock AS item_stock,i.number_sold AS item_number_sold,i.player_min AS item_player_min,i.player_max AS item_player_max,i.time_min AS item_time_min,i.time_max AS item_time_max,i.is_soldout AS item_is_soldout,p.id as photo_id,p.info_base64 AS p_info_base64,p.item_id AS photo_item_id,p.master_item_id AS photo_master_item_id from items as i left join photos as p on i.id = p.item_id where i.price <= :price ;";

		SqlParameterSource paramMap = new MapSqlParameterSource().addValue("price", price);
		List<Item> itemList = template.query(sql, paramMap, ITEM_LIST_RESULT_SET_EXTRACTOR);

		return itemList;
	}

}

// @Autowired
// private static final RowMapper<Item> ITEM_ROW_MAPPER = (rs,i) -> {
// Item item = new Item();
// Photo photo = new Photo();
//
// item.setId(rs.getInt("item_id"));
// item.setName(rs.getString("item_name"));
// item.setInfoTitle(rs.getString("item_info_title"));
// item.setInfo(rs.getString("item_info"));
// item.setPrice(rs.getInt("item_price"));
// item.setStock(rs.getInt("item_stock"));
// item.setNumberSold(rs.getInt("item_number_sold"));
// item.setPlayerMin(rs.getInt("item_player_min"));
// item.setPlayerMax(rs.getInt("item_player_max"));
// item.setTimeMin(rs.getInt("item_time_min"));
// item.setTimeMax(rs.getInt("item_time_max"));
// item.setSoldout(rs.getBoolean("item_is_soldout"));
// 商品の代表画像か見分ける
// if(item.getId()==rs.getInt("photo_master_item_id"))
// {
// photo = new Photo();
// photo.setId(rs.getInt("photo_id"));
// photo.setInfoBase64(rs.getString("p_info_base64"));
// photo.setItemId(rs.getInt("photo_item_id"));
// photo.setMasterItemId(rs.getInt("photo_master_item_id"));
// item.setMasterPhoto(photo);
// }else
// {
// photo = new Photo();
// photo.setId(rs.getInt("photo_id"));
// photo.setInfoBase64(rs.getString("p_info_base64"));
// photo.setItemId(rs.getInt("photo_item_id"));
// photo.setMasterItemId(rs.getInt("photo_master_item_id"));
// item.getPhotoList().add(photo);
// }
//
// return item;};
//