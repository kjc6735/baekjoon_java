package p9229;

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("p9229/input.txt"));
        int arr[] = new int[1000];
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int test = 1; test <= tc; test++) {
            int max = 0;
            StringTokenizer st = new StringTokenizer(br.readLine());

            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());

            for (int i = 0; i < n; i++)
                arr[i] = Integer.parseInt(st.nextToken());

            for (int i = 0; i < n; i++) {
                for (int k = i + 1; k < n; k++) {

                    int sum = arr[i] + arr[k];
                    if (sum > m)
                        continue;
                    if (max < sum)
                        max = sum;

                }
            }

            sb.append("#").append(test).append(" ").append(max == 0 ? -1 : max).append("\n");

        }
        System.out.println(sb.toString());
    }
}
