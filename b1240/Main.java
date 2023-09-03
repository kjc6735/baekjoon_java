package b1240;

import java.util.*;
import java.io.*;

public class Main {
  public static void main(String[] args) throws Exception{
    System.setIn(new FileInputStream("b1240/input.txt"));
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
    StringBuilder sb = new StringBuilder();

    String str[] = br.readLine().split(" ");


    int N = Integer.parseInt(str[0]);
    int M = Integer.parseInt(str[1]);

    ArrayList<Node> nodes [] = new ArrayList[N+1];

    for(int i = 0; i <= N; i++) nodes[i] = new ArrayList<>();

    for(int i = 0; i <N-1; i++){
        str = br.readLine().split(" ");
        int a = Integer.parseInt(str[0]);
        int b = Integer.parseInt(str[1]);
        int value = Integer.parseInt(str[2]);

        nodes[a].add(new Node(b, value));
        nodes[b].add(new Node(a, value));
    }

    boolean[] visited = new boolean[N+1];

    for(int i = 0; i < M; i++){
        
        str = br.readLine().split(" ");
        int a = Integer.parseInt(str[0]);
        int b = Integer.parseInt(str[1]);
        Queue<Integer> queue = new LinkedList<>();
        Queue<Integer> sumQueue = new LinkedList<>();
        queue.add(a);
        sumQueue.add(0);
        visited[a] = true;
        while(!queue.isEmpty()){
            int d = queue.poll();
            int sum = sumQueue.poll();
            if(d == b) {
                sb.append(sum).append("\n");
                break;
            }
            for(int n = 0; n < nodes[d].size(); n++){

                if(visited[nodes[d].get(n).idx]) continue;

                queue.add(nodes[d].get(n).idx);
                visited[nodes[d].get(n).idx] = true;
                sumQueue.add(sum + nodes[d].get(n).value);
            }
        }
        Arrays.fill(visited, false);
    }

    System.out.println(sb);

  }

  

  static class Node{
    int idx;
    int value;
    Node(int idx, int value){
        this.idx = idx;
        this.value = value;
    }
}



}