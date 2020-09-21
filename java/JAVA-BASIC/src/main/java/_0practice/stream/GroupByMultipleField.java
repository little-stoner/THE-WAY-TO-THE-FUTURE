package _0practice.stream;

import _jackson.JacksonUtils;

import java.io.Serializable;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class GroupByMultipleField {

    static class Person implements Serializable {

        private long serialVersionUID = 1L;

        private String name;
        private int age;
        private long salary;

        Person(String name, int age, long salary) {
            this.name = name;
            this.age = age;
            this.salary = salary;
        }

        public int getAge() {
            return age;
        }

        public long getSalary() {
            return salary;
        }

        public String getName() {
            return name;
        }

        public void setAge(int age) {
            this.age = age;
        }

        public void setName(String name) {
            this.name = name;
        }

        public void setSalary(long salary) {
            this.salary = salary;
        }

        @Override
        public String toString() {
            return String.format("Person{name='%s', age=%d, salary=%d}", name, age, salary);
        }

        static class Record {
            public int age;
            public long salary;
            public Record( int age, long salary) {
                this.age = age;
                this.salary = salary;
            }

            @Override
            public String toString() {
                return "Record{" +
                        "age=" + age +
                        ", salary=" + salary +
                        '}';
            }
        }

        Record getRecord() {
            return new Record(age, salary);
        }

    }

    public static void main(String[] args) {

        Stream<Person> people = Stream.of(
                new Person("Paul", 24, 20000),
                new Person("Mark", 30, 30000),
                new Person("Will", 28, 28000),
                new Person("William", 28, 28000));

        Map<Integer, List<Person>> peopleByAge
                = people.collect(Collectors.groupingBy(p -> p.age, Collectors.mapping((Person p) -> p, Collectors.toList())));
        System.out.println(peopleByAge);
        System.out.println(JacksonUtils.toJSONString(peopleByAge));

        // group by age then group by salary
        Stream<Person> personStream =  Stream.of(
                new Person("Paul", 24, 20000),
                new Person("Mark", 30, 30000),
                new Person("Will", 28, 28000),
                new Person("Kobe", 25, 20000),
                new Person("Bryant", 22, 20000),
                new Person("Bryant", 22, 30000),
                new Person("William", 28, 28000));
        Map<Object, Map<Object, List<Person>>> peopleByAgeThenSalary
                = personStream.collect(Collectors.groupingBy(p -> p.age, Collectors.groupingBy(p -> p.salary)));
        System.out.println(JacksonUtils.toJSONString(peopleByAgeThenSalary));

        Stream<Person> recordStream =  Stream.of(
                new Person("Paul", 24, 20000),
                new Person("Mark", 30, 30000),
                new Person("Will", 28, 28000),
                new Person("Kobe", 25, 20000),
                new Person("Bryant", 22, 20000),
                new Person("Bryant", 22, 30000),
                new Person("William", 28, 28000));

        Map<Person.Record, List<Person>> map = recordStream.collect(Collectors.groupingBy(Person::getRecord));
        System.out.println(JacksonUtils.toJSONString(map));


    }



}
