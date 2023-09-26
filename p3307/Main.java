package p3307;

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("p3307/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int test_case = Integer.parseInt(br.readLine());
        int arr[];

        StringBuilder sb = new StringBuilder();
        for (int tc = 1; tc <= test_case; tc++) {
            int n = Integer.parseInt(br.readLine());

            String[] str = br.readLine().split(" ");
            int dp[] = new int[n];
            arr = new int[n];

            for (int i = 0; i < n; i++) {
                dp[i] = 1;
                arr[i] = Integer.parseInt(str[i]);
                for (int k = 0; k < i; k++) {
                    if (arr[k] < arr[i] && dp[i] < dp[k] + 1) {
                        dp[i] = dp[k] + 1;
                    }
                }
            }
            Arrays.sort(dp);
            sb.append("#").append(tc).append(" ").append(dp[n - 1]).append("\n");
        }

        System.out.println(sb.toString());
    }
}
