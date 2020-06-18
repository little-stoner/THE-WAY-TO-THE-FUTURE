
// ATypeName
// In this case, EX3 is a class (which is a type of objects)

public class EX3 {


    public static void main(String[] args) {

        try {
            Class<?> c = Class.forName("EX3");
            System.out.println(" class name: " + c.getSimpleName());
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }
    
}
