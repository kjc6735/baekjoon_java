package p5656;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Test {
    static int dir[][] = {
            { 0, 1 },
            { 0, -1 },
            { 1, 0 },
            { -1, 0 }
    };
    static int H, W;

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("p5656/test2.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str[] = br.readLine().split(" ");
        W = Integer.parseInt(str[0]);
        H = Integer.parseInt(str[1]);
        int map[][] = new int[H][W];
        for (int i = 0; i < H; i++) {
            str = br.readLine().split(" ");
            for (int k = 0; k < W; k++) {
                map[i][k] = Integer.parseInt(str[k]);
            }
        }
        boom(2, map);
        boom(2, map);
        down(map);

        boom(6, map);
        down(map);
        print(map, H, W);

    }

    static void down(int[][] arr) {
        for (int k = 0; k < W; k++) {
            int tmp[] = new int[H];
            int idx = H - 1;

            for (int i = H - 1; i >= 0; i--) {
                if (arr[i][k] == 0)
                    continue;
                System.out.println(i + " " + k + " " + idx);
                tmp[idx--] = arr[i][k];
                arr[i][k] = 0;
            }
            for (int i = H - 1; i >= 0; i--) {
                if (tmp[i] == 0)
                    break;
                arr[i][k] = tmp[i];
            }
        }
    }

    static void print(int[][] arr, int H, int W) {
        StringBuilder sb = new StringBuilder();
        System.out.println("----------------test----------------");
        for (int i = 0; i < H; i++) {
            for (int k = 0; k < W; k++) {
                sb.append(arr[i][k]).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb.toString());

    }

    static void boom(int index, int[][] arr) {
        Queue<Pos> queue = new LinkedList<>();
        int tmp = 0;
        for (tmp = 0; tmp < arr.length && arr[tmp][index] == 0; tmp++) {

        }
        if (tmp == arr.length)
            return;
        queue.add(new Pos(tmp, index, arr[tmp][index]));
        while (!queue.isEmpty()) {
            Pos curr = queue.poll();

            arr[curr.x][curr.y] = 0;

            if (curr.size == 1)
                continue;

            for (int i = 1; i < curr.size; i++) {
                for (int k = 0; k < 4; k++) {
                    int x = curr.x + dir[k][0] * i;
                    int y = curr.y + dir[k][1] * i;

                    if (x < 0 || y < 0 || x >= H || y >= W || arr[x][y] == 0) {
                        continue;
                    }
                    queue.add(new Pos(x, y, arr[x][y]));
                }
            }
        }
    }

    static class Pos {
        int x;
        int y;
        int size;

        Pos(int x, int y, int size) {
            this.x = x;
            this.y = y;
            this.size = size;
        }

        Pos(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
