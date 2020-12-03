package _onjava8._hiding;

import _onjava8._hiding.cookie2.Cookie;

public class ChocolateChipZ extends Cookie {
    public ChocolateChipZ(){
        System.out.println(
                "ChocolateChip2 constructor"
        );
    }
    public void chomp() { bite(); }

    public static void main(String[] args) {
        ChocolateChipZ x = new ChocolateChipZ();
        x.chomp();
    }
}
