// package b1149;

import java.util.*;
import java.io.*;

public class Main {
    static int rgb[][];
    static int N;
    static final int R = 0;
    static final int G = 1;
    static final int B = 2;

    public static void main(String[] args) throws Exception {
        // System.setIn(new FileInputStream("b1149/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        rgb = new int[N + 1][3];
        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int r = Integer.parseInt(st.nextToken());
            int g = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            // rgb[i][R] = Math.min(rgb[i - 1][G], rgb[i - 1][B]) + r;
            // rgb[i][G] = Math.min(rgb[i - 1][R], rgb[i - 1][B]) + g;
            // rgb[i][B] = Math.min(rgb[i - 1][G], rgb[i - 1][R]) + b;
            rgb[i][R] = (rgb[i - 1][G] < rgb[i - 1][B] ? rgb[i - 1][G] : rgb[i - 1][B]) + r;
            rgb[i][G] = (rgb[i - 1][R] < rgb[i - 1][B] ? rgb[i - 1][R] : rgb[i - 1][B]) + g;
            rgb[i][B] = (rgb[i - 1][G] < rgb[i - 1][R] ? rgb[i - 1][G] : rgb[i - 1][R]) + b;
        }

        System.out.println(Math.min(Math.min(rgb[N][R], rgb[N][G]), rgb[N][B]));
    }

}
