package b17144;

import java.io.*;
import java.util.*;

public class Main {
    static ArrayList<Pos> dust = new ArrayList<>();

    static Queue<Pos> queue = new LinkedList<>();
    static int[][] map;
    static ArrayList<Pos> cleaner = new ArrayList<>();
    static int dir[][][] = {
            {
                    { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 }
            },
            {
                    { 1, 0 }, { 0, 1 }, { -1, 0 }, { 0, -1 }
            }
    };
    static int R = 0, C = 0, T = 0;

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("b17144/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str[] = br.readLine().split(" ");

        R = Integer.parseInt(str[0]);
        C = Integer.parseInt(str[1]);
        T = Integer.parseInt(str[2]);
        map = new int[R][C];
        for (int i = 0; i < R; i++) {
            str = br.readLine().split(" ");
            for (int k = 0; k < C; k++) {
                map[i][k] = Integer.parseInt(str[k]);
                if (map[i][k] == 0)
                    continue;
                if (map[i][k] == -1) {
                    cleaner.add(new Pos(i, k));
                    continue;
                }
                queue.add(new Pos(i, k, map[i][k]));
            }
        }

        for (int i = 0; i < T; i++) {
            if (i != 0)
                addQueue();
            spread();
            for (int k = 0; k < 2; k++) {
                wind(cleaner.get(k), dir[k], k == 0 ? 1 : -1);
            }
        }

        System.out.println(sum());
    }

    static int sum() {
        int result = 0;
        for (int i = 0; i < R; i++) {
            for (int k = 0; k < C; k++) {
                result += map[i][k];
            }
        }

        return result + 2;
    }

    static void print() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < R; i++) {
            sb.append(Arrays.toString(map[i])).append("\n");

        }
        System.out.println(sb.toString());
    }

    static void addQueue() {
        for (int i = 0; i < R; i++) {
            for (int k = 0; k < C; k++) {
                if (map[i][k] < 1)
                    continue;
                queue.add(new Pos(i, k, map[i][k]));
            }
        }
    }

    static void spread() {
        int size = queue.size();
        Queue<Pos> add = new LinkedList<>();
        for (int i = 0; i < size; i++) {
            Pos curr = queue.poll();
            ArrayList<Pos> tmp = new ArrayList<>();

            for (int k = 0; k < 4; k++) {
                int x = curr.x + dir[0][k][0];
                int y = curr.y + dir[0][k][1];
                if (!inRange(x, y) || map[x][y] == -1)
                    continue;
                tmp.add(new Pos(x, y));
            }

            int amount = curr.amount / 5;
            int updateMyAmount = curr.amount - amount * tmp.size();
            for (Pos t : tmp) {
                // map[t.x][t.y] += amount;
                add.add(new Pos(t.x, t.y, amount));
            }
            map[curr.x][curr.y] = updateMyAmount;
        }
        while (!add.isEmpty()) {
            Pos curr = add.poll();
            map[curr.x][curr.y] += curr.amount;
        }
    }

    static void wind(Pos pos, int dir[][], int t) {
        int x = pos.x;
        int y = pos.y;
        if (inRange(x + dir[0][0], y + dir[0][1]))
            map[x + dir[0][0]][y + dir[0][1]] = 0;
        for (int idx = 0; idx < 4; idx++) {

            while (inRange(x + dir[idx][0], y + dir[idx][1]) && (t * (x + dir[idx][0]) <= t * pos.x)) {

                map[x][y] = map[x + dir[idx][0]][y + dir[idx][1]];

                x += dir[idx][0];
                y += dir[idx][1];
            }
        }
        map[pos.x][pos.y] = -1;
    }

    static boolean inRange(int x, int y) {
        return !(x < 0 || y < 0 || x >= R || y >= C);
    }

    static class Pos {
        int x;
        int y;
        int amount = 0;

        Pos(int x, int y, int amount) {
            this.x = x;
            this.y = y;
            this.amount = amount;
        }

        Pos(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
