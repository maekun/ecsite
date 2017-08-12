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

	@ModelAttribute
	public LoginForm setLoginFormUp() {
		return new LoginForm();
	}

	@Autowired
	private UserService userService;

	/**
	 * ログイン画面へ遷移
	 * 
	 * @return
	 */
	@RequestMapping("/loginForm")
	public String toLoginForm() {

		return "loginForm";
	}

	/**
	 * 新規登録画面へ遷移.
	 * 
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
	public String register(@Validated UserForm form, BindingResult bindingResult, RedirectAttributes redirectAttributes,
			Model model) {

		if (bindingResult.hasErrors()) {
			return toRegisterForm();
		}

		String password = form.getPassword();
		String checkPassword = form.getCheckPassword();
		if (!(password.equals(checkPassword))) {
			model.addAttribute("PasswordCheckMessage", "入力したパスワードと確認用パスワードが一致しません");
			return toRegisterForm();
		}

		User newUser = new User();
		BeanUtils.copyProperties(form, newUser);

		// 登録情報が重複していた場合登録フォームに遷移
		try {
			userService.insertUser(newUser);

		} catch (Exception e) {
			model.addAttribute("SqlErrorMessage", "すでに存在するユーザです");
			return toRegisterForm();
		}

		return "redirect:/loginForm";
	}

	/**
	 * 登録済みユーザならログインさせる.
	 * 
	 * @param form
	 *            入力情報
	 * @param bindingResult
	 * @param model
	 * @return 商品一覧画面
	 */
	@RequestMapping("/login")
	public String login(@Validated LoginForm form, BindingResult bindingResult,
			RedirectAttributes redirectAttributes,Model model) {

		if (bindingResult.hasErrors()) {

			// debug
			System.out.println("bindingresult.haserrors");

			return toLoginForm();
		}

		String password = form.getPassword();
		String checkPassword = form.getCheckPassword();
		if (!(password.equals(checkPassword))) {

			// debug
			System.out.println("passwordcheckmessage");

			model.addAttribute("PasswordCheckMessage", "入力したパスワードと確認用パスワードが一致しません");
			return toLoginForm();
		}

		String inputEmail = form.getEmail();
		String inputPassword = form.getPassword();
		User user = new User();

		// 入力されたメールアドレスが登録されているか判定
		try {

			user = userService.findByEmail(inputEmail);

		} catch (Exception e) {

			// debug
			System.out.println("trycatch");

			model.addAttribute("LoginErrorMessage", "そのユーザは存在しません");
			return toLoginForm();
		}

		// DBから取り出したユーザ情報と入力されたパスワードが一致すればログインする
		if (user.getPassword().equals(inputPassword)) {
			// ログイン成功

			// debug
			System.out.println(user.getLastName() + "です");

			redirectAttributes.addFlashAttribute("user", user);
			return "redirect:/web/index";
		} else {
			// ログイン失敗

			// debug
			System.out.println("ログイン失敗");

			model.addAttribute("PasswordCheckMessage", "パスワードが間違っています");
			return toLoginForm();
		}
	}
}
