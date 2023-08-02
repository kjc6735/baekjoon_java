package p1954;

import java.util.*;
import java.io.*;

public class Test {
    static int dir[][] = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };
    static int arr[][] = new int[10][10];
    static int n;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("p1954/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            int idx = 1, dirIdx = 0, x = 0, y = 0, m = Integer.parseInt(br.readLine());
            while (idx <= m * m) {
                arr[x][y] = idx++;
                dirIdx = check(x, y, dir[dirIdx % 4][0], dir[dirIdx % 4][1], m) ? dirIdx : dirIdx + 1;
                x += dir[dirIdx % 4][0];
                y += dir[dirIdx % 4][1];
            }
            sb.append("#" + (i + 1) + "\n");
            for (int a = 0; a < m; sb.append("\n"), a++)
                for (int b = 0; b < m; b++)
                    sb.append(arr[a][b] + " ");
            for (int a = 0; a < m; a++)
                Arrays.fill(arr[a], 0);
        }
        System.out.println(sb.toString());
    }

    static boolean check(int x, int y, int dirX, int dirY, int n) {
        return x + dirX >= 0 && y + dirY >= 0 && x + dirX < n && y + dirY < n && arr[x + dirX][y + dirY] == 0;
    }
}
