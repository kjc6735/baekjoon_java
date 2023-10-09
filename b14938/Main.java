package b14938;

import java.util.*;
import java.io.*;

public class Main {
    static int MAX = 1_000_000_000;
    static int n,m,values[], map[][],r ;
    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream("b14938/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str[] = br.readLine().split(" ");
         n = Integer.parseInt(str[0]); // 지역 갯수
         m = Integer.parseInt(str[1]); // 수색 범위
         r = Integer.parseInt(str[2]);
         values = new int[n+1];
         map= new int[n+1][n+1];
        str = br.readLine().split(" ");
        for(int i = 1; i <=n;i++) values[i] = Integer.parseInt(str[i-1]);
        for(int i = 0; i <=n;i++) Arrays.fill(map[i], MAX);
    
        for(int i = 0; i < r; i++){
            str = br.readLine().split(" ");
            int a = Integer.parseInt(str[0]);
            int b = Integer.parseInt(str[1]);
            int c = Integer.parseInt(str[2]);
            map[a][b] = c;
            map[b][a] = c;
        }

        for(int k = 1; k <= n;k ++){
            for(int i = 1; i <=n ; i++){
                for(int j = 1; j <= n; j++){
                    if(i == j) map[i][j] = 0;
                    else map[i][j] = Math.min(map[i][j] , map[i][k] + map[k][j]);
                }
            }   
        }
        int result = 0;
        for(int i = 1; i <= n; i++){
            int tmp_max = 0;
            for(int k = 1; k <= n; k++ ){
                if(map[i][k] <= m){
                    tmp_max += values[k];
                }
            }
            result = Math.max(tmp_max, result);
        }

        System.out.println(result);
    }

}