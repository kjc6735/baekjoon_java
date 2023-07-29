package p4193;

import java.util.*;
import java.io.*;

class Solution1
{
    static int[][] dir ={
        {1,0},
        {-1,0},
        {0,1},
        {0,-1}
    };
    static int result= Integer.MAX_VALUE;
    static int[][] map = new int[15][15];
    static boolean[][] visited = new boolean[15][15];
    static int N;
	public static void main(String args[]) throws Exception
    {
        
        System.setIn(new FileInputStream("p4193/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T;
        T = Integer.parseInt(br.readLine());

        for (int test_case = 1; test_case <= T; test_case++) {

            String[] str;
            N = stoi(br.readLine());
            
            for (int i = 0; i < N; i++) {
                str = br.readLine().split(" ");
                for (int k = 0; k < N; k++) {
                    map[i][k] = stoi(str[k]);
                   
                }
            }
            str = br.readLine().split(" ");
            Position start = new Position(stoi(str[0]), stoi(str[1]), 0);

            str = br.readLine().split(" ");
            Position dest = new Position(stoi(str[0]), stoi(str[1]), 0);
            
            visited[start.x][start.y] = true;

            Queue<Position> pos = new LinkedList<>();
            pos.add(start);

            while (!pos.isEmpty()) {
                Position position = pos.poll();
                if (position.time >= N * N)
                    break;
                
                if (position.time > result)
                    break;

                boolean isBreak = position.x == dest.x && position.y == dest.y;

                if (isBreak) {
                    result = Math.min(result, position.time);
                    break;
                }

                for (int i = 0; i < 4; i++) {
                    
                    int x = position.x + dir[i][0];
                    int y = position.y + dir[i][1];
                    int time = position.time;
                    if (x < 0 || y < 0 || x >= N || y >= N) {
                        continue;
                    }
                    if (map[x][y] == 1)
                        continue; 
                    
                    if(map[x][y] == 2){
                        int restTime = time;
                        if ((restTime+1) % 3 == 0) {
                            pos.add(new Position(x, y, restTime + 1));
                            continue;
                        }

                        while (true) {
                            if ((restTime+1) % 3 != 0)
                                restTime++;
                            else
                                break;
                        }
                        pos.add(new Position(x, y, restTime+1));
                    } else {
                        pos.add(new Position(x, y, time+1));
                    }
                }
            }
            System.out.println("#" + test_case + " " + (result == Integer.MAX_VALUE ? -1 : result));

            clear();
        }
    }
    
    static void clear() {
        result = Integer.MAX_VALUE;

        for (int i = 0; i < N; i++) {
            for (int k = 0; k < N; k++) {
                map[i][k] = 0;
                // visited[i][k] = false;
            }
        }
    }
   

    public static class Position {
        int x;
        int y;
        int time;
        Position(int x, int y,int time) {
            this.x = x;
            this.y = y;
            this.time = time;
        }
        @Override
        public String toString() {
            return this.x + " " + this.y;
        }
    }

    public static int stoi(String string) {
        return Integer.parseInt(string);
    }
}