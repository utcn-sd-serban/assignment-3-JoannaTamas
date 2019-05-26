package ro.utcn.sd.it.a1.seed;


import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import ro.utcn.sd.it.a1.model.User;
import ro.utcn.sd.it.a1.persistance.api.RepositoryFactory;
import ro.utcn.sd.it.a1.persistance.api.UserRepository;


@Component
@RequiredArgsConstructor
@Order(Ordered.HIGHEST_PRECEDENCE)
public class UserSeed implements CommandLineRunner {
    private final RepositoryFactory  userRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    @Transactional
    public void run(String... args) throws Exception{
        User user1 = new User(2, "ioana", passwordEncoder.encode("poop"));
        userRepository.createUserRepository().save(user1);

       // System.out.println(user1.getPassword());
       // UserRepository repo=userRepository.createUserRepository();
       // if (repo.findAll().isEmpty()) {
          //  repo.save(new User(2, "john", "poop"));
      //  }
       // User john=new User(2,"john","poop");
        //userRepository.createUserRepository().save(john);




    }

    @Transactional
    public void clear() {


    }
}