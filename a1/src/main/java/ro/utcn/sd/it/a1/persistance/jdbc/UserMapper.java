package ro.utcn.sd.it.a1.persistance.jdbc;


import org.springframework.jdbc.core.RowMapper;
import ro.utcn.sd.it.a1.model.User;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserMapper implements RowMapper<User> {

    @Override
    public User mapRow(ResultSet rs,int rowNum) throws SQLException {
        return new User(rs.getInt("id"),
                rs.getString("username"),
                rs.getString("password"));
    }


}



