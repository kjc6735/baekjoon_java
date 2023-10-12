package b1922;

import java.io.*;
import java.util.*;

public class Main {
    static int N = 0, M = 0;
    static int parents[] = new int[1001];
    static Edge[] edges;

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("b1922/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        edges = new Edge[M];
        // PriorityQueue<Edge> pq = new PriorityQueue<>();
        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            edges[i] = new Edge(a, b, c);
        }

        Arrays.sort(edges);

        make();

        int sum = 0;
        int cnt = 0;
        for (Edge e : edges) {
            if (!union(e.from, e.to))
                continue;
            sum += e.weight;
            if (++cnt == N - 1)
                break;
        }
        System.out.println(sum);
    }

    static void make() {
        for (int i = 0; i <= N; i++) {
            parents[i] = i;
        }
    }

    static int find(int a) {
        if (parents[a] == a)
            return a;
        return parents[a] = find(parents[a]);
    }

    static boolean union(int a, int b) {
        int aRoot = find(a);
        int bRoot = find(b);

        if (aRoot == bRoot)
            return false;
        parents[bRoot] = aRoot;
        return true;
    }

    static class Edge implements Comparable<Edge> {
        int to, from, weight;

        Edge(int from, int to, int weight) {
            this.from = from;
            this.to = to;
            this.weight = weight;
        }

        @Override
        public int compareTo(Edge o) {
            return this.weight - o.weight;
        }

        @Override
        public String toString() {
            return "Edge [to=" + to + ", from=" + from + ", weight=" + weight + "]";
        }
    }
}
