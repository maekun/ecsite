package jp.co.rakus.ec_cite.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * ユーザアカウント登録やログイン時の会員判定を担当するコントローラクラス.
 * 
 * @author hiroki.mae
 *
 */
@Controller
@RequestMapping("")
public class UserController {

	/**
	 * ログイン画面へ遷移
	 * @return
	 */
	@RequestMapping("/loginForm")
	public String toLoginForm() {
		
		return "loginForm";
	}
	
	/**
	 * 新規登録画面へ遷移.
	 * @return
	 */
	@RequestMapping("/registerForm")
	public String toRegisterForm() {
		return "registerForm";
	}
}
