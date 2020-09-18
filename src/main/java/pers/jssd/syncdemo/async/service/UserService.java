package pers.jssd.syncdemo.async.service;

import org.springframework.scheduling.annotation.Async;
import pers.jssd.syncdemo.async.pojo.User;

import java.util.concurrent.Future;

/**
 * @author jssd jssdjing@gmail.com
 * @date 2020/9/18 15:46
 */
public interface UserService {

    Future<User> getUserAsync(Long id);

    Future<String> getUserNameAsync(Long id);

    @Async
    void doThing();
}
