package b2961;

import java.util.*;
import java.io.*;

public class Test {
    static int n;
    static int arr1[] = new int[10];
    static int arr2[] = new int[10];
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("b2961/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            arr1[i] = Integer.parseInt(st.nextToken());
            arr2[i] = Integer.parseInt(st.nextToken());
        }
        boolean visited[] = new boolean[n];
        for (int i = 0; i < n; i++)
            find(0, i + 1, 1, 0, visited);
        System.out.println(min);

    }

    static void find(int cnt, int end, int sum, int sum2, boolean visitied[]) {
        if (cnt == end) {
            int r = Math.abs(sum - sum2);
            min = min > r ? r : min;
            return;
        }

        for (int i = 0; i < n; i++) {
            if (visitied[i])
                continue;
            visitied[i] = true;
            find(cnt + 1, end, sum * arr1[i], sum2 + arr2[i], visitied);
            visitied[i] = false;
        }
    }
}
