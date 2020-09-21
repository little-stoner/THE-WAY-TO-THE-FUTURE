// 
// 
// when it's appropriate to ovrride equals?
//


import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class EqualsVsHashCode {

    public static void main(String[] args) {

        People p0 = new People("KOBE", "male");
        People p1 = new People("KOBE", "male");

        System.out.println(" p0 equals p1 : " + Objects.equals(p0, p1));

        System.out.println(" p0 hashCode: " + p0.hashCode());
        System.out.println(" p1 hashCode: " + p1.hashCode());


        PP p2 = new PP("KOBE", "male");
        PP p3 = new PP("KOBE", "male");
        System.out.println(" p2 equals p3 : " + Objects.equals(p2, p3));

        Set<PP> ppSet = new HashSet<>();
        ppSet.add(p2);
        ppSet.add(p3);
        System.out.println(ppSet);


    }

}

class People {
    private String name;
    private String sex;
    public People(String name, String sex) {
        this.name = name;
        this.sex = sex;
    }

}

class PP {
    private String name;
    private String sex;
    public PP(String name, String sex) {
        this.name = name;
        this.sex = sex;
    }
    @Override
    public boolean equals(Object o) {
        if (o instanceof PP) {
            PP p = (PP) o;
            return Objects.equals(this.name, p.name)
                    && Objects.equals(this.sex, p.sex);
        }
        return false;
    }

    @Override
    public String toString() {
        return "PP{" +
                "name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                '}';
    }
}
