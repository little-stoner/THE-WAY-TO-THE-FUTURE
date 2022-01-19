package _concurrency.jcip;

import java.math.BigInteger;

interface Computable<A, V> {
    V compute(A arg) throws InterruptedException;
}
public class ExpensiveFunction implements Computable<String, BigInteger> {

    @Override
    public BigInteger compute(String arg) throws InterruptedException {
        return new BigInteger(arg);
    }

}
