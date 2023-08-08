package b16926;

import java.util.*;
import java.io.*;

public class Main {
    static int dir[][] = {
            { 0, 1 },
            { 1, 0 },
            { 0, -1 },
            { -1, 0 }
    };

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("b16926/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        Queue<Integer> queue[] = new LinkedList[151];
        for (int i = 0; i < queue.length; i++)
            queue[i] = new LinkedList<>();
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());
        int arr[][] = new int[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int k = 0; k < n; k++) {
                arr[i][k] = Integer.parseInt(st.nextToken());
            }
        }
        int idx = 0;
        while (idx < m / 2 || idx < n / 2) {
            int x = idx;
            int y = idx;
            int dirIdx = 0;
            queue[idx].add(arr[x][y]);
            int size = (n - idx * 2) + (m - idx * 2) - ((n - (idx - 1) * 2) + (m - (idx - 1) * 2));

            for (int i = 0; i < size; i++) {
                int dx = x + dir[dirIdx][0];
                int dy = y + dir[dirIdx][1];
                if (dx < idx || dy < idx || dx >= n - idx || dy >= m - idx) {
                    dirIdx++;
                }
                x = x + dir[dirIdx][0];
                y = y + dir[dirIdx][1];
                queue[idx].add(arr[x][y]);
            }
        }
        while (!queue[0].isEmpty()) {
            System.out.println(queue[0].poll() + " ");
        }
        // int idx = 0;

    }
}
