package b11659;

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("b11659/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");

        int n = Integer.parseInt(str[0]);
        int m = Integer.parseInt(str[1]);

        StringBuilder sb = new StringBuilder();
        str = br.readLine().split(" ");
        int arr[] = new int[n + 1];
        for (int i = 0; i < n; i++, arr[i] = Integer.parseInt(str[i - 1]) + arr[i - 1]) {
        }

        for (int i = 0, a = 0, b = 0; i < m && (str = br.readLine().split(" ")) != null; a = Integer
                .parseInt(str[0]), b = Integer.parseInt(str[1]), sb.append((arr[b] - arr[a - 1]) + "\n"), i++) {
        }

        System.out.println(sb.toString());
    }
}
