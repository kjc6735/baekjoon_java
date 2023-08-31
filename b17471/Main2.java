package b17471;

import java.io.*;
import java.util.*;

public class Main2 {
    static int userCnt[] = new int[11];
    static int map[][] = new int[11][11];
    static int result = -1;
    static int N;
    static boolean visited[] = new boolean[11];
    static int min = Integer.MAX_VALUE;
    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream("b17471/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

         N = Integer.parseInt(br.readLine());
        String str[] = br.readLine().split(" ");
        for(int i = 1; i <= N; i++){
            userCnt[i] = Integer.parseInt(str[i -1]); 
        }

        for(int i = 0; i < N ; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int len = Integer.parseInt(st.nextToken());
            for(int k = 0; k < len; k++){
                int tmp = Integer.parseInt(st.nextToken());
                map[i+1][tmp] = 1;
                map[tmp][i+1] = 1;
            }
        }

        fn(1 << 1);
        System.out.println(min == Integer.MAX_VALUE ? -1 : min);
    }

    static int check(int cnt){
        ArrayList<Integer> list= new ArrayList<>();
        int tmp;
        int cc = 0;
        int sum = 0;
        for(tmp = 1; tmp <= N ; tmp++){
            if((cnt & (1 << tmp)) != 0) list.add(tmp); 
        }

        for(int a : list){
            for(int b : list){
                if(b == a) continue;
                if(map[a][b] == 1){
                    cc++;
                    if(sum == 0) sum+=userCnt[a];
                   sum += userCnt[b] ;break;
                }
            }
        }
        return cc == list.size()-1 ? sum : -1 ;

        // Queue<Integer> queue = new LinkedList<>();
        // queue.add(tmp);
        // sum += userCnt[tmp];
        // cnt -= (1 << tmp);

        // if(tt == ((1 << 1) |  (1 << 3) | (1 << 4))){
        //     System.out.println(tmp + " " + sum + " " + cnt + " " + tt);
        // }        
        // while(!queue.isEmpty()){
        //     int t = queue.poll();

        //     for(int i = 1; i <= N ; i++){
        //         if((cnt & 1 << i) == 0)continue;;

        //         if(tt == ((1 << 1) |  (1 << 3) | (1 << 4))){
        //             System.out.println(Integer.toBinaryString(tt));
        //             System.out.println(t + " " + i + "  = " + map[t][i]);
        //         }        
        //         if(map[t][i] == 0) continue;
             
        //         cnt -= (1 << i);
        //         sum+=userCnt[i];
        //     }
        // }
        
        // if(cnt == 0) return sum;
        // return -1 ;
    }

    static void fn(int cnt){
        if(cnt == (1 << (N+1)) -2) return ;
        int result = check(cnt);
        int result2 = check((~cnt) & (1 << (N+1)) -2);
     
        if(result != -1 && result2 != -1){
            min = Math.min(Math.abs(result - result2), min);
        }
        fn(cnt + (1 << 1));
    }
    
}
