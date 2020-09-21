package _efectivejava.generics;

public class StaticGenericMethod {

    public static <T> void hold(T input) {
        System.out.println(" parameter type T: " + input.getClass());
    }

    public static class Kobe<T> {
	public void test(T input) {
	    System.out.println(" parameter type T: " + input.getClass());
	}
	public static <T> void h(T input) {
	    System.out.println(" parameter type T: " + input.getClass());  
	}
    }

    public static void main(String[] args) {

	hold("KKK");
		StaticGenericMethod.hold("YYY");
		StaticGenericMethod.hold(123);
		StaticGenericMethod.<String>hold("XXXX");
		StaticGenericMethod.<Integer>hold(456);
	System.out.println(">>>>>>>>");
	Kobe.h("Gianna");
	Kobe.<String>h("Bryant");
	Kobe.h(567);
	Kobe.<Integer>h(789);
	
    }

    

}
