package b9205;

import java.util.*;
import java.io.*;

public class Main {
  public static void main(String[] args) throws Exception{
    System.setIn(new FileInputStream("b9205/input.txt"));
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
    int test_case = Integer.parseInt(br.readLine());

    boolean visited[];
    
    for(int tc = 1; tc<= test_case ;tc++){
        int n = Integer.parseInt(br.readLine()); // 맥주 파는 편의점 갯수
        Deque<int[]> dq = new ArrayDeque<>();
        visited = new boolean[n+2];
        List<int[]> arr = new ArrayList<>();
        for(int i = 0 ; i < n + 2; i++){
            String str[] = br.readLine().split(" ");
            int a = Integer.parseInt(str[0]);
            int b = Integer.parseInt(str[1]);
            arr.add(new int[]{a,b});
        }

        int[] curr = null;
        dq.add(arr.get(0));
        while(!dq.isEmpty()){
            curr = dq.poll();
            if(curr[0] == arr.get(arr.size() - 1)[0] && curr[1] == arr.get(arr.size() - 1)[1]){
                break;
            }
            for(int i = 1; i < arr.size(); i++){
                if(visited[i]) continue;
                int[] tmp = arr.get(i);
                int x = Math.abs(curr[0] - tmp[0]);
                int y = Math.abs(curr[1] - tmp[1]);
                if((x + y) > 1000) continue;
                dq.add(tmp);
                visited[i] = true;
            }   
        }
        System.out.println(curr[0] == arr.get(arr.size() - 1)[0] && curr[1] == arr.get(arr.size() - 1)[1] ? "happy" : "sad");

       


    }
  }
}