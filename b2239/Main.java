package b2239;

import java.util.*;
import java.io.*;

public class Main {
    static int arr[][] = new int[9][9];
    static int n = 9;

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("b2239/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            for (int k = 0; k < n; k++) {
                arr[i][k] = str.charAt(k) - '0';
            }
        }
        for (int i = 0; i < n; i++) {
            for (int k = 0; k < n; k++) {
            }
        }

    }
}
