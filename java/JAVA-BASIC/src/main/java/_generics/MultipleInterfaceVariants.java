package _generics;


interface Payable<T> {}

class Employeee implements Payable<Employee> {}

// can not do this
// class Hourly extends Employeee implements Payable<Hourly> {}

public class MultipleInterfaceVariants {
}
