package jp.co.rakus.ec_cite.controller;

/**
 * 商品画像を表すフォームクラス.
 * 
 * @author hiroki.mae
 *
 */
public class PhotoForm {

	/** 写真ID*/
	private String id;
	/** 画像エンコード*/
	private String infoBase64;
	/** 紐づいている商品ID*/
	private String itemId;
	/** 代表画像として紐づいている特定の商品ID*/
	private String masterItemId;
	
	
	public Integer getIntegerId() {
		return Integer.parseInt(id);
	}
	public Integer getIntegerItemId() {
		return Integer.parseInt(itemId);
	}
	public Integer getIntegerMasterItemId() {
		return Integer.parseInt(masterItemId);
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getInfoBase64() {
		return infoBase64;
	}
	public void setInfoBase64(String infoBase64) {
		this.infoBase64 = infoBase64;
	}
	public String getItemId() {
		return itemId;
	}
	public void setItemId(String itemId) {
		this.itemId = itemId;
	}
	public String getMasterItemId() {
		return masterItemId;
	}
	public void setMasterItemId(String masterItemId) {
		this.masterItemId = masterItemId;
	}
	
	
	
	
}
