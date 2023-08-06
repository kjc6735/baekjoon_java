// package b9461;

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception{
        // System.setIn(new FileInputStream("b9461/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int result[] = new int[n];
        long arr[] = new long[101];
        int max = 100;
        arr[1] = 1L;
        arr[2] = 1L;
        arr[3] = 1L;
        arr[4] = 2L;
    

        for (int i = 0; i < n; i++) {
            result[i] = Integer.parseInt(br.readLine());
            if (result[i] > max)
                max = result[i];
        }
        for (int i = 5; i <= max; i++) {
            arr[i] = arr[i - 2] + arr[i - 3];
        }

        for (int i = 0; i < n; i++) {
            System.out.println(arr[result[i]]);
        }

        
    }
}
