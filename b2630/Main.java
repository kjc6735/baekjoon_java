package b2630;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("b2630/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int arr[][] = new int[n][n];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for (int k = 0; k < n; k++) {
                arr[i][k] = Integer.parseInt(st.nextToken());
            }
        }
        find(0, 0, n, n, n / 2);
    }

    static int find(int x1, int y1, int x2, int y2, int n) {

        if (n == 0) {
            System.out.println(x1 + " " + y1 + "  , " + x2 + " " + y2);

            return 1;
        }
        // 0,0 ~ n-1, n-1
        int xx = (x1 + x2) / 2;
        int yy = (y1 + y2) / 2;
        int cnt1 = find(x1, y1, xx, yy, n / 2); // 1사분면
        int cnt2 = find(x1, yy, xx, y2, n / 2); // 2사분면
        int cnt3 = find(xx, y1, x2, yy, n / 2);
        int cnt4 = find(xx, yy, x2, y2, n / 2);
        return 1;
    }
}
