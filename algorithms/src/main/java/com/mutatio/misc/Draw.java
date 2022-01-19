package com.mutatio.misc;

import edu.princeton.cs.introcs.StdDraw;
import edu.princeton.cs.introcs.StdRandom;

import java.awt.*;

public class Draw {
    public static void main(String[] args) {
        draw1();
    }

    private static void draw0() {
        int N = 100;
        StdDraw.setXscale(0, N);
        StdDraw.setYscale(0, N * N);
        StdDraw.setPenRadius(0.01);
        for (int i = 0; i <= N; i++) {
            StdDraw.point(i, i);
            StdDraw.point(i, i * i);
            StdDraw.point(i, i * Math.log(i));
        }
    }

    private static void draw1() {
        int N = 50;
        double a[] = new double[N];
        for (int i = 0; i < N; i++) {
            a[i] = StdRandom.random();
        }
        for (int i = 0; i < N; i++) {
            double x = 1.0 * i / N;
            double y = a[i]/2.0;
            double rw = 0.5/N;
            double rh = a[i]/2.0;
            StdDraw.setPenColor(Color.cyan);
            StdDraw.filledRectangle(x, y, rw, rh);
        }
    }
}
