package pers.jssd.syncdemo.pre;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

/**
 * CompletableFuture测试使用
 *
 * @author jssd jssdjing@gmail.com
 * @date 2020/9/18 11:03
 */
@Slf4j
public class CompletableFutureDemo {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        CompletableFuture<String> completableFuture = new CompletableFuture<>();

        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                try {
                    String s = completableFuture.get();
                    log.info("s = " + s);
                } catch (InterruptedException | ExecutionException e) {
                    e.printStackTrace();
                }
            }).start();
        }

        Thread.sleep(1000);
        completableFuture.complete("这是一个测试");
        log.info("完成测试");
    }

}
