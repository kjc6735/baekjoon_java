package b16926;

import java.util.*;
import java.io.*;

public class Main {
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
            while (y < m - idx) {
                queue[0].add(arr[x][y++]);
            }
            while (x < n - idx) {
                queue[idx].add(arr[x++][y]);
            }
            while (y > idx) {
                queue[0].add(arr[x][y--]);
            }
            while (x > idx) {
                queue[idx].add(arr[x--][y]);
            }
        }

        // int idx = 0;

    }
}
