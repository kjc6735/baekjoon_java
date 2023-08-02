package p1954;

import java.io.*;

class Solution {
    static int n;

    static int dir[][] = {
            { 0, 1 },
            { 1, 0 },
            { 0, -1 },
            { -1, 0 }
    };

    public static void main(String args[]) throws Exception {
        System.setIn(new FileInputStream("p1954/input.txt"));

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        for (int test_case = 1; test_case <= T; test_case++) {
            n = Integer.parseInt(br.readLine());

            int dirIndex = 0;
            int map[][] = new int[n][n];
            int x = 0;
            int y = 0;
            for (int i = 1; i <= n * n; i++) {
                map[x][y] = i;

                int dx = x + dir[dirIndex % 4][0];
                int dy = y + dir[dirIndex % 4][1];

                if (dx < 0 || dy < 0 || dx >= n || dy >= n || map[dx][dy] != 0) {
                    dirIndex++;
                }

                x = x + dir[dirIndex % 4][0];
                y = y + dir[dirIndex % 4][1];
            }
            System.out.println("#" + test_case);
            print(map);
        }
    }

    static void print(int[][] map) {
        for (int i = 0; i < n; i++) {
            for (int k = 0; k < n; k++) {
                System.out.print(map[i][k] + " ");
            }
            System.out.println();
        }
    }
}