package pers.jssd.syncdemo.pre;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

/**
 * 异步运行并返回结果
 *
 * @author jssd jssdjing@gmail.com
 * @date 2020/9/18 11:18
 */
@Slf4j
public class SupplyAsyncDemo {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        CompletableFuture<Object> future = CompletableFuture.supplyAsync(() ->{
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            log.info("run end");
            return "this is a result";
        });

        Object o = future.get();
        System.out.println("o = " + o);
    }
}
