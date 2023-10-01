package b10815;

import java.util.*;
import java.io.*;

public class Main {
  public static void main(String[] args) throws Exception{
    System.setIn(new FileInputStream("b10815/input.txt"));
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
    int n = Integer.parseInt(br.readLine());
    HashSet<String> set = new HashSet<>(Arrays.asList(br.readLine().split(" ")));
    StringBuilder sb = new StringBuilder();
    n = Integer.parseInt(br.readLine());
    String[] str = br.readLine().split(" ");
    for(int i = 0 ; i < n ; i++) sb.append(set.contains(str[i]) ? 1: 0).append(" ");
    System.out.println(sb.toString());
  }
}