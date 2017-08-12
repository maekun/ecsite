package jp.co.rakus.ec_cite.controller;

import org.postgresql.util.PSQLException;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import jp.co.rakus.ec_cite.domain.User;
import jp.co.rakus.ec_cite.service.UserService;

/**
 * ユーザアカウント登録やログイン時の会員判定を担当するコントローラクラス.
 * 
 * @author hiroki.mae
 *
 */
@Controller
@RequestMapping("")
public class UserController {
	
	@ModelAttribute
	public UserForm setUserFormUp() {
		return new UserForm();
	}
	
	@Autowired
	private UserService userService;

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
	
	/**
	 * 新規ユーザ登録.
	 * 
	 * @param form
	 * @param bindingResult
	 * @param redirectAttributes
	 * @param model
	 * @return ログイン画面へ遷移
	 */
	@RequestMapping("/register")
	public String register(
			@Validated UserForm form,BindingResult bindingResult,
			RedirectAttributes redirectAttributes,Model model) {
		
		if(bindingResult.hasErrors()) {
			return toRegisterForm();
		}
		User newUser = new User();
		BeanUtils.copyProperties(form, newUser);
		
		String password = form.getPassword();
		String checkPassword = form.getCheckPassword();
		
		if(!(password.equals(checkPassword))) {
			model.addAttribute("PasswordCheckMessage", "入力したパスワードと確認用パスワードが一致しません");
			return toRegisterForm();
		}
		
		//登録情報が重複していた場合登録フォームに遷移
		try {
			userService.insertUser(newUser);
			
		} catch (Exception e) {
			model.addAttribute("SqlErrorMessage", "すでに存在するユーザです");
			return toRegisterForm();
		}
		
		return "redirect:/loginForm";
	}
}
