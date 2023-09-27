package b3055;

import java.util.*;
import java.io.*;

public class Main {
    static String[] map;
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
        map = new String[R];

        for (int i = 0; i < R; i++) {
            map[i] = br.readLine();
            for (int k = 0; k < C; k++) {
                if (map[i].charAt(k) == 'D') {
                    dest[0] = i;
                    dest[1] = k;
                }
                if (map[i].charAt(k) == 'S') {
                    start[0] = i;
                    start[1] = k;
                }
                if (map[i].charAt(k) == '*') {
                    water[0] = i;
                    water[1] = k;
                }
            }
        }

        Queue<int[]> queue = new LinkedList<int[]>();
        boolean[][] visited = new boolean[R][C];
        boolean[][] jinhoVisited = new boolean[R][C];
        Queue<int[]> jinhoQueue = new LinkedList<>();

        queue.add(water);
        visited[water[0]][water[1]] = true;
        jinhoVisited[start[0]][start[1]] = true;
        jinhoQueue.add(start);

        for (int a = 0; a < R * C; a++) {

            while (!queue.isEmpty()) {
                int[] pos = queue.poll();

                for (int i = 0; i < 4; i++) {
                    int x = dir[i][0] + pos[0];
                    int y = dir[i][1] + pos[1];
                    if (x < 0 || y < 0 || x >= R || y >= C || visited[x][y] || map[x].charAt(y) == 'X')
                        continue;
                    if (map[x].charAt(y) == 'D') {
                        System.out.println("KUK!");
                        return;
                    }
                    visited[x][y] = true;
                    queue.add(new int[] { x, y });
                }
            }

            while (!jinhoQueue.isEmpty()) {
                pos = jinhoQueue.poll();

                for (int i = 0; i < 4; i++) {
                    int x = dir[i][0] + pos[0];
                    int y = dir[i][1] + pos[1];
                    if (x < 0 || y < 0 || x >= R || y >= C || visited[x][y] || map[x].charAt(y) == 'X'
                            || jinhoVisited[x][y])
                        continue;
                    if (map[x].charAt(y) == 'D') {
                        System.out.println(a + 1);
                        return;
                    }
                    jinhoVisited[x][y] = true;
                    jinhoQueue.add(new int[] { x, y });
                }
            }
        }
        System.out.println("KUK!!");
    }

}