package jp.co.rakus.ec_cite.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import jp.co.rakus.ec_cite.domain.Photo;

/**
 * 商品画像テーブルを操作するリポジトリクラス.
 * 
 * @author hiroki.mae
 *
 */
@Repository
public class PhotoRepository {

	@Autowired
	private NamedParameterJdbcTemplate template;

	@Autowired
	private static final RowMapper<Photo> PHOTO_ROW_MAPPER = (rs, i) -> {
		Photo photo = new Photo();
		photo.setId(rs.getInt("id"));
		photo.setInfoBase64(rs.getString("info_base64"));
		photo.setItemId(rs.getInt("item_id"));
		photo.setMasterItemId(rs.getInt("master_item_id"));
		return photo;
	};

	/**
	 * 商品IDから代表画像検索する.
	 * 
	 * @param itemId
	 *            対象商品のID
	 * @return 対象画像を返す
	 */
	public Photo findPhotoByMasterItemId(Integer itemId) {

		String sql = "select id , info_base64, item_id ,master_item_id from photos where master_item_id = :itemId ;";

		SqlParameterSource paramMap = new MapSqlParameterSource().addValue("itemId", itemId);
		Photo photo = template.queryForObject(sql, paramMap, PHOTO_ROW_MAPPER);

		return photo;
	}
	/**
	 * 商品IDから複数の関連を検索する.
	 * 
	 * @param itemId
	 *            対象商品のID
	 * @return 対象画像をリストで返す
	 */
	public List<Photo> findPhotosByItemId(Integer itemId) {
		
		String sql = "select id , info_base64, item_id ,master_item_id from photos where item_id = :itemId ;";
		
		SqlParameterSource paramMap = new MapSqlParameterSource().addValue("itemId", itemId);
		List<Photo> photoList = template.query(sql, paramMap, PHOTO_ROW_MAPPER);
		
		return photoList;
	}
}
