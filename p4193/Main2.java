package p4193;

import java.util.*;
import java.io.*;

class Solution3
{
    static int[][] dir ={
        {1,0},
        {-1,0},
        {0,1},
        {0,-1}
    };
    static int result= Integer.MAX_VALUE;
    static int[][] map = new int[15][15];
    static int[][] result_map = new int[15][15];

    static boolean[][] visited = new boolean[15][15];
    static int n;
	public static void main(String args[]) throws Exception
    {
        
        System.setIn(new FileInputStream("p4193/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T;
        T = Integer.parseInt(br.readLine());
        String str[];
        for (int test_case = 1; test_case <= T; test_case++) {
            n = stoi(br.readLine());

            for (int i = 0; i < n; i++) {
                str = br.readLine().split(" ");

                for (int k = 0; k < n; k++) {
                    map[i][k] = stoi(str[k]);
                    visited[i][k] = false;
                    result_map[i][k] = 0;
                }
            }

            str = br.readLine().split(" ");
            Position start = new Position(stoi(str[0]), stoi(str[1]));

            str = br.readLine().split(" ");
            Position dest = new Position(stoi(str[0]), stoi(str[1]));
        

            Queue<Position> queue = new LinkedList<>();
            queue.add(start);
            
            while (!queue.isEmpty()) {
                Position pos = queue.poll();

                for (int i = 0; i < 4; i++) {

                    int x = pos.x + dir[i][0];
                    int y = pos.y + dir[i][1];

                    //범위 밖
                    if (x < 0 || y < 0 || x >= n || y >= n)
                        continue;

                    // 벽일경우
                    if (map[x][y] == 1)
                        continue;

                    //소용돌이 일 경우
                    int add = result_map[pos.x][pos.y] + 1;

                    if (map[x][y] == 2) {
                        add = (add / 3) * 3 + 3;
                    }

                    if (result_map[x][y] == 0) {
                        result_map[x][y] = add;
                        queue.add(new Position(x, y));
                    } else {
                        result_map[x][y] = Math.min(add, result_map[pos.x][pos.y] + 1);
                        if (add < result_map[pos.x][pos.y] + 1) {
                            queue.add(new Position(x, y));
                        }
                        
                    }

                }
            }
            System.out.println(result_map[dest.x][dest.y]);
        }
    }

    public static void print() {
        for (int i = 0; i < n; i++) {
            for (int k = 0; k < n; k++) {
                System.out.print(map[i][k] + " ");
            }
            System.out.println();
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