
// exception
// try、catch、throw、throws 、finally
// what they represent and how to use them
// link: https://blog.csdn.net/jin970505/article/details/78418677
//       https://blog.csdn.net/u011277123/article/details/59074492?utm_medium=distribute.pc_relevant.none-task-blog-baidujs-5
//       https://stackoverflow.com/questions/15225819/try-catch-finally-return-clarification

class Exception1 extends Exception {
    public Exception1() {
        super("This is Exception1");
    }
}

class Exception2 extends Exception {
    public Exception2() {
        super("This is Exception2");
    }
}

public class TryCatchFinnallyDemo {
    public static void main(String[] args) {
        try {
            test();
        } catch (Exception1 e) {
            System.out.println(e.getMessage());
        } catch (Exception2 e) {
            System.out.println(e.getMessage());
        }
    }

    public static void test() throws Exception1, Exception2 {
        try {
            throw new Exception1();
        } catch (Exception1 e) {
            System.out.println("catch Exception1");
            throw e;
        } finally {
            try {
                throw new Exception2();
            } catch (Exception2 e) {
                System.out.println("catch Exception2");
                // if finally throw exception2 then exception1 whill lose
                // 
                // throw e;
            }
        }
    }
}