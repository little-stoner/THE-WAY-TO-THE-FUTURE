package _objects;

public class Employee {
    private int ID;
    private String name;
    private int age;
    private static int counter = 1;
    public Employee(String name, int age) {
        this.name = name;
        this.age = age;
        this.ID = counter++;
    }

    public void show() {
        System.out.println("ID= " + ID + " Name: " + name + " Age: " + age);
    }
    public void showNextId() {
        System.out.println("Next ID: " + counter);
    }

    @Override
    protected void finalize() throws Throwable {
        counter--;
    }

    public static void main(String[] args) {
        Employee E = new Employee("GFG1", 23);
        Employee F = new Employee("GFG2", 39);
        Employee G = new Employee("GFG3", 40);

        E.show();F.show();G.show();

        E.showNextId();F.showNextId();G.showNextId();

        {
            Employee X=new Employee("GFG4",23);
            Employee Y=new Employee("GFG5",21);
            X.show();
            Y.show();
            X.showNextId();
            Y.showNextId();
            X = Y = null;
            System.gc();
            System.runFinalization();
        }

        E.showNextId();

    }


}
