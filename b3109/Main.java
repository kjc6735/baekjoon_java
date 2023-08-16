package b3109;

import java.io.*;
import java.util.*;

public class Main {
    static char[][] arr;
    static int dir[][] = {
            { -1, 1 },
            { 0, 1 },
            { 1, 1 }
    };
    static int r;
    static int c;
    static int cnt = 0;
    static boolean visited[][];

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("b3109/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        arr = new char[r][c];
        visited = new boolean[r][c];
        for (int i = 0; i < r; i++) {
            arr[i] = br.readLine().toCharArray();
        }

        for (int i = 0; i < r; i++) {
            // if (find(i, 0))
            // cnt++;
            find(i, 0);
        }
        System.out.println(cnt);
    }

    static void find(int xx, int yy) {
        if (yy == c - 1) {
            cnt++;
            return;
        }

        for (int i = 0; i < 3; i++) {
            int x = xx + dir[i][0];
            int y = yy + dir[i][1];
            if (x < 0 || y < 0 || x >= r || y >= c) {
                continue;
            }
            if (arr[x][y] != '.')
                continue;

            arr[x][y] = '#';
            find(x, y);
            arr[x][y] = '.';
        }
    }

    static boolean check(int x, int y) {
        return x > 0 && y > 0 && x < r && y < c;
    }

    static void print() {

        for (int i = 0; i < r; i++) {
            for (int k = 0; k < c; k++) {
                System.out.print(arr[i][k] + " ");
            }
            System.out.println();
        }
    }

    static class Pos {
        int x;
        int y;

        public Pos(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}

// // print();
// while (!queue.isEmpty() && queue.peek().y != c - 1) {
// Pos pos = queue.poll();

// for (int dirIdx = 0; dirIdx < 3; dirIdx++) {
// int x = pos.x + dir[dirIdx][0];
// int y = pos.y + dir[dirIdx][1];
// if (x < 0 || y < 0 || x >= r || y >= c) {
// continue;
// }
// if (arr[x][y] != '.')
// continue;

// queue.add(new Pos(x, y));
// arr[x][y] = '#';
// break;
// }
// }

// System.out.println(queue.size());
// print();
// print();