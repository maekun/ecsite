package jp.co.rakus.ec_cite.domain;

import java.util.ArrayList;
import java.util.List;

/**
 * 登録商品を表すクラス.
 * 
 * @author hiroki.mae
 *
 */
public class Item {


	/** 商品ID*/
	private Integer id;
	/** 商品名*/
	private String name;
	/** 商品情報タイトル*/
	private String infoTitle;
	/** 商品情報*/
	private String info;
	/** 価格*/
	private Integer price;
	/** 在庫数*/
	private Integer stock;
	/** 総売上個数*/
	private Integer numberSold;
	/** 最小プレイヤー数*/
	private Integer playerMin;
	/** 最大プレイヤー数*/
	private Integer playerMax;
	/** 最短プレイ時間*/
	private Integer timeMin;
	/** 最長プレイ時間*/
	private Integer timeMax;
	/** 販売状況*/
	private boolean isSoldout;
	/** 代表画像*/
	private Photo masterPhoto;
	/** 商品画像リスト*/
	private List<Photo>photoList = new ArrayList<>();
	
	
		/** デフォルトコンストラクタ */
		public Item() {
			super();
		}


		public Integer getId() {
			return id;
		}


		public void setId(Integer id) {
			this.id = id;
		}


		public String getName() {
			return name;
		}


		public void setName(String name) {
			this.name = name;
		}


		public String getInfoTitle() {
			return infoTitle;
		}


		public void setInfoTitle(String infoTitle) {
			this.infoTitle = infoTitle;
		}


		public String getInfo() {
			return info;
		}


		public void setInfo(String info) {
			this.info = info;
		}


		public Integer getPrice() {
			return price;
		}


		public void setPrice(Integer price) {
			this.price = price;
		}


		public Integer getStock() {
			return stock;
		}


		public void setStock(Integer stock) {
			this.stock = stock;
		}


		public Integer getNumberSold() {
			return numberSold;
		}


		public void setNumberSold(Integer numberSold) {
			this.numberSold = numberSold;
		}


		public Integer getPlayerMin() {
			return playerMin;
		}


		public void setPlayerMin(Integer playerMin) {
			this.playerMin = playerMin;
		}


		public Integer getPlayerMax() {
			return playerMax;
		}


		public void setPlayerMax(Integer playerMax) {
			this.playerMax = playerMax;
		}


		public Integer getTimeMin() {
			return timeMin;
		}


		public void setTimeMin(Integer timeMin) {
			this.timeMin = timeMin;
		}


		public Integer getTimeMax() {
			return timeMax;
		}


		public void setTimeMax(Integer timeMax) {
			this.timeMax = timeMax;
		}


		public boolean isSoldout() {
			return isSoldout;
		}


		public void setSoldout(boolean isSoldout) {
			this.isSoldout = isSoldout;
		}


		public Photo getMasterPhoto() {
			return masterPhoto;
		}


		public void setMasterPhoto(Photo masterPhoto) {
			this.masterPhoto = masterPhoto;
		}


		public List<Photo> getPhotoList() {
			return photoList;
		}


		public void setPhotoList(List<Photo> photoList) {
			this.photoList = photoList;
		}
	
		
		
	
	
	
}
