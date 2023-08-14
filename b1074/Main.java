package b1074;

import java.io.*;
import java.util.*;

public class Main {
    static int dir[][] = {
            { 0, 1 },
            { 1, -1 },

    };
    static int N, R, C;
    static int totalCnt = 0;

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("b1074/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str[] = br.readLine().split(" ");

        N = Integer.parseInt(str[0]);
        R = Integer.parseInt(str[1]);
        C = Integer.parseInt(str[2]);
        find(0, 0, (int) Math.pow(2, N));
        System.out.println(totalCnt);
    }

    static void find(int r, int c, int N) {
        int half = N / 2;
        if (half == 0)
            return;
        System.out.println("=====start====");
        System.out.println(r + " " + c + " " + half);
        if (half > R && half > C) { // 1
            System.out.println(1 + "사분면");
        } else if (half > R && half < C) { // 2
            totalCnt += (N * 2);
            c = half + 1;
            System.out.println(2 + "사분면");

        } else if (half < R && half > C) { // 3
            totalCnt += (N * 3);
            r = half + 1;
            System.out.println(3 + "사분면");

        } else {// 4
            totalCnt += (N * 4);
            r = half + 1;
            c = half + 1;
            System.out.println(4 + "사분면");

        }
        System.out.println(r + " " + c + " " + half);
        System.out.println("=====end====");
        find(r, c, half);

        // find(r, c, N);
    }
}
