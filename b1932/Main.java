package b1932;

import java.util.*;
import java.io.*;

public class Main {
    static int arr[][] = new int[501][501];
  public static void main(String[] args) throws Exception{
    System.setIn(new FileInputStream("b1932/input.txt"));
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    for(int i = 0; i < n; i++){
        String[] str = br.readLine().split(" ");
        for(int k = 0; k <= i; k++){
            arr[i][k] = Integer.parseInt(str[k]);
        }
        for(int k = 0; k <= i; k++){
            arr[i][k] = Integer.parseInt(str[k]);
        }
    }
     
  }
}