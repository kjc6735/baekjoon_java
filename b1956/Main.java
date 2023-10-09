package b1956;

import java.util.*;
import java.io.*;

public class Main {
    static int MAX = 1_000_000_000;
  public static void main(String[] args) throws Exception{
    System.setIn(new FileInputStream("b1956/input.txt"));
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String[] str = br.readLine().split(" ");
    int n  =Integer.parseInt(str[0]);
    int m = Integer.parseInt(str[1]);
    int map[][]=  new int[n+1][n+1];
    for(int i = 0; i <=n; i++) Arrays.fill(map[i], MAX);
    for(int i = 0; i < m ; i++){
        str = br.readLine().split(" ");
        int a = Integer.parseInt(str[0]);
        int b = Integer.parseInt(str[1]);
        int c = Integer.parseInt(str[2]);
        map[a][b] = c;
    }
     
    System.out.println();
    for(int k = 1; k <= n; k++ ){
        for(int i = 1; i <= n ; i++){
            if(k == i) continue;
            for(int j = 1; j <= n; j++){
                if(j == i || k == i) continue;
                if(map[i][k] == MAX || map[k][j] == MAX) continue;
                map[i][j] =Math.min(map[i][j] , map[i][k] + map[k][j]);
            }
        }
    }
   
    int result = MAX;
    for(int i = 1; i <= n ; i++ ){
        for(int k = 1; k <= n ; k++){
            if(k == i) continue;
            if(map[i][k] == MAX || map[k][i] == MAX) continue;
            if(result > map[i][k] + map[k][i]){
                result = map[i][k] + map[k][i];
            }
        }
    }
    System.out.println(result == MAX? -1 : result);


  }
}