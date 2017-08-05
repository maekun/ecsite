package jp.co.rakus.ec_cite.domain;

import java.util.List;

public class User {

	
	/** ユーザID*/
	private Integer id;
	/** 名*/
	private String firstName;
	/** 性*/
	private String lastName;
	/** 登録メールアドレス*/
	private String email;
	/** ログインパスワード*/
	private String password;
	/** お気に入りに追加した商品IDリスト*/
	private List<Integer> favoriteItemList;
	/** 購入した商品IDリスト*/
	private List<Integer> purchasedItemList;
	/** ログイン状況（ログイン中ならtrue）*/
	private boolean isLogging;
	
	
	//domainにはデフォルトコンストラクタ必須
	public User() {
		
	};
	
	
	public User(String firstName, String lastName, String email, String password) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
		this.isLogging = false;
	}

	
	/**
	 * getter/setter
	 * @return
	 */
	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getFirstName() {
		return firstName;
	}


	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	public String getLastName() {
		return lastName;
	}


	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public List<Integer> getFavoriteItemList() {
		return favoriteItemList;
	}


	public void setFavoriteItemList(List<Integer> favoriteItemList) {
		this.favoriteItemList = favoriteItemList;
	}


	public List<Integer> getPurchasedItemList() {
		return purchasedItemList;
	}


	public void setPurchasedItemList(List<Integer> purchasedItemList) {
		this.purchasedItemList = purchasedItemList;
	}


	public boolean isLogging() {
		return isLogging;
	}


	public void setLogging(boolean isLogging) {
		this.isLogging = isLogging;
	}


}
