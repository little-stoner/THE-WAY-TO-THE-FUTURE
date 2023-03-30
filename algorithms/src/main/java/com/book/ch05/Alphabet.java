package com.book.ch05;

public class Alphabet {

     enum Radix {
         BINARY(2),
         DNA(4),
         OCTAL(8),
         DECIMAL(10),
         HEXADECIMAL(16),
         PROTEIN(20),
         LOWERCASE(26),
         UPPERCASE(26),
         BASE64(64),
         ASCII((int) Math.pow(2, 7)),
         EXTENDED_ASCII((int) Math.pow(2, 8)),
         UNICODE16((int) Math.pow(2, 16)),
         ;
         private int radix;
         Radix(int radix) {
             this.radix = radix;
         }
    }

    public Alphabet() {

    }

    public Alphabet(String s) {

    }

    public char toChar(int index) {
        return 0;
    }

    public int toIndex(char c) {
        return 0;
    }

    public boolean contains(char c) {
        return true;
    }

    public int R() {
        return 0;
    }

    public int lgR() {
        return 0;
    }

    public int[] toIndices(String s) {
        return null;
    }

    public String toChars(int[] indices) {
        return null;
    }



}
