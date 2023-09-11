package b16236;

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("b16236/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int arr[][] = new int[n][n];

        for (int i = 0; i < n; i++) {
            String str[] = br.readLine().split(" ");
            for (int k = 0; k < n; k++) {
                arr[i][k] = Integer.parseInt(str[k]);
            }
        }

    }
}
