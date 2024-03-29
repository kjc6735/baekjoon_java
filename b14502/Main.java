package b14502;

import java.util.*;
import java.io.*;

public class Main {
    static int n, m, arr[][], tmpCnt = 0, cnt = 0, max = 0, wallCnt = 0;
    static int dir[][] = {
            { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 }
    };
    static long visited2 = 0L;
    static ArrayList<int[]> virus = new ArrayList<>();

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("b14502/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str[] = br.readLine().split(" ");

        n = Integer.parseInt(str[0]);
        m = Integer.parseInt(str[1]);

        arr = new int[n][m];
        for (int i = 0; i < n; i++) {
            str = br.readLine().split(" ");
            for (int k = 0; k < m; k++) {
                arr[i][k] = Integer.parseInt(str[k]);
                if (arr[i][k] == 1)
                    wallCnt += 1;
                if (arr[i][k] == 2) {
                    virus.add(new int[] { i, k });
                }
            }
        }
        int size = n * m;
        for (int a = 0; a < size - 2; a++) {
            if (arr[a / m][a % m] != 0)
                continue;
            arr[a / m][a % m] = 1;
            for (int b = a + 1; b < size - 1; b++) {

                if (arr[b / m][b % m] != 0)
                    continue;
                arr[b / m][b % m] = 1;
                for (int c = b + 1; c < size; c++) {
                    if (arr[c / m][c % m] != 0)
                        continue;
                    arr[c / m][c % m] = 1;
                    cnt = virus.size();
                    for (int[] v : virus) {
                        find(v[0], v[1]);
                    }
                    int tmpMax = size - wallCnt - cnt - 3;

                    if (max < tmpMax)
                        max = tmpMax;

                    visited2 = 0L;
                    cnt = 0;
                    arr[c / m][c % m] = 0;
                }
                arr[b / m][b % m] = 0;
            }
            arr[a / m][a % m] = 0;
        }

        System.out.println(max);
    }

    static void find(int xx, int yy) {
        for (int i = 0; i < 4; i++) {
            int x = xx + dir[i][0];
            int y = yy + dir[i][1];

            if (x < 0 || y < 0 || x >= n || y >= m || arr[x][y] != 0
                    || (visited2 & (1L << (x * m + y))) != 0)
                continue;
            visited2 |= (1L << (x * m + y));
            cnt++;
            find(x, y);
        }
    }

}