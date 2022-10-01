package _operator;

public class Literals {

    public static void main(String[] args) {
        int i1 = 0x2f;
        System.out.println("i1: " + Integer.toBinaryString(i1));
        int i2 = 0X2F;
        System.out.println("i2: " + Integer.toBinaryString(i2));

        int i3 = 0177;
        System.out.println("i3: " + Integer.toBinaryString(i3));

        char c = 0xffff;
        System.out.println("c: " + Integer.toBinaryString(c));

        byte b = 0x7f;
        System.out.println("b: " + Integer.toBinaryString(b));

        short s = 0x7fff;
        System.out.println("s: " + Integer.toBinaryString(s));

        long n1 = 200L;
        System.out.println(" n1: " + n1);
        long n2 = 200l;
        long n3 = 200;

        byte blb = (byte)0b00110101;
        System.out.println("blb: " + Integer.toBinaryString(blb));

        short bls = (short)0B0010111110101111;
        System.out.println("bls: " + Integer.toBinaryString(bls));

        float f1 = 1;
        System.out.println(" f1: " + f1);
        float f2 = 1F;
        float f3 = 1f;
        double d1 = 1d;
        System.out.println(" d1: " + d1);
        double d2 = 1D;
        double d3 = 1;

    }

}
