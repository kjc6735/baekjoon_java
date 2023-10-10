package b4485;

import java.util.*;
import java.io.*;

public class Main {
    static int map[][] = new int[126][126];
    static int minArr[][] = new int[126][126];
    static int dir[][] = {
            { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 }
    };

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("b4485/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = 1;
        StringBuilder sb = new StringBuilder();
        int n;
        while ((n = Integer.parseInt(br.readLine())) != 0) {
            for (int i = 0; i < n; i++) {
                String[] str = br.readLine().split(" ");
                Arrays.fill(minArr[i], Integer.MAX_VALUE);
                for (int k = 0; k < n; k++) {
                    map[i][k] = Integer.parseInt(str[k]);

                }
            }

            Queue<int[]> queue = new LinkedList<>();
            queue.add(new int[] { 0, 0 }); // x y sum
            minArr[0][0] = map[0][0];
            while (!queue.isEmpty()) {
                int[] curr = queue.poll();

                for (int i = 0; i < 4; i++) {
                    int x = curr[0] + dir[i][0];
                    int y = curr[1] + dir[i][1];
                    if (x < 0 || y < 0 || x >= n || y >= n)
                        continue;

                    int sum = minArr[curr[0]][curr[1]] + map[x][y];

                    if (minArr[x][y] > sum) {
                        minArr[x][y] = sum;
                        queue.add(new int[] { x, y });
                    }

                }
            }

            sb.append("Problem ").append(tc).append(": ").append(minArr[n - 1][n - 1]).append("\n");
            tc++;
        }

        System.out.print(sb.toString());

    }
}
