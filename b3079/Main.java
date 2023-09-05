import java.util.*;
import java.io.*;

public class Main {
  public static void main(String[] args) throws Exception{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
    String str[] = br.readLine().split(" ");
    long N = Integer.parseInt(str[0]);
    long M  = Integer.parseInt(str[1]);

    long time[] = new long[(int)N];

    for(int i = 0; i < N; i++) time[i] = Long.parseLong(br.readLine());

    
    long bottom = time[0];  //걸리는 시간 최소는 아니고 
    long top = M * time[(int)(N-1)]; // 걸리는 시간 최대
    long mid = (bottom + top) / 2; 
    long ans = Long.MAX_VALUE;
    while(top>=bottom){
        long sum = 0;
        mid = (bottom + top) / 2;

        for(int i = 0; i < N; i++){
            sum += (mid / time[i]);
        }
        // 줄여야함
        if(sum >= M){
            ans  = Math.min(ans, mid);
            top = mid - 1;
            
        }else {
            bottom = mid+ 1;
        }
    }
    System.out.println(ans);
    
  }

}