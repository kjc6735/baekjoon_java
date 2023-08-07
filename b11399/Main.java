package b11399;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("b11399/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            pq.add(Integer.parseInt(st.nextToken()));
        }
        int prev = pq.peek();
        int sum = pq.poll();
        while (!pq.isEmpty()) {
            prev += pq.poll();
            sum += (prev);
        }
        System.out.println(sum);
    }

    static class Node {
        int idx;
        int num;

        Node(int idx, int num) {
            this.idx = idx;
            this.num = num;
        }
    }
}
