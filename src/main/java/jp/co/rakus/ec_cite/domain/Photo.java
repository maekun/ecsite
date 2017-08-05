package jp.co.rakus.ec_cite.domain;

/**
 * 商品画像を表すクラス.
 * 
 * @author hiroki.mae
 *
 */
public class Photo {
	
	/** 写真ID*/
	private Integer id;
	/** 画像エンコード*/
	private String infoBase64;
	/** 紐づいている商品ID*/
	private Integer itemId;
	/** 代表画像として紐づいている特定の商品ID*/
	private Integer masterItemId;
	
	
	/**
	 * デフォルトコンストラクタ
	 */
	public Photo() {
	}
	

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getInfoBase64() {
		return infoBase64;
	}

	public void setInfoBase64(String infoBase64) {
		this.infoBase64 = infoBase64;
	}

	public Integer getItemId() {
		return itemId;
	}

	public void setItemId(Integer itemId) {
		this.itemId = itemId;
	}

	public Integer getMasterItemId() {
		return masterItemId;
	}

	public void setMasterItemId(Integer masterItemId) {
		this.masterItemId = masterItemId;
	}

	
	
	
	
	
	
}
