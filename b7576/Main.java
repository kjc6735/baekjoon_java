package b7576;

import java.io.*;
import java.util.*;

public class Main {
    static int dir[][] = {
            { 0, 1 },
            { 0, -1 },
            { 1, 0 },
            { -1, 0 }
    };

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("b7576/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        int arr[][] = new int[n][m];
        Queue<Node> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int k = 0; k < m; k++) {
                arr[i][k] = Integer.parseInt(st.nextToken());
                if (arr[i][k] == 1) {
                    queue.add(new Node(i, k));
                    arr[i][k] = -1;
                }
            }
        }
        int cnt = 0;

        while (!queue.isEmpty()) {
            int s = queue.size();
            for (int size = 0; size < s; size++) {
                Node node = queue.poll();

                for (int i = 0; i < 4; i++) {
                    int x = node.x + dir[i][0];
                    int y = node.y + dir[i][1];

                    if (x < 0 || x >= n || y < 0 || y >= m)
                        continue;
                    if (arr[x][y] == -1)
                        continue;

                    queue.add(new Node(x, y, node.cnt + 1));
                    arr[x][y] = -1;
                }
            }
            if (!queue.isEmpty())
                cnt++;
        }
        if (check(arr, n, m)) {
            if (cnt == 0)
                System.out.println(0);
            else
                System.out.println(cnt);
        } else
            System.out.println(-1);

    }

    public static boolean check(int arr[][], int n, int m) {
        for (int i = 0; i < n; i++) {
            for (int k = 0; k < m; k++) {
                if (arr[i][k] == 0)
                    return false;
            }
        }
        return true;
    }

    static class Node {
        int x;
        int y;
        int cnt = 0;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public Node(int x, int y, int cnt) {
            this(x, y);
            this.cnt = cnt;
        }
    }
}
