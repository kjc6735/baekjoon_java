package b1916;

import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("b1916/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        ArrayList<Node> arr[] = new ArrayList[n + 1];

        for (int i = 0; i <= n; i++) {
            arr[i] = new ArrayList<>();
        }
        for (int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            arr[a].add(new Node(b, c));
        }

        StringTokenizer st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        // dijkstra
        int dist[] = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);

        PriorityQueue<Node> pq = new PriorityQueue<>();
        dist[start] = 0;
        pq.add(new Node(start, 0));
        while (!pq.isEmpty()) {
            Node node = pq.poll();
            if (dist[node.to] < node.weight)
                continue;
            for (int i = 0; i < arr[node.to].size(); i++) {
                Node next = arr[node.to].get(i);
                if (dist[next.to] > node.weight + next.weight) {
                    dist[next.to] = node.weight + next.weight;
                    pq.add(new Node(next.to, dist[next.to]));
                }
            }
        }
        System.out.println(dist[end]);
    }

    static class Node implements Comparable<Node> {
        int to;
        int weight;

        Node(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }

        @Override
        public int compareTo(Node o) {
            return this.weight - o.weight;
        }

    }
}
