// package b14594;

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        // System.setIn(new FileInputStream("b14594/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        boolean arr[] = new boolean[n+1];
        for (int i = 0; i < m; i++) {
            String str[] = br.readLine().split(" ");
            int a = Integer.parseInt(str[0]);
            int b = Integer.parseInt(str[1]);
            for (int k = a; k < b; k++)
                arr[k] = true;
        }
        int cnt = 0;

        for (int i = 1; i <= n; i++) {
            while (arr[i])
                i++;
            cnt++;
        }
        System.out.println(cnt);
    }
}
