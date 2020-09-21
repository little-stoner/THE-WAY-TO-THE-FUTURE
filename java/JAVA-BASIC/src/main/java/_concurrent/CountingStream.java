package _concurrent;

import java.util.stream.IntStream;

public class CountingStream {
    public static void main(String[] args) {
        System.out.println(
                IntStream.range(0, 10)
                        .parallel()
                        .mapToObj(CountingTask::new)
                        .map(ct -> {
                            try {
                                return ct.call();
                            } catch (Exception e) {
                                e.printStackTrace();
                                return null;
                            }
                        })
                        .reduce(0, Integer::sum));
    }
}
