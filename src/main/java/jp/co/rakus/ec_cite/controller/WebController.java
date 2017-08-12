package jp.co.rakus.ec_cite.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import jp.co.rakus.ec_cite.domain.Item;
import jp.co.rakus.ec_cite.service.ItemService;

/**
 * ECサイト内の移動を実現するコントローラクラス.
 * 
 * @author hiroki.mae
 *
 */
@Controller
@Transactional
@RequestMapping("/web")
public class WebController {

	@Autowired
	private ItemService itemService;

	/**
	 * 商品一覧表示.
	 * 
	 * @return 全商品リスト
	 */
	@RequestMapping("/index")
	public String toItemList(Model model) {

		List<Item> itemList = new ArrayList<>();
		itemList = itemService.findAll();

		model.addAttribute("itemList", itemList);

		return "itemList";
	}
	/**
	 * JSPでクリックされた商品を主キー検索.
	 * 
	 * @param itemId
	 *            商品id
	 * @return 該当商品
	 */
	@RequestMapping("/to-itemPage")
	public String toItemPage(Integer itemId, Model model) {
		Item item = itemService.load(itemId);
		model.addAttribute("item", item);
		
		return "itemPage";
	}

	 /**
	 * 入力された文字列であいまい検索.
	 *
	 * @param name
	 * 検索ワード
	 * @return ヒットした商品リスト
	 */
	 @RequestMapping("/word-search")
	 public String wordSearch(String inputWord, Model model) {
	
	 List<Item> itemList = itemService.findByInputWord(inputWord);
	 model.addAttribute("itemList", itemList);
	
	 return "itemList";
	 }
	 
	 /**
	 * プレイ人数で検索.
	 * 
	 * @param numberOfPlayers
	 * 			プレイしたい人数
	 * @return ヒットした商品リスト
	 */
	 @RequestMapping("/number-of-players-search")
	 public String numberOfPlayersSearch(Integer numberOfPlayers, Model model) {
		 
		 List<Item> itemList = itemService.findByNumberOfPlayers(numberOfPlayers);
		 model.addAttribute("itemList", itemList);
		 
		 return "itemList";
	 }
	 /**
	 * プレイ時間で検索.
	 * 
	 * @param numberOfPlayers
	 * 			プレイかかる時間
	 * @return ヒットした商品リスト
	 */
	@RequestMapping("/play-time-search")
 	public String playTimeSearch(Integer playTime, Model model) {
	 
		 List<Item> itemList = itemService.findByPlayTime(playTime);
		 model.addAttribute("itemList", itemList);

		 return "itemList";
	}
	 
	/**
	 * 価格で検索.
	 * 
	 * @param price
	 *            購入予算
	 * @return 条件に合っている商品リスト
	 */
	@RequestMapping("price-search")
	public String priceSearch(Integer price, Model model) {
		
		List<Item> itemList = itemService.findByPrice(price);
		model.addAttribute("itemList", itemList);
		
		return "itemList";
	}
	

	// /**
	// * アクセスがきた段階でセッションにログイン状態がtrueのUserオブジェクトがあるか
	// 確認して、trueなら商品一覧へ。falseならログイン画面へ遷移
	// *
	// * @return
	// */
	// @RequestMapping("")
	// @Transactional
	// public String pageController() {
	// // sessionにユーザがいて、ログイン状態だったら商品一覧画面へ遷移
	// //
	// // TODO: セッションIDでのチェックが実装できていない
	// //
	// User user = (User) session.getAttribute("user");
	//
	// if (user == null) {
	// return "login";
	// }
	//
	// return "itemList";
	// }

	//
	// /**
	// * とりあえず画像をDBから持ってきて表示する
	// * @param model
	// * @return
	// */
	// @RequestMapping("/show")
	// public String printPhoto(Model model) {
	// List<Photo>photoList = new ArrayList<Photo>();
	// photoList = photoService.findByItemId(2);
	// model.addAttribute("photoList", photoList);
	// return "itemList";
	// }
}
