// package b16926;

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
        // System.setIn(new FileInputStream("b16926/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
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
            for (int k = 0; k < m; k++) {
                arr[i][k] = Integer.parseInt(st.nextToken());
            }
        }

        int idx = 0;
        while (idx < m / 2 && idx < n / 2) {
            int size = getSize(idx, n, m);

            queue[idx].add(arr[idx][idx]);
            get(idx, size, n, m, true, arr, queue[idx]);

            for (int i = 0; i < r % size; i++)
                queue[idx].add(queue[idx].poll());

            arr[idx][idx] = queue[idx].poll();
            get(idx, size, n, m, false, arr, queue[idx]);

            idx++;
        }

        for (int i = 0; i < n; i++) {
            for (int k = 0; k < m; k++) {
                sb.append(arr[i][k]).append(" ");
            }
            sb.append("\n");
        }
        System.out.print(sb.toString());
    }

    static void get(int idx, int size, int n, int m, boolean type, int[][] arr, Queue<Integer> queue) {
        int x = idx;
        int y = idx;
        int dirIdx = 0;
        for (int i = 0; i < size - 1; i++) {
            int dx = x + dir[dirIdx % 4][0];
            int dy = y + dir[dirIdx % 4][1];

            if (dx < idx || dy < idx || dx > n - idx - 1 || dy > m - idx - 1)
                dirIdx++;

            x = x + dir[dirIdx % 4][0];
            y = y + dir[dirIdx % 4][1];

            assign(queue, arr, x, y, type);
        }
    }

    static int getSize(int idx, int n, int m) {
        return (n - idx * 2) * (m - idx * 2) - ((n - (idx + 1) * 2) * (m - (idx + 1) * 2));
    }

    static void assign(Queue<Integer> queue, int arr[][], int x, int y, boolean type) {
        if (type) {
            queue.add(arr[x][y]);
        } else {
            arr[x][y] = queue.poll();
        }
    }

}