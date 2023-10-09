package b11403;

import java.util.*;
import java.io.*;

public class Main {
  public static void main(String[] args) throws Exception{
    System.setIn(new FileInputStream("b11403/input.txt"));
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    int map[][] = new int[n][n];
    
    for(int i =0; i < n; i++){
        String[] str = br.readLine().split(" ");
        for(int k = 0; k < n ; k++){
            map[i][k] = Integer.parseInt(str[k]);
        }
    }

    for(int a = 0; a< n; a++){
        for(int b = 0; b< n ; b++){
            for(int c = 0; c < n ; c++){
                
                map[b][c] = map[b][c] | (map[b][a] & map[a][c]);
            }
        }
    }
    StringBuilder sb = new StringBuilder();
    for(int i =0; i < n; i++){
        for(int k = 0; k < n ; k++){
            sb.append(map[i][k]).append(" ");
        }
        sb.append("\n");
    }
    
    System.out.print(sb.toString());

  }
}