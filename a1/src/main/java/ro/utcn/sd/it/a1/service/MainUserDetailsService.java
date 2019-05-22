package ro.utcn.sd.it.a1.service;


import lombok.RequiredArgsConstructor;
import org.springframework.security.core.authority.SimpleGrantedAuthority;


import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import ro.utcn.sd.it.a1.persistance.api.RepositoryFactory;



import ro.utcn.sd.it.a1.model.User;



import java.util.Collections;

@Service
@RequiredArgsConstructor
public class MainUserDetailsService implements UserDetailsService {
    private final RepositoryFactory repository;

    @Override
    public UserDetails loadUserByUsername(String username) {
        User user = repository.createUserRepository().findByName(username);

        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(),
                Collections.singletonList(new SimpleGrantedAuthority("ROLE_MAINUSER")));
    }

    /*
    @Transactional
    public User loadCurrentUser() {
        String name = SecurityContextHolder.getContext().getAuthentication().getName();
        return repository.createUserRepository().findByName(name).orElseThrow(NotFoundException::new);
    }
    */
}