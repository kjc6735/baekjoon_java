package b21736;

import java.util.*;
import java.io.*;

public class Main {
    static char[][] arr;
    static int dir[][] = {
            { 0, 1 },
            { 0, -1 },
            { 1, 0 }, {
                    -1, 0
            }
    };
    static boolean visited[][];
    static int n;
    static int m;
    static int result;

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("b21736/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str[] = br.readLine().split(" ");
        n = Integer.parseInt(str[0]);
        m = Integer.parseInt(str[1]);

        arr = new char[n][m];
        visited = new boolean[n][m];
        int startX = 0, startY = 0;
        for (int i = 0; i < n; i++) {
            arr[i] = br.readLine().toCharArray();
            for (int k = 0; k < m; k++) {
                if (arr[i][k] == 'I') {
                    startX = i;
                    startY = k;
                } else if (arr[i][k] == 'X')
                    visited[i][k] = true;
            }
        }
        visited[startX][startY] = true;

        find(startX, startY);
        System.out.println(result == 0 ? "TT" : result);
    }

    static void find(int x, int y) {

        for (int i = 0; i < 4; i++) {
            int dx = x + dir[i][0];
            int dy = y + dir[i][1];

            if (dx < 0 || dy < 0 || dx >= n || dy >= m)
                continue;
            if (visited[dx][dy])
                continue;
            if (arr[dx][dy] == 'P')
                result++;

            visited[dx][dy] = true;
            find(dx, dy);
        }
    }
}
