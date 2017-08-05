package jp.co.rakus.ec_cite.controller;

import java.util.ArrayList;
import java.util.List;

import jp.co.rakus.ec_cite.domain.Photo;

/**
 * 商品を表すフォームクラス.
 * 
 * @author hiroki.mae
 *
 */
public class ItemForm {

	/** 商品ID*/
	private String id;
	/** 商品名*/
	private String name;
	/** 商品情報タイトル*/
	private String infoTitle;
	/** 商品情報*/
	private String info;
	/** 価格*/
	private String price;
	/** 在庫数*/
	private String stock;
	/** 総売上個数*/
	private String numberSold;
	/** 最小プレイヤー数*/
	private String playerMin;
	/** 最大プレイヤー数*/
	private String playerMax;
	/** 最短プレイ時間*/
	private String timeMin;
	/** 最長プレイ時間*/
	private String timeMax;
	/** 販売状況*/
	private boolean isSoldout;
	/** 代表画像*/
	private Photo masterPhoto;
	/** 商品画像リスト*/
	private List<Photo>photoList = new ArrayList<>();
	public String getId() {
		return id;
	}
	
	public Integer getIntegerId() {
		return Integer.parseInt(id);
	}
	public Integer getIntegerPrice() {
		return Integer.parseInt(price);
	}
	public Integer getIntegerStock() {
		return Integer.parseInt(stock);
	}
	public Integer getIntegerNumberSold() {
		return Integer.parseInt(numberSold);
	}
	public Integer getIntegerpPlayerMin() {
		return Integer.parseInt(playerMin);
	}
	public Integer getIntegerPlayerMax() {
		return Integer.parseInt(playerMax);
	}
	public Integer getIntegerTimeMin() {
		return Integer.parseInt(timeMin);
	}
	public Integer getIntegerTimeMax() {
		return Integer.parseInt(timeMax);
	}
	
	public void setId(String id) {
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
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getStock() {
		return stock;
	}
	public void setStock(String stock) {
		this.stock = stock;
	}
	public String getNumberSold() {
		return numberSold;
	}
	public void setNumberSold(String numberSold) {
		this.numberSold = numberSold;
	}
	public String getPlayerMin() {
		return playerMin;
	}
	public void setPlayerMin(String playerMin) {
		this.playerMin = playerMin;
	}
	public String getPlayerMax() {
		return playerMax;
	}
	public void setPlayerMax(String playerMax) {
		this.playerMax = playerMax;
	}
	public String getTimeMin() {
		return timeMin;
	}
	public void setTimeMin(String timeMin) {
		this.timeMin = timeMin;
	}
	public String getTimeMax() {
		return timeMax;
	}
	public void setTimeMax(String timeMax) {
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
