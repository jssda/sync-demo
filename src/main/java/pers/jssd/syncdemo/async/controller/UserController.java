package pers.jssd.syncdemo.async.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pers.jssd.syncdemo.async.pojo.User;
import pers.jssd.syncdemo.async.service.UserService;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

/**
 * @author jssd jssdjing@gmail.com
 * @date 2020/9/18 16:12
 */
@RestController
@RequestMapping("/api/v1/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {this.userService = userService;}

    @GetMapping
    public User getUser() throws ExecutionException, InterruptedException {
        Future<User> userAsync = userService.getUserAsync(1L);
        return userAsync.get();
    }

    @GetMapping("/doThing")
    public void doThing() {
        userService.doThing();
    }
}
