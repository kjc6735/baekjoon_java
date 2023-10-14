package b14888;

import java.util.*;
import java.io.*;

public class Main {
    static int n;
    static int arr[];
    static int oper[];
    static int max = -1_000_000_000;
    static int min = Integer.MAX_VALUE;
  public static void main(String[] args) throws Exception{
    System.setIn(new FileInputStream("b14888/input.txt"));
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    n = Integer.parseInt(br.readLine());
    arr = new int[n];
    oper = new int[n-1];
    String[] str= br.readLine().split(" ");
    for(int i =0 ; i < n; i++) arr[i] = Integer.parseInt(str[i]); 
    str= br.readLine().split(" ");
    int idx = 0;
    for(int i =0 ; i < 4; i++) {
        int cnt = Integer.parseInt(str[i]);
        for(int k = 0; k < cnt; k++){
            oper[idx++] =  i+1;
        }
    }
    
    find(0, new int[oper.length], new boolean[oper.length], arr[0]);
    System.out.println(max);
    System.out.println(min);
  }

  static void find(int cnt, int operTmp[], boolean visited[], int result){
    if(cnt == n-1) {
        if(max < result) max = result;
        if(min > result) min = result;
        return ;
    }
        for(int i = 0; i < oper.length; i++){
            if(visited[i]) continue;
            visited[i] = true;
            int tmp = operTmp[cnt];
            find(cnt + 1, operTmp, visited, calc(result , arr[cnt+1], oper[i]));
            operTmp[cnt] = tmp;
        }
  }

  static int calc(int a, int b, int o){
    return o == 1 ? a + b : o== 2 ? a - b : o == 3 ? a * b : a  / b;
  }
}