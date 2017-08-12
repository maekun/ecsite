package jp.co.rakus.ec_cite.controller;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;

public class LoginForm {
	/** 登録メールアドレス*/
	@NotBlank(message="メールアドレスを入力してください")
	@Email(message="メールアドレスを入力してください")
	private String email;
	/** パスワード*/
	@Pattern(regexp="[a-zA-Z0-9]*",message="半角英数で入力してください")
	@Size(min=8,max=16,message="8~16文字以内で入力してください")
	private String password;
	/** 確認用パスワード*/
	@NotBlank(message="確認用パスワードを入力してください")
	private String checkPassword;
	
	
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
	public String getCheckPassword() {
		return checkPassword;
	}
	public void setCheckPassword(String checkPassword) {
		this.checkPassword = checkPassword;
	}
	
	
}
