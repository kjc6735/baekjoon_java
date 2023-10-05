package p5656;

import java.io.*;
import java.util.*;

class Solution {
    static int dir[][] = {
            { 0, 1 },
            { 0, -1 },
            { 1, 0 },
            { -1, 0 }
    };
    static int N, W, H;
    static int map[][];
    static int min = Integer.MAX_VALUE;
    static int tmp[][];

    public static void main(String[] args) throws Exception {
        StringBuilder sb = new StringBuilder();
        System.setIn(new FileInputStream("p5656/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int test_case = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= test_case; tc++) {
            String[] str = br.readLine().split(" ");
            N = Integer.parseInt(str[0]);

            W = Integer.parseInt(str[1]);
            H = Integer.parseInt(str[2]);

            map = new int[H][W];
            tmp = new int[H][W];
            clone(tmp, map);
            for (int i = 0; i < H; i++) {
                str = br.readLine().split(" ");
                for (int k = 0; k < W; k++) {
                    map[i][k] = Integer.parseInt(str[k]);

                }
            }

            select(0, new int[N]);
            sb.append("#").append(tc).append(" ").append(min).append("\n");

            min = Integer.MAX_VALUE;
        }
        System.out.print(sb.toString());
    }

    static void print(int[][] arr) {
        StringBuilder sb = new StringBuilder();
        System.out.println("--------------------------------");
        for (int i = 0; i < H; i++) {
            for (int k = 0; k < W; k++) {
                sb.append(arr[i][k]).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }

    static void select(int cnt, int seq[]) {
        if (cnt == N) {

            int m = count(map);
            if (min > m) {
                min = m;
            }
            clone(tmp, map);
            return;
        }

        clone(map, tmp);
        for (int i = 0; i < cnt; i++) {

            boom(seq[i], map);
            down(map);
        }
        for (int i = 0; i < W; i++) {
            select(cnt + 1, seq);
        }
    }

    static void clone(int[][] arr1, int arr2[][]) {
        for (int i = 0; i < arr1.length; i++) {
            arr2[i] = arr1[i].clone();
        }
    }

    static int count(int arr[][]) {
        int cnt = 0;

        for (int i = 0; i < H; i++) {
            for (int k = 0; k < W; k++) {
                if (arr[i][k] != 0)
                    cnt++;
            }
        }
        return cnt;
    }

    static void boom(int index, int[][] arr) {
        Queue<Pos> queue = new LinkedList<>();
        int tmp = 0;
        for (tmp = 0; tmp < H && arr[tmp][index] == 0; tmp++) {

        }
        if (tmp == H)
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

    static void down(int[][] arr) {
        for (int k = 0; k < W; k++) {
            int tmp[] = new int[H];
            int idx = H - 1;

            for (int i = H - 1; i >= 0; i--) {
                if (arr[i][k] == 0)
                    continue;
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