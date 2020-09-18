package pers.jssd.syncdemo.pre;

import java.util.concurrent.CompletableFuture;

/**
 * ThenAccept方法使用
 *
 * @author 王京京 wangjingjing@bonc.com.cn
 * @date 2020/9/18 14:06
 */
public class ThenAcceptDemo {

    public static void main(String[] args) {
        CompletableFuture.supplyAsync(() -> "Hello joye").thenAccept(System.out::println);
    }

}
