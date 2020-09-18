package pers.jssd.syncdemo.pre;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

/**
 * AllOf方法测试
 *
 * @author jssd jssdjing@gmail.com
 * @date 2020/9/18 17:34
 */
@Slf4j
public class AllOfDemo {

    private String getProductBaseInfo(String productId) {
        log.info("获取基本信息");
        return productId + "商品基础信息";
    }

    private String getProductDetailInfo(String productId) {
        log.info("获取详情信息");
        return productId + "商品详情信息";
    }

    private String getProductSkuInfo(String productId) {
        log.info(" 获取sku信息");
        return productId + "商品sku信息";
    }

    public String getAllInfoByProductId(String productId) {
        //取得一个商品的所有信息（基础、详情、sku）
        CompletableFuture<String> f1 = CompletableFuture.supplyAsync(() -> getProductBaseInfo(productId));
        CompletableFuture<String> f2 = CompletableFuture.supplyAsync(() -> getProductDetailInfo(productId));
        CompletableFuture<String> f3 = CompletableFuture.supplyAsync(() -> getProductSkuInfo(productId));
        //等待三个数据源都返回后，再组装数据。这里会有一个线程阻塞
        CompletableFuture.allOf(f1, f2, f3).join();

        try {
            String baseInfo = f1.get();
            String detailInfo = f2.get();
            String skuInfo = f3.get();
            return baseInfo + "" + detailInfo + skuInfo;
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args) {
        AllOfDemo allOfDemo = new AllOfDemo();
        log.info(allOfDemo.getAllInfoByProductId("1231432"));
    }


}
