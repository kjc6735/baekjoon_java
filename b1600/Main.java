package b1600;

import java.util.*;
import java.io.*;

public class Main {
    static int K, N, M, arr[][];
    static int horse[][] = {
            { -1, -2 }, { -2, -1 }, { -2, 1 }, { -1, 2 },
            { 1, -2 }, { 2, -1 }, { 2, 1 }, { 1, 2 }
    };
    static int dir[][] = {
            { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 }
    };

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("b1600/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        K = Integer.parseInt(br.readLine());
        String str[] = br.readLine().split(" ");
        M = Integer.parseInt(str[0]);
        N = Integer.parseInt(str[1]);

        arr = new int[N][M];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            for (int k = 0; k < M; k++) {
                arr[i][k] = Integer.parseInt(st.nextToken());
            }
        }

        boolean visited[][][] = new boolean[N][M][K + 1];
        Queue<Pos> queue = new LinkedList<>();
        queue.add(new Pos(0, 0, K, 0));
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Pos curr = queue.poll();
                if (curr.x == N - 1 && curr.y == M - 1) {
                    System.out.println(curr.cnt);
                    return;
                }
                if (curr.k != 0) {
                    for (int k = 0; k < horse.length; k++) {
                        int x = curr.x + horse[k][0];
                        int y = curr.y + horse[k][1];
                        if (x < 0 || y < 0 || x >= N || y >= M)
                            continue;
                        System.out.println(x + " " + y + " " + (curr.k - 1));
                        if (visited[x][y][curr.k - 1])
                            continue;
                        if (arr[x][y] == 1)
                            continue;

                        visited[x][y][curr.k - 1] = true;
                        queue.add(new Pos(x, y, curr.k - 1, curr.cnt + 1));
                    }
                }

                for (int k = 0; k < 4; k++) {
                    int x = curr.x + dir[k][0];
                    int y = curr.y + dir[k][1];
                    if (x < 0 || y < 0 || x >= N || y >= M)
                        continue;
                    if (visited[x][y][curr.k])
                        continue;
                    if (arr[x][y] == 1)
                        continue;

                    visited[x][y][curr.k] = true;
                    queue.add(new Pos(x, y, curr.k, curr.cnt + 1));
                }
            }
        }
        System.out.println(-1);
    }

    static class Pos {
        int x;
        int y;
        int k;
        int cnt = 0;

        Pos(int x, int y, int k, int cnt) {
            this.x = x;
            this.y = y;
            this.k = k;
            this.cnt = cnt;
        }
    }
}
