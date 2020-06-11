/**

   This is about String 
   link: https://www.cnblogs.com/aspirant/p/9193112.html
 */

import java.util.*;


public class StringDemo {


    public static void main(String[] args) {

        String A = "ABC";
        String B = new String("ABC");

        // A equals B ?
        // equals means the values is the same or not.
        System.out.println(" A equals B ? " + A.equals(B));
        // A == B ?
        // == means the reference is the same or not.
        System.out.println(" A == B ? " + (A == B));

        // this will locate string in StringPool which is in
        // permanent generation
        // and all these variables point to the same location.
        String s1 = "abc";
        String s2 = "abc";
        String s3 = "abc";
        System.out.println(" s1 == s2 == s3 ? " + (s1 == s2 ? s2 == s3 : false));
        System.out.println(" s1.equals(s2).equals(s3) ? " +
                           (s1.equals(s2) ? s2.equals(s3) : false)
            );

        //
        Set<String> set = new HashSet();
        // add A can success
        System.out.println(" Add A success ? " + set.add(A));
        // add B will fail
        System.out.println(" Add B success ? " + set.add(B));

        //
        String a1 = "hello";
        String a2 = "world";
        String a3 = "helloworld";
        System.out.println(s3 == s1 + s2);                  // false
        System.out.println(s3.equals(s1+s2));               // true
        System.out.println(s3 == "hello" + "world");        // true
        System.out.println(s3.equals("hello" + "world"));   // true
        
    }
    
}

