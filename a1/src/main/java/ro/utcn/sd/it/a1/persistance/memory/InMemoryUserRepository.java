package ro.utcn.sd.it.a1.persistance.memory;

import ro.utcn.sd.it.a1.model.User;
import ro.utcn.sd.it.a1.persistance.api.UserRepository;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

public class InMemoryUserRepository implements UserRepository {


    private final AtomicInteger currentId = new AtomicInteger(0);
    private final Map<Integer,User > data = new ConcurrentHashMap<>();

    @Override
    public User save(User user) {
        if(user.getId() == null){
            user.setId(currentId.incrementAndGet());
        } data.put(user.getId(),user);

        return user;
    }

    @Override
    public List<User> findAll() {

        return new ArrayList<>(data.values());
    }

    @Override
    public void remove(User user) {
        data.remove(user.getId());

    }

    @Override
    public Optional<User> findById(int id) {
        return Optional.ofNullable(data.get(id));//it can be null and it transforms it into optional

    }

    @Override
    public Optional<User> findUserInfo(String username,String password) {
        User user=new User();
        if(user.getUsername().equals(username) && user.getPassword().equals(password)) {
            return Optional.ofNullable(user);
        }
        return Optional.empty();
    }




}
