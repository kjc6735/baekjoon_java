package b2961;

import java.util.*;
import java.io.*;

public class Main {
    static int n;
    static int arr1[] = new int[10];
    static int arr2[] = new int[10];
    static PriorityQueue<Data> pq = new PriorityQueue<>();

    public static void main(String[] args) throws Exception {

        System.setIn(new FileInputStream("b2961/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            String str[] = br.readLine().split(" ");
            arr1[i] = Integer.parseInt(str[0]);
            arr2[i] = Integer.parseInt(str[1]);
        }
        for (int i = 0; i < n; i++) {
            find(0, i + 1, 1, new boolean[n], true);
            find(0, i + 1, 0, new boolean[n], false);
        }

        Data prev = pq.poll();
        int min = Integer.MAX_VALUE;

        while (!pq.isEmpty()) {
            Data curr = pq.poll();

            if (curr.type == prev.type) {
                prev = curr;
                continue;
            }
            int sub = Math.abs(prev.sum - curr.sum);
            if (min > sub)
                min = sub;
        }

        System.out.println();
    }

    static void find(int cnt, int end, int sum, boolean visitied[], boolean type) {
        if (cnt == end) {
            pq.add(new Data(type, sum));
            return;
        }

        for (int i = 0; i < n; i++) {
            if (visitied[i])
                continue;
            visitied[i] = true;
            find(cnt + 1, end, type ? sum * arr1[i] : sum + arr2[i], visitied, type);
            visitied[i] = false;
        }
    }

    static class Data implements Comparable<Data> {
        boolean type;
        int sum = 0;

        Data(boolean type, int sum) {
            this.type = type;
            this.sum = sum;
        }

        @Override
        public int compareTo(Data o) {
            return this.sum - o.sum;
        }
    }
}
