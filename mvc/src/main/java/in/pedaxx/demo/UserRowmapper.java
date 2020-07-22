package in.pedaxx.demo;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class UserRowmapper implements RowMapper<User> {

	@Override
	public User mapRow(ResultSet rs, int rowNum) throws SQLException {

		User user = new User();

		user.setId(rs.getInt("id"));
		user.setName(rs.getString("name"));
	
		return user;
	}

}
