package jp.co.rakus.ec_cite.service;

import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jp.co.rakus.ec_cite.domain.Item;
import jp.co.rakus.ec_cite.repository.ItemRepository;

@Service
public class ItemService {

	@Autowired
	private ItemRepository itemRepository;

	/**
	 * 商品の全件検索.
	 * 
	 * @return 代表画像をつけて商品リストを返す
	 */
	public List<Item> findAll() {
		List<Item> itemList = new LinkedList<>();
		itemList = itemRepository.findAll();
		
		return itemList;
	}
	
	/**
	 * 商品idで該当商品を主キー検索.
	 * 
	 * @param itemId 
	 * 			商品id
	 * @return 該当商品
	 */
	public Item load(Integer itemId) {
		
		return itemRepository.load(itemId);
	}
	
	/**
	 * 商品名であいまい検索.
	 *
	 * @param inputWord
	 *            検索に使う文字列
	 * @return 条件に合っている商品リスト
	 */
	public List<Item> findByInputWord(String inputWord){
		return itemRepository.findByInputWord(inputWord);
	}
//	/**
//	 * 入力された文字列であいまい検索する.
//	 * 
//	 * @param inputWord
//	 *            入力された文字列
//	 * @return 商品それぞれに紐づいている商品画像をつけた商品リスト
//	 */
//	public List<Item> findItemByInputWord(String inputWord) {
//
//		//debug
//		System.out.println("サービスなう");
//		System.out.println(inputWord);
//		//
//		
//		
//		// 検索したアイテムリスト
//		List<Item> itemList = new LinkedList<>();
//		itemList = itemRepository.findByInputWord(inputWord);
//
//		// 画像をそれぞれのアイテムにセット
//		for (Item item : itemList) {
//			
//			//debug
//			System.out.println("サービスのfor文なう");
//			System.out.println(item.getName());
//			//
//			
//			Photo masterPhoto = new Photo();
//			masterPhoto = photoRepository.findPhotoByMasterItemId(item.getId());
//			item.setMasterPhoto(masterPhoto);
//		}
//		return itemList;
//	}

//	/**
//	 * 主キー検索.
//	 * 
//	 * @return 受け取ったidに該当する単品商品に関連画像をセットして返す
//	 */
//	public Item load(Integer id) {
//
//		Item item = itemRepository.load(id);
//
//		List<Photo> photoList = new ArrayList<>();
//		photoList = photoRepository.findPhotosByItemId(item.getId());
//
//		for (Photo photo : photoList) {
//			if (photo.getMasterItemId() == item.getId()) {
//				item.setMasterPhoto(photo);
//			}
//			item.getPhotoList().add(photo);
//		}
//		return item;
//	}


	// /**
	// * 入力された文字列であいまい検索する.
	// *
	// * @param inputWord
	// * 入力された文字列
	// * @return 商品それぞれに紐づいている商品画像をつけたリスト
	// */
	// public List<Item> findItemByInputWord(String inputWord) {
	//
	// // 検索したアイテムリスト
	// List<Item> itemList = new LinkedList<>();
	// itemList = itemRepository.findByInputWord(inputWord);
	//
	// // 画像をそれぞれのアイテムにセット
	// for (Item item : itemList) {
	// List<Photo> photoList = new ArrayList<>();
	// photoList = photoRepository.findByItemId(item.getId());
	//
	// for (Photo photo : photoList) {
	// if (photo.getMasterItemId() == item.getId()) {
	// item.setMasterPhoto(photo);
	// }
	// item.getPhotoList().add(photo);
	// }
	// }
	// return itemList;
	// }

}
