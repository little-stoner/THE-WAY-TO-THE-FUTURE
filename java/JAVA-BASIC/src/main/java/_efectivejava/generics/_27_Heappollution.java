package _efectivejava.generics;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class _27_Heappollution {

    final static class FileCrawler {
        private String url;
        public FileCrawler() {}
        public FileCrawler(String url) {
            this.url = url;
        }
        public List<String> getFileNames() {
            List<String> list = new LinkedList<String>();
            return list;
        }
        public List<StringBuilder> getFileNames0() {
            List<StringBuilder> list = new LinkedList<StringBuilder>();
            return list;
        }

        public static void main(String[] args) {
            FileCrawler crawler = new FileCrawler("http:\\www.goofy.com");
            List<String> files = crawler.getFileNames();
            System.out.println(files.get(0));

            //
            FileCrawler crawler0 = new FileCrawler("http:\\www.goofy.com");
            // List<String> files0 = crawler0.getFileNames0();
        }
    }

    public static void main(String[] args) {
        List ln = new ArrayList<Number>();
        List ls = new LinkedList<String>();
        List<String> list;
        list = ln; // unchecked warning + heap pollution
        list = ls; // unchecked warning + NO heap pollution
    }

}
