package jp.co.rakus.ec_cite.repository;

import org.postgresql.util.PSQLException;
import org.postgresql.util.ServerErrorMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import jp.co.rakus.ec_cite.domain.User;

@Repository
public class UserRepository {

	@Autowired
	private NamedParameterJdbcTemplate template;
	
	/**
	 * ユーザアカウントを一件新規で登録.
	 * 
	 * @param newUser
	 * 			新規登録ユーザ
	 */
	public void insertUser(User newUser) {
		
		SqlParameterSource param = new BeanPropertySqlParameterSource(newUser);
		String sql = "INSERT INTO users (first_name,last_name,email,password) values (:firstName,:lastName,:email,:password) ;";

		template.update(sql, param);
	}
}
