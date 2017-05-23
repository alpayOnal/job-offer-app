package isteklifsistemi.controller;

import isteklifsistemi.Register;
import isteklifsistemi.SecurityConfig;
import isteklifsistemi.model.MeslekProfili;
import isteklifsistemi.model.User;
import isteklifsistemi.service.MeslekProfiliKatalogu;
import isteklifsistemi.service.UserKatalogu;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * Created by alpay on 5/21/17.
 */
@RestController
@RequestMapping("/api/v1/user")
public class UserController {

    private Register register;
    private UserKatalogu userKatalogu;
    private MeslekProfiliKatalogu meslekProfiliKatalogu;

    public UserController(Register register, UserKatalogu userKatalogu, MeslekProfiliKatalogu meslekProfiliKatalogu) {
        this.register = register;
        this.userKatalogu = userKatalogu;
        this.meslekProfiliKatalogu = meslekProfiliKatalogu;
    }

    @PostMapping
    public User create(@RequestBody Map<String, Object> payload) {
        User user = new User();
        user.setEmail((String) payload.get("email"));
        user.setName((String) payload.get("email"));
        user.setPasswordHashed(new BCryptPasswordEncoder().encode((String) payload.get("password")));
        user = userKatalogu.save(user);
        return user;
    }

    @PostMapping("/meslekProfili")
    public MeslekProfili create(@RequestBody MeslekProfili meslekProfili, @AuthenticationPrincipal SecurityConfig.AuthenticatedUser authenticated) {
        meslekProfili.setUser(authenticated.getUser());
        meslekProfili = register.meslekProfiliOustur(meslekProfili);
        return meslekProfili;
    }

    @DeleteMapping("/meslekProfili/{id}")
    public MeslekProfili create(@RequestBody Long id, @AuthenticationPrincipal SecurityConfig.AuthenticatedUser authenticated) {
        MeslekProfili meslekProfili = meslekProfiliKatalogu.findOne(id);
        meslekProfiliKatalogu.delete(meslekProfili);
        return meslekProfili;
    }
}
