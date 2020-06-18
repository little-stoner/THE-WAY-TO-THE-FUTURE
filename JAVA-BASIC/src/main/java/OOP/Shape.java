package OOP;

/**

   Shape can be a base class
 */
public class Shape {

    private String type;

    public int size;
    public String name;

    public Shape() {}
    public Shape(int size, String name) {
        this.size = size;
        this.name = name;
    }

    private int getSize() {
        return size;
    }

    public void erase() {}
    public void draw() {}

    public static void doSomething(Shape shape) {
        shape.erase();
        shape.draw();
    }

    public static void main(String[] args) {
        // upcase can access the private method
        Shape c = new Circle(999, "circle");
        System.out.println(c.getSize());
        // direct access is not allowed
        Circle cc = new Circle(888, "circle");
        // this will throw exception when compile
        // if Circle don't override the method
        System.out.println(cc.getSize());
        // this will throw exception
        // System.out.println(cc.type);
        doSomething(c);
    }
}

class Circle extends Shape {
    public Circle() {}
    public Circle(int size, String name) {
        super(size, name);
    }
    public int getSize() {
        // size is inheritant from upper class
        return size;
    }

    public void erase() {
        System.out.println(this.name + " erase..... ");
    }
    public void draw() {
        System.out.println(this.name + " draw..... ");
    }
}

class Triangle extends Shape {
    
}
