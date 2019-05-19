package ro.utcn.sd.it.a1.persistance.jdbc;


import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import ro.utcn.sd.it.a1.model.User;
import ro.utcn.sd.it.a1.persistance.api.UserRepository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import static org.apache.logging.log4j.ThreadContext.isEmpty;

@RequiredArgsConstructor
public class JdbcUserRepository implements UserRepository {
    private final JdbcTemplate template;

    @Override
    public User save(User user)
    {
        if(user.getId()==null){
            user.setId(insert(user));
        }else {
            update(user);
        }
        return user;
    }


    @Override
    public List<User> findAll() {
        return template.query("SELECT * FROM user", new UserMapper());

    }

    @Override
    public void remove(User user) {
        template.update("DELETE FROM user WHERE id = ?", user.getId());

    }

    @Override
    public Optional<User> findById(int id) {

        List<User> users = template.query("SELECT * FROM user WHERE id = ?", new UserMapper(), id);
        return users.isEmpty() ? Optional.empty() : Optional.ofNullable(users.get(0));
    }

    @Override
    public Optional<User> findUserInfo(String username, String password) {

        List<User> userInfo = template.query("SELECT * FROM users WHERE username = ? AND password = ?",
                new UserMapper(), username, password);
        return userInfo.isEmpty() ? Optional.empty() : Optional.of(userInfo.get(0));

    }
    private void update(User user) {
        template.update( "UPDATE  user SET username=? AND password=? WHERRE id=?",
                user.getUsername(),user.getPassword());

    }

    private int insert(User user) {

        SimpleJdbcInsert insert= new SimpleJdbcInsert(template);
        insert.setTableName("user");
        insert.setGeneratedKeyName("id");

        Map<String, Object> data=new HashMap<>();
        data.put( "username", user.getUsername());
        data.put( "password",user.getPassword());

        return insert.executeAndReturnKey(data).intValue();
    }




}
