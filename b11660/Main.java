package b11660;

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {

        System.setIn(new FileInputStream("b11660/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str[] = br.readLine().split(" "); // 2개
        int n = Integer.parseInt(str[0]);
        int m = Integer.parseInt(str[1]);
        // 초기 세팅
        int arr[][] = new int[n + 1][n + 1];
        for (int i = 0; i < n && (str = br.readLine().split(" ")) != null; i++)
            for (int k = 0; k < n; k++)
                arr[i + 1][k + 1] = Integer.parseInt(str[k]);
        // 왼쪽 오른쪽 세팅
        for (int k = 1; k <= n; k++)
            arr[0][k] = arr[0][k] + arr[0][k - 1];
        for (int k = 1; k <= n; k++)
            arr[k][0] = arr[k][0] + arr[k - 1][0];
        for (int i = 1; i <= n; i++)
            for (int k = 1; k <= n; arr[i][k] = arr[i][k] + arr[i - 1][k] + arr[i][k - 1] - arr[i - 1][k - 1], k++) {
            }
        for (int i = 0, x1 = 0, x2 = 0, y1 = 0,
                y2 = 0; i < m && (str = br.readLine().split(" ")) != null; x1 = Integer.parseInt(str[0])
                        - 1, y1 = Integer.parseInt(str[1])
                                - 1, x2 = Integer.parseInt(str[2]), y2 = Integer.parseInt(str[3]), System.out
                                        .println((arr[x2][y2] - arr[x1][y2] - arr[x2][y1] + arr[x1][y1])), i++) {
        }

    }
}
