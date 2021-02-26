package _efectivejava.chapter3.item10;


import java.util.*;

public class CaseInsensitiveString {

    private final String s;

    public CaseInsensitiveString(String s) {
        this.s = Objects.requireNonNull(s);
    }

//    @Override public boolean equals(Object o) {
//        if (o instanceof CaseInsensitiveString) {
//            return s.equalsIgnoreCase(
//                ((CaseInsensitiveString) o).s);
//        }
//        if (o instanceof String) {
//            return s.equalsIgnoreCase((String) o);
//        }
//        return false;
//    }

    @Override public boolean equals(Object o) {
        return o instanceof CaseInsensitiveString &&
                ((CaseInsensitiveString) o).s.equalsIgnoreCase(s);
    }

    public static void main(String[] args) {
        CaseInsensitiveString cis = new CaseInsensitiveString("Polish");
        String s = "polish";

        System.out.println(">>>> " + cis.equals(s));
        System.out.println(">>>> " + s.equals(cis));

        List<CaseInsensitiveString> list = new ArrayList<>();
        list.add(cis);

        List<String> l0 = new ArrayList<>();
        l0.add("polish");

        System.out.println(list.contains(s));
        System.out.println(l0.contains(cis));        
    }
    
}
