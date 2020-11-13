import com.alibaba.fastjson.JSON;

public class FJSONDemo {

    static class A {

        String name;
        Integer age;
        int m;

        public void setName(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

        public void setAge(Integer age) {
            this.age = age;
        }

        public Integer getAge() {
            return age;
        }

        public int getM() {
            return m;
        }

        public void setM(int m) {
            this.m = m;
        }

        @Override
        public String toString() {
            return "A{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    ", m=" + m +
                    '}';
        }
    }

    public static void main(String[] args) {
        A a = new A();
        a.name = "A";
        a.age = 12;
        System.out.println(JSON.toJSONString(a));

        System.out.println(a);

        a.age = null;
        System.out.println(JSON.toJSONString(a));
        System.out.println(a);

    }
}
