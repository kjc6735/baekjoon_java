package b16236;


import java.io.*;
import java.util.*;
public class Main {
    static int arr[][];
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        arr = new int[N][N];
        int currSize = 2;
        
        while(!pq.isEmpty()){
            Edge edge = pq.poll();
            
            if(visited[edge.no]) continue;
            visited[edge.no] = true;

            

        }
    }
}
