package b2748;

import java.util.*;
import java.io.*;

public class Main {
  public static void main(String[] args) throws Exception {
    System.setIn(new FileInputStream("b2748/input.txt"));
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
    int N = Integer.parseInt(br.readLine());

    if(N == 0 || N == 1){
        System.out.println(N);
        return ;
    }
    long arr[] = new long[N+1];
    arr[0] = 0;
    arr[1] = 1;

    for(int i = 2; i <= N ;  i++){
        arr[i] = arr[i-1] + arr[i -2];
    }

    System.out.println(arr[N]);

  }
}
