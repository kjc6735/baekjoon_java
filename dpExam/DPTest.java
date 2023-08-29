package dpExam;

import java.util.*;
import java.io.*;

public class DPTest {
    static int totalCnt2,totalCnt1;
    static long  memo[],callCnt2[], callCnt1[];
  public static void main(String[] args) throws Exception {
    System.setIn(new FileInputStream("dpExam/input.txt"));
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
    int N = Integer.parseInt(br.readLine());
    totalCnt1 = totalCnt2 = 0;
    callCnt1 = new long[N+1];
    callCnt2 = new long[N+1];
    memo = new long[N+1];

    Arrays.fill(memo, -1);
    memo[0] = 0;
    memo[1] = 1;
    System.out.println(fibo1(N));
    System.out.println("fibo1 cnt  = " + totalCnt1 );
    for(int i = 0; i <=N; i++){
        System.out.println("fibo1 ["+i+"] : " + callCnt1[i]);
    }
    System.out.println("====================");
    System.out.println(fibo2(N));
    System.out.println("fibo2 cnt  = " + totalCnt2);
    for(int i = 0; i <= N; i++){
        System.out.println("fibo2 ["+i+"] : " + callCnt2[i]);
    }
  }

  static long fibo1(int n){
    totalCnt2++;
    callCnt2[n]++;

    if(n < 2) return n;
    return fibo1(n-1) + fibo1(n-2);
  }

  static long fibo2(int n){
    totalCnt2++;
    callCnt2[n]++;

    if(memo[n] == -1){
        memo[n] = fibo2(n-1) + fibo2(n-2);
    }

    return memo[n];
  }


}
