package p1861;

import java.util.*;
import java.io.*;

public class Main {
    static int dir[][] = {
            { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 }
    };
    static int arr[][] = new int[1000][1000];
    static int ans = 0;
    static int n;

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("p1861/input.txt"));

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int test_case = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= test_case; tc++) {
            // System.out.println(tc);
            n = Integer.parseInt(br.readLine());
            for (int i = 0; i < n; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine(), " ");
                for (int k = 0; k < n; k++) {
                    arr[i][k] = Integer.parseInt(st.nextToken());
                }
            }
            int x = 0;
            int y = 0;
            for (int i = 0; i < n; i++) {
                for (int k = 0; k < n; k++) {
                    int r = fn(i, k, 0);
                    System.out.print(r + " ");
                    if (ans <= r) {
                        if (ans < r) {
                            ans = r;
                            x = i;
                            y = k;
                        } else if (arr[x][y] > arr[i][k]) {
                            x = i;
                            y = k;
                        }
                    }
                }
                System.out.println();

            }
            System.out.println("#" + tc + " " + (ans + 1) + " " + (arr[x][y]));
            ans = 0;
        }
    }

    static int fn(int xx, int yy, int cnt) {
        int result = cnt;
        for (int i = 0; i < 4; i++) {
            int x = xx + dir[i][0];
            int y = yy + dir[i][1];
            if (x < 0 || y < 0 || x >= n || y >= n)
                continue;
            if (arr[x][y] == arr[xx][yy] + 1) {
                result = fn(x, y, cnt + 1);
                break;
            }
        }
        return result;
    }
}
