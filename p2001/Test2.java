package p2001;

import java.util.*;
import java.io.*;

public class Test2 {
    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("p2001/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int test_case = Integer.parseInt(br.readLine());
        int arr[][] = new int[15][15];
        for (int tc = 1; tc <= test_case; tc++) {
            String str[] = br.readLine().split(" ");
            int n = Integer.parseInt(str[0]);
            int m = Integer.parseInt(str[1]);
            for (int i = 0; i < n; i++) {
                str = br.readLine().split(" ");
                for (int k = 0; k < n; k++) {
                    arr[i][k] = Integer.parseInt(str[k]);
                    // arr[i][k] = arr[i][k - 1] + Integer.parseInt(str[k]);
                }
            }
            int max = 0;
            for (int i = 0; i < n - m + 1; i++) {
                for (int k = 0; k < n - m + 1; k++) {
                    int sum = 0;
                    for (int a = 0; a < m; a++) {
                        for (int b = 0; b < m; b++) {
                            sum += arr[i + a][k + b];
                        }
                    }
                    max = max < sum ? sum : max;
                }
            }
            System.out.println("#" + tc + " " + max);
        }
    }
}
