package _clone;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * @author viber
 */

public class CloneInterface {

    static class EX implements Cloneable {
        private String name;
        private final List<String> list;
        public EX(String name) {
            this.name = name;
            this.list = new ArrayList<>();
        }
        public EX(EX ex) {
            this.name = ex.name;
            this.list = new ArrayList<>(ex.list);
        }
    }

    static class Family implements Cloneable {
        private String name;
        public Family(String name) {
            System.out.println(">>>>>>>>>> construct family");
            this.name = name;
        }
        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        @Override
        protected Family clone() throws CloneNotSupportedException {
            return (Family)super.clone();
        }

        @Override
        public String toString() {
            return "Family{" +
                    "name='" + name + '\'' +
                    '}';
        }
    }
    static class Dog implements Cloneable {
        private String name;
        private int age;
        private Family family;
        public Dog(String name, int age, Family family) {
            System.out.println("============> construct dog");
            this.name = name; this.age = age; this.family = family;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        public Family getFamily() {
            return family;
        }

        public void setFamily(Family family) {
            this.family = family;
        }

        @Override
        protected Dog clone() throws CloneNotSupportedException {
            Dog d = (Dog) super.clone();
            d.family = this.family.clone();
            return d;
        }

        @Override
        public String toString() {
            return "Dog{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    ", family=" + family +
                    '}';
        }
    }

    public static void main(String[] args) throws Exception {
        Family family = new Family("L");
        Dog d = new Dog("T", 12, family);
        System.out.println(" >>>>>>>>>>> start clone <<<<<<<<<<<<<< ");
        Dog nd = d.clone();
        System.out.println(d);
        System.out.println(nd);
        // they are not equal
        System.out.println(Objects.equals(d, nd));
        // modify family
        nd.getFamily().setName("S");
        System.out.println(d);
        System.out.println(nd);

    }

}
