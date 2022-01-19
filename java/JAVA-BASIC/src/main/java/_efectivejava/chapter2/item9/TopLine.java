package _efectivejava.chapter2.item9;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * @author viber
 */
public class TopLine {

    static String firstLineOfFile(String path) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(path));
        try {
            return br.readLine();
        } finally {
            br.close();
        }
    }

    // try-with-resources - the the best way to close resources!  (Page 35)
    static String firstLineOfFile0(String path) throws IOException {
        try (BufferedReader br = new BufferedReader(
                new FileReader(path))) {
            return br.readLine();
        }
    }

    public static void main(String[] args) throws IOException {
        String path = args[0];
        System.out.println(firstLineOfFile(path));
    }
}
