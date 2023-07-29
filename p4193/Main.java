package p4193;

import java.util.*;

import javax.swing.text.Position;

import java.io.*;

class Solution
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

        // 2 5 8 11 14 17
        //  n!= 0  && (n+1)%3 == 0
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
            Position start = new Position(stoi(str[0]), stoi(str[1]));
            str = br.readLine().split(" ");
            Position dest = new Position(stoi(str[0]), stoi(str[1]));
            visited[start.x][start.y] = true;
            fn(start, dest, 0);
            System.out.println(result);
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
    static void printmap() {
        for (int i = 0; i < N; i++) {
            for (int k = 0; k < N; k++) {
                System.out.print(map[i][k] + " ");
            }
            System.out.println();
        }
    }

    static void fn(Position start, Position dest, int time) {
        boolean isEnd = start.x == dest.x && start.y == dest.y;
        
        if (isEnd) {
            result = Math.min(result, time);
            return;
        }
        if (time >= N * N) {
            result = -1;
            return;
        }
        
        for (int i = 0; i < 4; i++) {
            int x = start.x + dir[i][0];
            int y = start.y + dir[i][1];

            if (x < 0 || y < 0 || x >= N || y >= N)
                continue;
            
            if (map[x][y] != 0) {
                continue;
            }
            if (visited[x][y])
                continue;

            if (map[x][y] == 2 && (time + 1) % 3 != 0) {
                visited[start.x][start.y] = true;
                fn(new Position(start.x, start.y), dest, time + 1);
                visited[start.x][start.y] = false;
            } else {
                visited[x][y] = true;
                fn(new Position(x, y), dest, time + 1);
                visited[x][y] = false;
            }
        }
    }


    public static class Position {
        int x;
        int y;

        Position(int x, int y) {
            this.x = x;
            this.y = y;
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