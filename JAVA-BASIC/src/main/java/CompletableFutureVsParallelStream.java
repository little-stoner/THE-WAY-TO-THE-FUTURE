import java.util.*;
import java.util.concurrent.*;


public class CompletableFutureVsParallelStream {


    public static void sendEmailToCustomers(String promotion) {
        try {
            Thread.sleep(1000);
            System.out.println(" Email sent to Customer for promotion: " + promotion);
        } catch (Exception e) {

        }
    }

    public static void sendEmailToTheBoss(String promotion) {
        try {
            Thread.sleep(1000);
            System.out.println(" Email sent to Boss for promotion: " + promotion);
        } catch (Exception e) {

        }
    }


    public static void main(String[] args) throws InterruptedException {
        List<String> promotions = Arrays.asList("Pizza Discount", "Beer Discount", "Coke Discount", "Service Discount");
        // old(promotions);
        //  ps(promotions);
        cf(promotions);
    }

    public static void old(List<String> promotions) {
        for (String promotion : promotions) {
            promotion = promotion + "30%";
            promotion = promotion + " Valid only today ";
            sendEmailToCustomers(promotion);
        }
        sendEmailToTheBoss("Today discount is 39%");
    }

    public static void ps(List<String> promotions) throws InterruptedException {
        promotions.parallelStream()
                .map(promotion -> promotion + " 30% ")
                .map(promotion -> promotion + " Valid only Today ")
                .forEach(promotion -> sendEmailToCustomers(promotion));
        sendEmailToTheBoss("Today discount was 30%");
    }

    public static void cf(List<String> promotions) throws InterruptedException {
        CompletableFuture[] futures = promotions.stream()
                .map(promotion -> CompletableFuture.supplyAsync(() -> promotion + " 30%"))
                .map(future -> future.thenApplyAsync(pro -> pro + " Valid only Today"))
                .map(future -> future.thenAcceptAsync(pro -> {
                    sendEmailToCustomers((String) pro);
                }))
                .toArray(CompletableFuture[]::new);
        sendEmailToTheBoss("Today discount was 30%");
        CompletableFuture.allOf(futures).join();
    }

}
