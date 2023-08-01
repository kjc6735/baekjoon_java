package p2615;

import java.util.*;
import java.io.*;

public class Main {
    static int n = 19;
    static int[][] arr = new int[n][n];
    static int[][] arr2 = new int[n][n];

    static int dir[][] = {
            { -1, -1 },
            { 1, 1 },
            { 0, -1 },
            { 0, 1 },
            { -1, 0 },
            { 1, 0 },
            { 1, -1 },
            { -1, 1 },
    };

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("p2615/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < n; i++) {
            String[] str = br.readLine().split(" ");
            for (int k = 0; k < n; k++) {
                arr[i][k] = Integer.parseInt(str[k]);
            }
        }

        for (int i = 0; i < n; i++) {
            for (int k = 0; k < n; k++) {
                if (arr[i][k] == 0)
                    continue;
                for (int t = 0; t < 4; t++) {
                    int cnt = find1(i, k, arr[i][k], t);
                    arr2[i][k] = Math.max(arr2[i][k], cnt);
                    if (cnt == 5) {
                        int x = i;
                        int y = k;

                        for (cnt = 0; x + dir[t * 2][0] >= 0 && x + dir[t * 2][0] < n && y +
                                dir[t * 2][1] >= 0
                                && y + dir[t * 2][1] < n
                                && arr[i][k] == arr[x + dir[t * 2][0]][y + dir[t * 2][1]]; cnt++) {
                            x += dir[t * 2][0];
                            y += dir[t * 2][1];
                        }
                        System.out.println(arr[i][k]);

                        System.out.println((x + 1) + " " + (y + 1));
                        return;
                    }
                }
            }
        }
        System.out.println(0);
        // print();
    }

    public static void print() {
        for (int i = 0; i < n; i++) {
            for (int k = 0; k < n; k++) {
                System.out.print(arr2[i][k] + " ");
            }
            System.out.println();
        }

    }

    public static int find1(int _x, int _y, int color, int idx) {
        int cnt = 1;
        int x = _x;
        int y = _y;

        for (cnt = 0; x + dir[idx * 2][0] >= 0 && x + dir[idx * 2][0] < n && y +
                dir[idx * 2][1] >= 0
                && y + dir[idx * 2][1] < n && color == arr[x + dir[idx * 2][0]][y + dir[idx * 2][1]]; cnt++) {
            x += dir[idx * 2][0];
            y += dir[idx * 2][1];
        }

        x = _x;
        y = _y;
        for (; x + dir[idx * 2 + 1][0] >= 0 && x + dir[idx * 2 + 1][0] < n && y +
                dir[idx * 2 + 1][1] >= 0
                && y + dir[idx * 2 + 1][1] < n
                && color == arr[x + dir[idx * 2 + 1][0]][y + dir[idx * 2 + 1][1]]; cnt++) {
            x += dir[idx * 2 + 1][0];
            y += dir[idx * 2 + 1][1];
        }

        return cnt + 1;
    }

}
