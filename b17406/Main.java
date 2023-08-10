package b17406;

import java.util.*;
import java.io.*;

public class Main {
    static int dir[][] = {
            { 1, 0 },
            { 0, 1 },
            { -1, 0 },
            { 0, -1 }
    };
    static int rDir[][] = {
            { 1, 0 },
            { 0, 1 },
            { -1, 0 },
            { 0, -1 }
    };

    static Queue<int[]> q = new LinkedList<>();
    static int min;
    static int n;
    static int m;
    static int tmp[][];
    static int rotate[][];
    static Queue<Integer> queue[];

    public static void main(String[] args) throws Exception {

        System.setIn(new FileInputStream("b17406/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        queue = new LinkedList[50];
        for (int i = 0; i < queue.length; i++)
            queue[i] = new LinkedList<>();
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());
        int arr[][] = new int[n][m];
        tmp = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int k = 0; k < m; k++) {
                arr[i][k] = Integer.parseInt(st.nextToken());
            }
        }
        clone(arr, tmp, n, m);
        rotate = new int[r][3];

        for (int i = 0; i < r; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int x = Integer.parseInt(st.nextToken()) - 1;
            int y = Integer.parseInt(st.nextToken()) - 1;
            int R = Integer.parseInt(st.nextToken());
            rotate[i][0] = x;
            rotate[i][1] = y;
            rotate[i][2] = R;
        }
        fn(0, r, new boolean[r]);
        System.out.println(min);
    }

    static void rotate(int x, int y, int R, Queue<Integer> queue[], int dir[][]) {

        while (R > 0) {
            int xx = x - R;
            int yy = y - R;
            int size = getSize(R * 2 + 1, R * 2 + 1);
            queue[R].add(tmp[xx][yy]);

            get(R, size, xx, yy, true, tmp, queue[R], dir);

            queue[R].add(queue[R].poll());

            tmp[xx][yy] = queue[R].poll();
            get(R, size, xx, yy, false, tmp, queue[R], dir);

            R--;
        }
    }

    static void fn(int cnt, int max, boolean visited[]) {
        if (cnt == max) {
            int arrMin = arrMin(tmp, n, m);
            if (min > arrMin)
                min = arrMin;
            return;
        }

        for (int i = 0; i < max; i++) {
            if (visited[i])
                continue;
            visited[i] = true;
            rotate(rotate[i][0], rotate[i][1], rotate[i][2], queue, dir);
            fn(cnt + 1, max, visited);
            visited[i] = false;
            rotate(rotate[i][0], rotate[i][1], rotate[i][2], queue, rDir);
        }
    }

    static void clone(int arr[][], int tmp[][], int n, int m) {
        for (int i = 0; i < n; i++) {
            for (int k = 0; k < m; k++) {
                tmp[i][k] = arr[i][k];
            }
        }
    }

    static int arrMin(int[][] arr, int n, int m) {
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            int sum = 0;
            for (int k = 0; k < m; k++) {
                sum += arr[i][k];
            }

            if (min > sum)
                min = sum;
        }

        return min;
    }

    static void print(int n, int m, int arr[][]) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            for (int k = 0; k < m; k++) {
                sb.append(arr[i][k]).append(" ");
            }
            sb.append("\n");
        }
        System.out.print(sb.toString());
        System.out.print("====\n");

    }

    static void get(int r, int size, int n, int m, boolean type, int[][] arr, Queue<Integer> queue, int dir[][]) {

        int x = n;
        int y = m;
        int dirIdx = 0;
        for (int i = 0; i < size - 1; i++) {
            int dx = x + dir[dirIdx % 4][0];
            int dy = y + dir[dirIdx % 4][1];
            if (dx > (n + r * 2) || dy > (m + r * 2) || dx < n || dy < m)
                dirIdx++;

            x = x + dir[dirIdx % 4][0];
            y = y + dir[dirIdx % 4][1];
            assign(queue, arr, x, y, type);
            q.add(new int[] { x, y });
        }

    }

    static int getSize(int n, int m) {

        return (n * m) - ((n - 2) * (m - 2));
    }

    static void assign(Queue<Integer> queue, int arr[][], int x, int y, boolean type) {
        if (type) {
            queue.add(arr[x][y]);
        } else {
            arr[x][y] = queue.poll();
        }
    }
}