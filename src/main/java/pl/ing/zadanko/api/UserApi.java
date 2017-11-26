package pl.ing.zadanko.api;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
public class UserApi {

    @RequestMapping("/user")
    public Principal user(Principal user) {
        return user;
    }


}
