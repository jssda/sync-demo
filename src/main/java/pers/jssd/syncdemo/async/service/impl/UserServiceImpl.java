package pers.jssd.syncdemo.async.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Service;
import pers.jssd.syncdemo.async.pojo.User;
import pers.jssd.syncdemo.async.service.UserService;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/**
 * @author jssd jssdjing@gmail.com
 * @date 2020/9/18 15:47
 */
@Slf4j
@Service
public class UserServiceImpl implements UserService {

    List<User> userList = new ArrayList<>();

    // 模拟数据库
    public UserServiceImpl() {
        for (int i = 0; i < 100; i++) {
            userList.add(User.builder().id((long) i).name("lili" + i).pwd("lilipwd" + i).build());
        }
    }

    @Async
    @Override
    public Future<User> getUserAsync(Long id) {
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            throw new IllegalStateException(e.getMessage());
        }
        User user = userList.get(id.intValue());
        log.info("user = " + user);
        return new AsyncResult<>(user);
    }

    @Async
    @Override
    public Future<String> getUserNameAsync(Long id) {
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            throw new IllegalStateException(e.getMessage());
        }
        return new AsyncResult<>(userList.get(id.intValue()).getName());
    }

    @Async
    @Override
    public void doThing() {
        try {
            TimeUnit.SECONDS.sleep(15);
        } catch (InterruptedException e) {
            throw new IllegalStateException(e.getMessage());
        }
    }
}
