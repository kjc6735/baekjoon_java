package b11404;
import java.util.*;
import java.io.*;

public class Main {
  public static void main(String[] args) throws Exception{
    System.setIn(new FileInputStream("b11404/input.txt"));
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int n = Integer.parseInt(br.readLine());
    int m = Integer.parseInt(br.readLine());
    int [][] map = new int[n+1][n+1];
    for(int i =0; i <= n; i++) Arrays.fill(map[i], 1_000_000_000);

    for(int i = 0; i < m; i++){
        String str[] = br.readLine().split(" ");
        int a = Integer.parseInt(str[0]);
        int b = Integer.parseInt(str[1]);
        int c = Integer.parseInt(str[2]);
        if(map[a][b] > c)  map[a][b] = c;
    }

    for(int k = 1; k <= n ; k ++){
        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= n ; j++){
                if(map[i][k] != Integer.MAX_VALUE && map[k][j] != Integer.MAX_VALUE){
                    map[i][j] = Math.min(map[i][j], map[i][k] + map [k][j]);

                }
            }
        }
    }

    StringBuilder sb = new StringBuilder();

    for(int i = 1; i <= n ; i++){
        for(int j = 1; j <= n ; j++){
            if(i == j || map[i][j] == Integer.MAX_VALUE){
                sb.append(0).append(" ");
                continue;
            }
            sb.append(map[i][j]).append(" ");
        }
        sb.append("\n");
    }

    System.out.print(sb.toString());
  }

  
}