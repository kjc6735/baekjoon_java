package b2630;

import java.io.*;
import java.util.*;

public class Test {
    static int space[][];
    static int white = 0;
    static int green = 0;

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("b2630/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        space = new int[n][n];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for (int k = 0; k < n; k++) {
                space[i][k] = Integer.parseInt(st.nextToken());
            }
        }
        makeSpace(0, 0, n);
    }

    static void makeSpace(int sr, int sc, int size) {
        int sum = 0;
        for (int r = sr; r < sr + size; r++) {
            for (int c = sc; c < sc + size; c++) {
                sum += space[r][c];
            }
        }
        if (sum == 0) { // 모두 하얀색인 공간
            white++;
        } else if (sum == size * size) {
            green++;
        } else {
            int half = size / 2;
            makeSpace(sr, sc, half);
            makeSpace(sr, sc + half, half);
            makeSpace(sr + half, sc, half);
            makeSpace(sr + half, sc + half, half);

        }
    }
}
