package b1967;

import java.util.*;
import java.io.*;

public class Main {
    static int N;

    static ArrayList<Integer>[] arr;
    static int maxArr[];
    static int[][] values;
    static PriorityQueue<Integer> pq = new PriorityQueue<>();

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("b1967/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        arr = new ArrayList[N + 1];
        maxArr = new int[N + 1];

        values = new int[N + 1][N + 1];
        for (int i = 0; i < N + 1; i++) {
            arr[i] = new ArrayList<>();
        }
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            values[a][b] = c;
            values[b][a] = c;
            arr[a].add(b);
            arr[b].add(a);
        }

    }

    static int[] fn(int[] res) {
        if (arr[res[0]].size() == 0) {
            res[0] = res[0];
            res[1] = 0;
        }

        int max = 0;
        int sum = 0;
        for (int i = 0; i < arr[res[0]].size(); i++) {
            int tmp = values[res[0]][fn()];
            sum += tmp;
            if (max < tmp)
                max = tmp;

        }
        pq.add(sum);

    }

}
