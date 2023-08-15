// package b1074;

import java.io.*;
import java.util.*;

public class Main {
    static int N, R, C;
    static int totalCnt = 0;
    public static void main(String[] args) throws Exception {
        // System.setIn(new FileInputStream("b1074/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str[] = br.readLine().split(" ");

        N = Integer.parseInt(str[0]);
        R = Integer.parseInt(str[1]) ;
        C = Integer.parseInt(str[2]) ;
        find(R, C, N);
        System.out.println(totalCnt);
    }

    static void find(int r, int c, int n) {
         if (n == 0) {
            return;
        }
        int pow =(int) Math.pow(2, n-1) ;
        
        if (pow > r && pow > c) { // 1
        } else if (pow > r && pow <= c) { // 2
            totalCnt += (pow*pow);
            c -= pow ;
        } else if (pow <= r && pow > c) { // 3
            totalCnt += (pow*pow*2);
            r -= pow;
        } else {// 4
            totalCnt += (pow*pow*3);
            r -= pow;
            c -= pow;
        }
        find(r, c, n-1);
    }
}
