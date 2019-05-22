package ro.utcn.sd.it.a1.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import ro.utcn.sd.it.a1.model.User;
import ro.utcn.sd.it.a1.persistance.api.RepositoryFactory;

import javax.transaction.Transactional;
import java.util.Optional;



@Component
@Service
@RequiredArgsConstructor
public class UserManagementSystem {
    private final RepositoryFactory repositoryFactory;


    @Transactional
    public User findByUsername (String username) {
        return repositoryFactory.createUserRepository().findByName(username);

    }

}
