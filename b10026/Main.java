package b10026;

import java.util.*;
import java.io.*;

public class Main {
    static boolean visited1[][];
    static boolean visited2[][];

    static char[][] strArr;
    static int ans[] = new int[2];
    static int dir[][] = {
            { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 }
    };

    static int n;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        strArr = new char[n][n];

        for (int i = 0; i < n; i++) {
            strArr[i] = br.readLine().toCharArray();
        }
        visited1 = new boolean[n][n];
        visited2 = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            for (int k = 0; k < n; k++) {
                if (visited1[i][k])
                    continue;
                fn(i, k, visited1, strArr[i][k]);
                ans[0]++;
            }
        }
        for (int i = 0; i < n; i++) {
            for (int k = 0; k < n; k++) {
                if (strArr[i][k] == 'R')
                    strArr[i][k] = 'G';
            }
        }
        for (int i = 0; i < n; i++) {
            for (int k = 0; k < n; k++) {
                if (visited2[i][k])
                    continue;
                fn(i, k, visited2, strArr[i][k]);
                ans[1]++;
            }
        }
        System.out.println(ans[0] + " " + ans[1]);
    }

    static void fn(int xx, int yy, boolean visited[][], char c) {
        visited[xx][yy] = true;
        for (int i = 0; i < 4; i++) {
            int x = xx + dir[i][0];
            int y = yy + dir[i][1];
            if (x < 0 || y < 0 || x >= n || y >= n)
                continue;
            if (visited[x][y])
                continue;
            if (strArr[x][y] != c)
                continue;
            fn(x, y, visited, c);
        }
    }

}
