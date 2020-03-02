package ru.spring.dao;
/*

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import ru.test.models.Login;
import ru.test.models.User;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Component
public class UserDaoImpl implements UserDao {

	@Autowired
	DataSource datasource;
	@Autowired
	JdbcTemplate jdbcTemplate;

	@Override
	@Transactional
	public User register(User user) {
		try {
			int update = jdbcTemplate.update("INSERT INTO profiles(name, password, first_name, last_name) VALUES (?, ?, ?, ?)",
					user.getName(), user.getPassword(), user.getFirstName(), user.getLastName());
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		return user;
	}

	@Transactional(readOnly = true)
	public User getUser(String name) {
		List<User> query = jdbcTemplate.query("SELECT * FROM profiles WHERE name = ? LIMIT 1", new Object[]{
				name}, new UserMapper());
		return query.size() == 0 ? null : query.get(0);
	}

	@Transactional(readOnly = true)
	public User validateUser(Login login) {
		List<User> query = jdbcTemplate.query("SELECT * FROM profiles WHERE name = ? AND password = ? LIMIT 1", new Object[]{
				login.getName(), login.getPassword()}, new UserMapper());
		return query.size() == 0 ? null : query.get(0);
	}

	class UserMapper implements RowMapper<User> {
		public User mapRow(ResultSet rs, int arg1) throws SQLException {
			User user = new User();
			user.setName(rs.getString("name").trim());;
			user.setPassword(rs.getString("password"));
			user.setFirstName(rs.getString("first_name"));
			user.setLastName(rs.getString("last_name"));
			return user;
		}
	}
}
*/
