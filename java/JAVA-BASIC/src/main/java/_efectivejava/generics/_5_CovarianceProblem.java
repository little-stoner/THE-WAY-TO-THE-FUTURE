package _efectivejava.generics;

import java.util.ArrayList;
import java.util.List;

public class _5_CovarianceProblem {

    public static void main(String[] args) {
        // array is covariance in java
        Object a = new String[] { "a", "b", "c" };
        // generic is not covariance
        // List<Object> b = new ArrayList<String>();
    }

}
