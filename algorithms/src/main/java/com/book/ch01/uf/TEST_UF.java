package com.book.ch01.uf;

import edu.princeton.cs.algs4.Stopwatch;

import java.io.FileNotFoundException;

public class TEST_UF {

    public static void main(String[] args) throws FileNotFoundException {

        String lfile = "/Users/viber/Mamba/course/algs4-data/largeUF.txt";
        String mfile = "/Users/viber/Mamba/course/algs4-data/mediumUF.txt";

        X_UF.timeUF(mfile);

        Stopwatch stopwatch = new Stopwatch();
        X_UF.timeUF(mfile);
        System.out.println(" UF: " + stopwatch.elapsedTime() + " <<<<<<<<<");

        stopwatch = new Stopwatch();
        X_QUICK_UF.timeUF(mfile);
        System.out.println(" QUICK: " + stopwatch.elapsedTime() + " <<<<<<<<<");

        stopwatch = new Stopwatch();
        X_WEIGHT_UF.timeUF(lfile);
        System.out.println(" WEIGHT: " + stopwatch.elapsedTime() + " <<<<<<<<<");

        stopwatch = new Stopwatch();
        X_WEIGHT_PATH_UF.timeUF(lfile);
        System.out.println(" PATH: " + stopwatch.elapsedTime() + " <<<<<<<<<");

    }
}
