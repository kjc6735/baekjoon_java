package b2293;

import java.util.*;
import java.io.*;

public class Main {
  public static void main(String[] args) throws Exception{
    System.setIn(new FileInputStream("b2293/input.txt"));
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String str[] = br.readLine().split(" ");
    int n = Integer.parseInt(str[0]);
    int k = Integer.parseInt(str[1]);
    int arr[] = new int[k+1];

    for(int i = 1; i <= n ; i++){
        arr[i] = Integer.parseInt(br.readLine());
    }
    int dp []= new int[10001];
    dp[0] = 1;
    for(int i = 1; i <= n; i++){
        for(int j = arr[i];j <= k; j++){
            dp[j] += dp[j - arr[i]];
        }
    }
    System.out.println(dp[k]);
}
}