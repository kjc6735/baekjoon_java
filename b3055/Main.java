package b3055;

import java.util.*;
import java.io.*;

public class Main {
    static char[][] map;
    static String[] str;
    static int R, C;
    static int[] dest = new int[2];
    static int[] start = new int[2];
    static int[] water = new int[2];
    static int[][] dir = {
            { 0, 1 }, { 1, 0 }, { -1, 0 }, { 0, -1 }
    };

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("b3055/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        str = br.readLine().split(" ");
        R = Integer.parseInt(str[0]);
        C = Integer.parseInt(str[1]);
        map = new char[R][C];

        Queue<int[]> queue = new LinkedList<int[]>();
        boolean[][] visited = new boolean[R][C];
        Queue<int[]> jinhoQueue = new LinkedList<int[]>();


        for (int i = 0; i < R; i++) {
            String str = br.readLine();
            map[i] = str.toCharArray();
            for (int k = 0; k < C; k++) {
                if (map[i][k] == 'D') {
                    dest[0] = i;
                    dest[1] = k;
                }
                if (map[i][k] == 'S') {
                    jinhoQueue.add(new int[]{i,k});
                    visited[i][k] = true;
                    map[i][k] = '.';
                }
                if (map[i][k] == '*') {
                    queue.add(new int[]{i,k});
                }
            }
        }

    

        for (int a = 0; a < R * C; a++) {
            
            int size = queue.size();
            for(int t = 0; t < size; t++){
                int[] pos = queue.poll();

                for (int i = 0; i < 4; i++) {
                    int x = dir[i][0] + pos[0];
                    int y = dir[i][1] + pos[1];
                    if (x < 0 || y < 0 || x >= R || y >= C )
                        continue;
                    
                 
                    if(map[x][y] != '.') continue;
                    map[x][y] = '*';
                    queue.add(new int[]{x,y});

                }
            }

            size = jinhoQueue.size();
            for(int t = 0; t < size; t++){

                int[] pos = jinhoQueue.poll();

                for (int i = 0; i < 4; i++) {
                    int x = dir[i][0] + pos[0];
                    int y = dir[i][1] + pos[1];
                    if (x < 0 || y < 0 || x >= R || y >= C || visited[x][y])
                        continue;
                    if ( map[x][y] == '.') {
                        visited[x][y] = true;
                        jinhoQueue.add(new int[] { x, y }); 
                        
                    }else if(map[x][y] == 'D'){
                        System.out.println(a + 1);
                        return ;
                    }
                }
            }
        }
        System.out.println("KAKTUS");
    }

}