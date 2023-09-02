package b17136;

import java.util.*;
import java.io.*;

public class Main {
    static int arr[][] = new int[10][10];
    static int cnt[] = {
        0,5,5,5,5,5
    };
    static ArrayList<Node> nodes = new ArrayList<>();
    static boolean used[][] = new boolean[10][10];
    static int min = Integer.MAX_VALUE;
  public static void main(String[] args) throws Exception{
    System.setIn(new FileInputStream("b17136/input.txt"));
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    

    for(int i = 0; i < 10 ; i++){
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int k = 0; k < 10; k++){
            arr[i][k] = Integer.parseInt(st.nextToken());
            if(arr[i][k] == 1) nodes.add(new Node(i,k));
        }
    }
    fn(0);
    System.out.println(min == Integer.MAX_VALUE ? -1 : min);
  }

  static void fn(int idx){
    
    if(idx == nodes.size()){
        int usedCnt  = 0; 
        for(int i = 1; i < cnt.length; i++){
            usedCnt += cnt[i];
        }

        usedCnt = 25 - usedCnt;
        if(min > usedCnt){
            min = usedCnt;
        }
        return ;
    }
    
    if(!used[nodes.get(idx).x][nodes.get(idx).y]){
        for(int i = 1; i <= 5; i++){
            if(cnt[i] == 0) continue;
            if(check(nodes.get(idx).x,nodes.get(idx).y, i)){
                check2(nodes.get(idx).x,nodes.get(idx).y, i, true);
                cnt[i]-=1;
                fn(idx+1);
                check2(nodes.get(idx).x,nodes.get(idx).y, i, false);
                cnt[i] += 1;
            }
        }
    }else fn(idx+1);
  }

  static boolean check(int x, int y, int size){
    for(int i = 0; i < size; i++){
        for(int k = 0; k < size; k++){
            if( x + i >= 10 || y + k >= 10 ) return false;
            if(arr[x + i][y + k] == 0 || used[x+i][y + k] == true)
                return false;        
        }
    }
    return true;
  }

  static void check2(int x, int y, int size, boolean check){
    for(int i = 0; i < size; i++){
        for(int k = 0; k < size; k++){
            used[x + i][y + k] = check;
        }
    }
  }

  static class Node{
    int x,y;
    Node(int x, int y){ this.x = x; this.y = y;}
  }
}