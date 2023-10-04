package b17472;

import java.io.*;
import java.util.*;

public class Main {
    static int map[][] = new int[10][10];
    static int dir[][] = {
            { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 }
    };
    static int n, m;

    public static void main(String[] args) throws IOException, InterruptedException {
        System.setIn(new FileInputStream("b17472/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] str = br.readLine().split(" ");
        n = Integer.parseInt(str[0]);
        m = Integer.parseInt(str[1]);
        int number = 1;

        for (int i = 0; i < n; i++) {
            str = br.readLine().split(" ");
            for (int k = 0; k < m; k++) {
                map[i][k] = str[k].charAt(0) == '0' ? 0 : -1;
            }
        }

        print();
        System.out.println("=========================");
        // 섬 넘버링 시작
        for (int i = 0; i < n; i++) {
            for (int k = 0; k < m; k++) {
                Queue<int[]> queue = new LinkedList<>();
                if (map[i][k] != -1)
                    continue;
                map[i][k] = number;
                queue.add(new int[] { i, k });
                while (!queue.isEmpty()) {
                    int[] tmp = queue.poll();
                    for (int idx = 0; idx < 4; idx++) {
                        int x = tmp[0] + dir[idx][0];
                        int y = tmp[1] + dir[idx][1];
                        if (x < 0 || y < 0 || x >= n || y >= m)
                            continue;
                        if (map[x][y] == 0)
                            continue;
                        map[x][y] = number;
                    }
                }
                print();
                System.out.println("==========");
                if (check)
                    number++;
            }
        }
        // 섬 넘버링 끝

        print();

    }

    static void print() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            for (int k = 0; k < m; k++) {
                sb.append(map[i][k]).append(" ");
            }
            sb.append("\n");
        }

        System.out.print(sb.toString());
    }

}
