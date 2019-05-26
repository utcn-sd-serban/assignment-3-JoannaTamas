package ro.utcn.sd.it.a1.Controller;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import ro.utcn.sd.it.a1.model.User;
import ro.utcn.sd.it.a1.service.MainUserDetailsService;

@RestController
@RequiredArgsConstructor
public class UserController {
    private final MainUserDetailsService service;

    @GetMapping("/me")
    public User readCurrent(){
        return service.loadCurrentUser();
    }

}
