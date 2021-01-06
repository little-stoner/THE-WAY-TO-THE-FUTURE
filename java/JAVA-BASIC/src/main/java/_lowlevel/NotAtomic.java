package _lowlevel;

public class NotAtomic {
    int i;
    void f1() { i++; }
    void f2() { i += 3; }
}
