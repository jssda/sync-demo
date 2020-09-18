package pers.jssd.syncdemo.pre;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

/**
 * thenCompose方法测试
 *
 * @author jssd jssdjing@gmail.com
 * @date 2020/9/18 14:18
 */
@Slf4j
public class ThenComposeDemo {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ThenComposeDemo composeDemo = new ThenComposeDemo();

        CompletableFuture<CompletableFuture<String>> completableFutureCompletableFuture = composeDemo.getUser().thenApply(
                composeDemo::getName);
        String s = completableFutureCompletableFuture.get().get();
        System.out.println("s = " + s);


        CompletableFuture<String> completableFuture = composeDemo.getUser().thenCompose(composeDemo::getName);
        String s1 = completableFuture.get();
        System.out.println("s1 = " + s1);

    }


    public CompletableFuture<User> getUser() {
        return CompletableFuture.supplyAsync(() -> new User("gold", "1"));
    }

    public CompletableFuture<String> getName(User user) {
        return CompletableFuture.supplyAsync(user::getName);
    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    private static class User {
        String name;
        String id;
    }

}
