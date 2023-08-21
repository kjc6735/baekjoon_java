package b17135;

import java.util.*;
import java.io.*;

public class Main {
    static int r;
    static int c;
    static int d;
    static int arr[][];
    static int kill = 0;
    static int visited[];
    static Set<String> set;
    // static List<Node> list = new LinkedList<>();
    static int dir[][] = {
            { -1, 1 },
            { 1, 1 }

    };

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("b17135/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());
        arr = new int[r][c];
        visited = new int[3];
        for (int i = 0; i < r; i++) {
            st = new StringTokenizer(br.readLine());
            for (int k = 0; k < c; k++) {
                arr[i][k] = Integer.parseInt(st.nextToken());

            }
        }

        fn(0, 0);
        System.out.println(kill);
    }

    static boolean inRange(int rr, int cc) {
        return rr >= 0 && cc >= 0 && rr < r && cc < c;
    }

    static boolean find(int rr, int cc, int cnt) {
        int startX = rr - 1;
        int startY = cc - cnt;
        // if (inRange(startX, startY) && !set.contains(startX + " " + startY) &&
        // arr[startX][startY] == 1) {
        if (inRange(startX, startY) && arr[startX][startY] == 1) {

            set.add(startX + " " + startY);
            return true;
        }
        for (int i = 0; startY < cc; i++) {
            startX += dir[0][0];
            startY += dir[0][1];

            // if (inRange(startX, startY) && !set.contains(startX + " " + startY) &&
            // arr[startX][startY] == 1) {

            if (inRange(startX, startY) && arr[startX][startY] == 1) {
                set.add(startX + " " + startY);
                return true;
            }
        }
        for (int i = startY; startY < i + cnt;) {
            startX += dir[1][0];
            startY += dir[1][1];

            // if (inRange(startX, startY) && !set.contains(startX + " " + startY) &&
            // arr[startX][startY] == 1) {
            if (inRange(startX, startY) && arr[startX][startY] == 1) {
                set.add(startX + " " + startY);
                return true;
            }
        }
        return false;
    }

    static void fn(int idx, int cnt) {
        if (cnt == 3) {
            set = new HashSet<>();
            for (int i = r; i >= 1; i--) {
                for (int k = 0; k < 3; k++) {
                    if (arr[i - 1][visited[k]] == 1) {
                        set.add((i - 1) + " " + visited[k]);
                        continue;
                    }
                    // 없는 경우
                    for (int range = 1; range < d; range++) {
                        if (find(i, visited[k], range)) {
                            break;
                        }
                    }
                }
            }
            if (kill < set.size())
                kill = set.size();
            return;
        }
        if (idx >= c)
            return;
        visited[cnt] = idx;
        fn(idx + 1, cnt + 1);
        fn(idx + 1, cnt);
    }

    static int getDistance(int x1, int y1, int x2, int y2) {
        return Math.abs(x1 - x2) + Math.abs(y1 - y2);
    }

    static class Node {
        int x;
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
