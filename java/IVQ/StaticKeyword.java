
public class StaticKeyword {

    // static is a Non-Access Modifier. Static can be applied to variable, method, nested class and blocks(static block).
    
    public static void main(String args[]) 
        {
            //Assign Child class object to Parent reference
            Parent pc = new Child();
            pc.display();
            Child p = new Child();
            p.display();
            new test();
        }

    static class Parent 
    {
        public static void display()
            {
                System.out.println("Welcome to Parent Class");
            }
    }
    public static class Child extends Parent
    {
        public static void display()
            {
                System.out.println("Welcome to Child class");
            }
    }

    static {
        System.out.println("=========> ");
    }

    static class test
    {
        static int val;
        static
            {
                System.out.println(val);
                val = 100;
                System.out.println(val);                
            }
    }

    public class Users 
    {
        static class VipUsers
        {
            public void displayVipUsers()
                {
                    System.out.println("Welcome Vip User");
                }
        }
        class NormalUsers
        {
            public void displayNormalUsers()
                {
                    System.out.println("Welcome Normal User");
                }
        }
    
        public static void main(String args[])
            {
                //Nested static class doesn't require instantiation of the outer class
                Users.VipUsers vip = new Users.VipUsers();
                vip.displayVipUsers();
        
                /*Below line will throw error as the non-static class require 
                  instantiaion of the outer class
                  Users.NormalUsers normal = new Users.NormalUsers();*/
        
                //Nested non-static class require instantiation of the outer class
                Users users = new Users();
                Users.NormalUsers normal = users.new NormalUsers();
                normal.displayNormalUsers();
            }
    }
    
    
}
