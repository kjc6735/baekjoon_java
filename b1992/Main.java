package b1992;

import java.util.*;
import java.io.*;

public class Main {
    static char arr[][];
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("b1992/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        arr = new char[n][n];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            arr[i] = st.nextToken().toCharArray();

        }

        fn(n, 0, 0);
        System.out.println(sb.toString());

    }

    static boolean check(int n, int x, int y) {
        char start = arr[x][y];
        for (int i = 0; i < n; i++) { // 1
            for (int k = 0; k < n; k++) {

                if (arr[i + x][k + y] == start)
                    continue;
                return false;
            }
        }
        return true;
    }

    static void fn(int n, int x, int y) {
        if (n == 1) {
            sb.append(arr[x][y]);
            return;
        }

        char start = arr[x][y];
        int half = n / 2;
        if (!check(n, x, y)) {
            sb.append("(");

            fn(half, x, y); // 1
            fn(half, x, y + half); // 2
            fn(half, x + half, y); // 3
            fn(half, x + half, y + half); // 4

            sb.append(")");

        } else
            sb.append(start);

    }

}
