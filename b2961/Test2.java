package b2961;

import java.util.*;
import java.io.*;

public class Test2{
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
        find(0, 0,  1, 0 );
        System.out.println(min);

    }

    static void find(int cnt, int idx, int sum, int sum2) {
        if (idx == n) {
            if(cnt == 0) return ;
            int r = Math.abs(sum - sum2);
            if(min > r) min = r;
            return;
        }
        find(cnt + 1, idx + 1, sum * arr1[idx], sum2 +arr2[idx]);
        find(cnt, idx + 1, sum , sum2 );
    }
}
