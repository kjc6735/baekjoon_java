package b2775;

import java.util.*;
import java.io.*;

public class Main {
    static int[][] arr = new int[15][15];
    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream("b2775/input.txt"));
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int test_case = Integer.parseInt(br.readLine());
        for(int k = 0; k < 15; k++) arr[0][k] = k;
        for(int k = 0; k < 15; k++) arr[k][1] = 1;

        for(int i = 1;  i < 15; i++){
            for(int k = 1; k < 15; k++){
                arr[i][k] = arr[i-1][k] + arr[i][k - 1];
            }
        }

        for (int tc = 1; tc <= test_case; tc++) {
            int a = Integer.parseInt(br.readLine());
            int b = Integer.parseInt(br.readLine());
            System.out.println(arr[a][b]);
        }

    }
}
