package b10971;

import java.util.*;
import java.io.*;

public class Main {
    static int n, arr[][];
    static long min = Long.MAX_VALUE;

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("b10971/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        arr = new int[n][n];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int k = 0; k < n; k++) {
                arr[i][k] = Integer.parseInt(st.nextToken());
            }
        }

        boolean visited[] = new boolean[n];
        for (int i = 0; i < n; i++) {
            visited[i] = true;
            find(i, i, 0, visited, 0);
            visited[i] = false;
        }
        System.out.println(min);
    }

    static void find(int start, int currIdx, long sum, boolean[] visited, int cnt) {
        if (sum >= min)
            return;
        if (cnt == n - 1) {
            if (arr[currIdx][start] == 0)
                return;
            sum += arr[currIdx][start];

            if (min > sum) {
                min = sum;
            }
            return;
        }

        for (int i = 0; i < n; i++) {
            if (visited[i] || arr[currIdx][i] == 0)
                continue;

            visited[i] = true;
            find(start, i, sum + arr[currIdx][i], visited, cnt + 1);
            visited[i] = false;
        }
    }
}
