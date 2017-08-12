package jp.co.rakus.ec_cite.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jp.co.rakus.ec_cite.domain.User;
import jp.co.rakus.ec_cite.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;
	
	
	/**
	 * ユーザアカウントを一件新規で登録.
	 * 
	 * @param newUser
	 * 			新規登録ユーザ
	 */
	public void insertUser(User newUser) {
		userRepository.insertUser(newUser);
	}
	/**
	 * emailからユーザを一件検索.
	 * 
	 * @param email メールアドレス
	 * @return 該当ユーザ
	 */
	public User findByEmail(String email) {
		return userRepository.findByEmail(email);
	}
}
