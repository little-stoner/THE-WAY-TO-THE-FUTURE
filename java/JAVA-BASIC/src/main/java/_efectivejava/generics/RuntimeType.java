package _efectivejava.generics;

import java.util.*;

public class RuntimeType {

    public static void main(String[] args) {

	System.out.println("runtime type of ArrayList<String>: " +
			   new ArrayList<String>().getClass());
	System.out.println("runtime type of ArrayList<Long>: " +
			   new ArrayList<Long>().getClass());	



    }
    
}
