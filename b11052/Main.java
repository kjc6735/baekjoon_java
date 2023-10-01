package b11052;

import java.util.*;
import java.io.*;

public class Main {

  public static void main(String[] args) throws Exception{
    System.setIn(new FileInputStream("b11052/input.txt"));
   BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
   int n = Integer.parseInt(br.readLine());
   String[] str = br.readLine().split(" ");
   int arr[] = new int[n+1];
   int dp[] = new int[n+1];
   for(int i = 1; i <= n ; i++){
    arr[i] = Integer.parseInt(str[i-1]);
    for(int k = 1; k <= i ; k++){
      dp[i] =Math.max(dp[i], dp[i-k] + arr[k]);
   }
  }
   System.out.println(dp[n]);

}
}