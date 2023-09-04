package b3190;

import java.util.*;
import java.io.*;

public class Main {
    static int dir[][] = {
        {0,1}, {1,0},{0,-1}, {-1,0} 
    };
    static int N,K;

    static int currDir = 0;
    static int [][]arr ;
    public static void main(String[] args) throws Exception{
    System.setIn(new FileInputStream("b3190/input.txt"));
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
     N = Integer.parseInt(br.readLine());
     K = Integer.parseInt(br.readLine());
    
    arr = new int[N+1][N+1];

    for(int i = 0; i < K ; i++){
        String str[] = br.readLine().split(" ");
        int a = Integer.parseInt(str[0]);
        int b = Integer.parseInt(str[1]);
        arr[a][b] = 1;
    }
    
    int commCnt = Integer.parseInt(br.readLine());
    HashMap<Integer, String> comm = new HashMap<>();
    for(int i = 0; i < commCnt; i++){
        String str[] = br.readLine().split(" ");
        comm.put(Integer.parseInt(str[0]), str[1]);
    }

    int currX = 1;
    int currY = 1;
    arr[1][1] = -1; // 첫번째 위치
    Deque<Pos> deq = new LinkedList<>(); //front - 머리 
    deq.addFirst(new Pos(currX, currY));
    for(int sec = 1; sec < Integer.MAX_VALUE; sec++){
        if(end(currX + dir[currDir][0], currY + dir[currDir][1])){
           System.out.println(sec);
           return ; 
        }
        currX += dir[currDir][0];
        currY += dir[currDir][1];
        if(arr[currX][currY] == 0){
            Pos p = deq.getLast();
            arr[p.x][p.y] = 0;
            deq.removeLast();
        }
        
        deq.addFirst(new Pos(currX, currY));
        arr[currX][currY] = -1;
        if(comm.getOrDefault(sec, null) == null) continue;

        currDir = comm.get(sec).equals("L") ? currDir -1 : currDir +1 ;
        if(currDir == 4) currDir = 0;
        if(currDir == -1) currDir = 3; 
    }
  }

  static boolean end(int x,int  y){
   
    if(x < 1 || y < 1 || x> N || y > N) {
        // System.out.println("out of range");
        return true;
    }
    if(arr[x][y]  < 0) {
                // System.out.println("crash");
return true; }// 현재 뱀이 차지하는 공간

    return false;
  }

  static class Pos{
    int x; int y;
    Pos(int x, int y) {this.x = x; this.y = y;}


    @Override
    public boolean equals(Object p){
        if(this == p) return true;
        Pos p1 = (Pos) p;

        if(this.x == p1.x && this.y == p1.y){
            return true;
        }
        return false;
    }

    @Override
    public int hashCode(){
        return Objects.hash(x,y);
    }
  }
}