package b2563;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("b2563/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int arr[][] = new int[101][101];
        StringTokenizer st;
        int cnt = 0;

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            for (int c = 0; c < 10; c++) {
                for (int d = 0; d < 10; d++) {
                    if (arr[a + c][b + d] != 0)
                        continue;
                    arr[a + c][b + d] = 1;
                    cnt++;
                }
            }
        }

        System.out.println(cnt);
    }

}
