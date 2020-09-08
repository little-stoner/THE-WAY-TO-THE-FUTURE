
public class GenericType<X, Y, Z> {

    static class Pair<X,Y> {
	private X first;
	private Y second;
	public Pair(X a1, Y a2) {
	    first = a1;
	    second = a2;	    
	}
	public X getFirst() { return first; }
	public Y getSecond() { return second; }
	public void setFirst(X arg) { first = arg; }
	public void setSecond(Y arg) { second = arg; }
    }

    public static void main(String[] args) {
	Pair<String, Long> pair = new Pair<>("hello", 12L);

	Pair<String, String>[] arr = null;
	arr = (Pair<String, String>[]) new Pair[10];

    }
    
}
