package in.pedaxx.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class UserDao {

	@Autowired
	private JdbcTemplate jdbctemplate;

	public boolean inserdb(User user) {

		String sql = " insert into user( name, mobile , email , password) values( ? , ? , ? , ?  )  ";

		jdbctemplate.update(sql, user.getName(), user.getMobile(), user.getPassword(), user.getPassword());

		return true;

	}

	public boolean authenticate(User user) {

		// important for query for object * is imp in query .
		String sql = " select * from user where email=? and password=?   ";

		boolean bool = false;
		try {
			User userdb = jdbctemplate.queryForObject(sql, new Object[] { user.getEmail(), user.getPassword() },
					new UserRowmapper());
			bool = true;

		} catch (Exception e) {
			bool = false;

		}

		return bool;
	}

}
