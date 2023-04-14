package _generics.faq;

import _generics.faq.entity.Pair;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

public class WildType {

    public void compare() {
        Collection<Pair<String,Object>> c = new ArrayList<>();
        // c.add(new Pair<String, Date> ("today", new Date())); // error: illegal argument type
        c.add(new Pair<String,Object>("today", new Date()));
        // c.add(new Pair<String,String>("name","Pete Becker")); // error: illegal argument type
        c.add(new Pair<String,Object>("name","Pete Becker"));

        Collection<Pair<String,?>> cc = new ArrayList<Pair<String,?>>();
        cc.add(new Pair<String,Date> ("today", new Date()));
        cc.add(new Pair<String,Object>("today", new Date()));
        cc.add(new Pair<String,String>("name","Pete Becker"));
        cc.add(new Pair<String,Object>("name","Pete Becker"));

    }

}
