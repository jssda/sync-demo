package pers.jssd.syncdemo.pre;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

/**
 * ThenApply的使用可以回调CompletableFuture产生的结果, 对结果进行更改
 *
 * @author jssd jssdjing@gmail.com
 * @date 2020/9/18 11:31
 */
@Slf4j
public class ThenApplyDemo {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        CompletableFuture<String> whatsYourNameFuture = CompletableFuture.supplyAsync(() -> {
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "Rajeev";
        });

        CompletableFuture<String> completableFuture = whatsYourNameFuture.thenApply(name -> "hello" + name);
        log.info(completableFuture.get());

    }

}
