package jp.co.rakus.ec_cite.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import jp.co.rakus.ec_cite.domain.User;

@Repository
public class UserRepository {

	@Autowired
	private NamedParameterJdbcTemplate template;
	
	@Autowired
	private static final RowMapper<User> userRowMapper = (rs,i) -> {
		User user = new User();
		user.setId(rs.getInt("id"));
		user.setFirstName(rs.getString("first_name"));
		user.setLastName(rs.getString("last_name"));
		user.setEmail(rs.getString("email"));
		user.setPassword(rs.getString("password"));
		user.setLogging(rs.getBoolean("is_logging"));
		return user; 
	};
	
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
	
	/**
	 * emailからユーザを一件検索.
	 * 
	 * @param email メールアドレス
	 * @return 該当ユーザ
	 */
	public User findByEmail(String email) {
		String sql = "select id,first_name,last_name,email,password,is_logging from users where email = :email ;";
		SqlParameterSource paramMap = new MapSqlParameterSource().addValue("email", email);
		User user = template.queryForObject(sql, paramMap, userRowMapper);
		return user;
	}
	
	
}
