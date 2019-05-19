package ro.utcn.sd.it.a1.persistance.api;

import ro.utcn.sd.it.a1.model.User;


import java.util.List;
import java.util.Optional;

public interface UserRepository {

    User save(User user);

    List<User> findAll();

    void remove(User user);

    Optional<User> findById(int id);


    Optional<User> findUserInfo(String username, String password);
}

