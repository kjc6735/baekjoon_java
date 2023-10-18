package b11725;

import java.util.*;
import java.io.*;

public class Main {
  public static void main(String[] args) throws Exception{
    System.setIn(new FileInputStream("b11725/input.txt"));
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    int nodes[] = new int[n+1];
    ArrayList<Integer> children[] = new ArrayList[n+1];
    for(int i = 0; i <= n ; i++) children[i] = new ArrayList<>();
    for(int i = 0; i < n-1; i++){
        String str[]  = br.readLine().split(" ");
        int a = Integer.parseInt(str[0]);
        int b = Integer.parseInt(str[1]);
        children[a].add(b);
        children[b].add(a);
    }

    Queue<Integer> queue = new LinkedList<>();
    queue.add(1);
    nodes[1] = 1;
    while(!queue.isEmpty()){
        int curr = queue.poll();
        
        for(int tmp : children[curr]){
            if(nodes[tmp] != 0) continue;
            nodes[tmp] = curr;
            queue.add(tmp);
        }
    }

    StringBuilder sb = new StringBuilder();

    for(int i = 2; i <=n ; i++){
        sb.append(nodes[i]).append("\n");
    }
    System.out.print(sb.toString());
  }
}