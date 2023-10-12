package b14503;

import java.io.*;
import java.util.*;

public class Main {
    static int n, m, r, c, d;
    static int map[][];
    static boolean clean[][];

    static int dir[][] = {
            { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 }
    };

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("b14503/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][m];
        clean = new boolean[n][m];
        st = new StringTokenizer(br.readLine());

        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int k = 0; k < m; k++) {
                map[i][k] = Integer.parseInt(st.nextToken());
            }
        }
        int cnt = 0;
        while (true) {
            if (!clean[r][c]) {
                cnt++;
                clean[r][c] = true;
            }
            boolean check = false;
            for (int tmp = 0; tmp < 4; tmp++) {
                int x = r + dir[tmp][0];
                int y = c + dir[tmp][1];
                if (x < 0 || y < 0 || x >= n || y >= m)
                    continue;
                if (map[x][y] == 1)
                    continue;
                if (clean[x][y])
                    continue;
                check = true;
                break;
            }

            if (check) { // 있는 경우
                d = (d - 1) < 0 ? 3 : d - 1; // 90도 방향 반시계 방향으로 회전
                int x = r + dir[d][0];
                int y = c + dir[d][1];
                if (x < 0 || y < 0 || x >= n || y >= m)
                    continue;
                if (map[x][y] == 1)
                    continue;
                if (clean[x][y])
                    continue;
                r = x;
                c = y;
            } else {
                int x = r + dir[d][0] * -1;
                int y = c + dir[d][1] * -1;
                if (x < 0 || y < 0 || x >= n || y >= m || map[x][y] == 1) {
                    break;
                }
                r = x;
                c = y;
            }
        }
        System.out.println(cnt);

    }
}
