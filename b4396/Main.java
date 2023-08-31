package b4396;

import java.util.*;
import java.io.*;

public class Main {

    static int dir[][] = {
            { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 }, { 1, 1 }, { 1, -1 }, { -1, -1 }, { -1, 1 }
    };

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("b4396/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int map[][] = new int[n][n];

        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            for (int k = 0; k < n; k++) {
                map[i][k] = str.charAt(k) == '.' ? -1 : 1;
            }
        }

        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            for (int k = 0; k < n; k++) {
                map[i][k] = str.charAt(k) == 'x' ? 0 : (str.charAt(k) == '.' && map[i][k] == 1) ? -1 : -2;
            }
        }

        for (int i = 0; i < n; i++) {
            for (int k = 0; k < n; k++) {
                if (map[i][k] >= 0 || map[i][k] == -2)
                    continue;
                for (int d = 0; d < dir.length; d++) {
                    int dx = i + dir[d][0];
                    int dy = k + dir[d][1];

                    if (dx < 0 || dy < 0 || dx >= n || dy >= n)
                        continue;
                    if (map[dx][dy] < 0)
                        continue;
                    map[dx][dy] += 1;
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            for (int k = 0; k < n; k++) {
                if (map[i][k] < 0)
                    sb.append(".");
                else
                    sb.append(map[i][k]);
            }
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }
}