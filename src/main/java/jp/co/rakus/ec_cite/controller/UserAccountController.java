package jp.co.rakus.ec_cite.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import jp.co.rakus.ec_cite.domain.User;

public class UserAccountController {

	@Autowired
	private WebController webController;
	
	/**
	 * ログイン画面に遷移する
	 * 
	 * @return
	 */
	@RequestMapping("/login")
	@Transactional
	public String toLoginForm() {

		return "login";
	}

	/**
	 * 
	 * 新規登録画面へ遷移
	 * 
	 * @param email
	 * @param password
	 * @return
	 */
	@RequestMapping("/to-register-form")
	@Transactional
	public String isRegister(String email, String password) {
		return "register";
	}

	/**
	 * 登録 TODO:もし登録済みなら登録済みですと例外で出したい
	 * 
	 * @param email
	 * @param password
	 * @return
	 */
	@RequestMapping("/register")
	@Transactional
	public String register(String firstName, String lastName, String email, String password) {

		User newUser = new User(firstName, lastName, email, password);
		// userService.save(newUser);

		return "login";
	}

	/**
	 * 登録内容と照合した後ログイン
	 * 
	 * @param email
	 *            入力されたemail
	 * @param password
	 *            入力されたpassword
	 * @return
	 */
	@RequestMapping("/isRegistered")
	@Transactional
	public void isRegistered(String email, String password, Model model) {

		// User registeredUser = userService.findByEmail(email); 戻り値がUserDomain
		// if(registerUser.getPassword() == password){
		// //ログイン成功
		// return "itemList";
		// }else{
		// //ログイン失敗
		// return "login";
		webController.toItemList(model);
	}

}
