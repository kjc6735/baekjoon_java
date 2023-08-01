package p2630;

import java.util.*;
import java.io.*;

public class Main {
    static int arr[][] = new int[128][128];
    static int ans[] = new int[2];
    static int bCnt, wCnt;

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("p2630/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            String str[] = br.readLine().split(" ");
            for (int k = 0; k < n; k++) {
                arr[i][k] = Integer.parseInt(str[k]);
            }
        }

    }

    static int[] count(int x, int y, int n) {

        for (int i = 0; i < n; i++) {
            for (int k = 0; k < n; k++) {
                if (arr[x + i][y + k] == 1)
                    bCnt++;
                else
                    wCnt++;
            }
        }
        return new int[] { wCnt, bCnt };
    }

    static int add(int[][] data, int index) {
        int sum = 0;
        for (int i = 0; i < data.length; i++) {
            sum += data[i][index];
        }
        return sum;
    }

    static int[] solv(int x, int y, int x2, int y2) {
        if (x == x2 && y == y2) {
            return count(x, y, 1);
        }
        int r[][] = new int[4][2];
        r[0] = solv(x, y, x2 / 2, y2 / 2);
        r[1] = solv(x, y, x2, y2);
        r[2] = solv(x, y, x2, y2);
        r[3] = solv(x, y, x2, y2);

        return new int[] { 1, 2, 3, 4, 5 };
    }
}
