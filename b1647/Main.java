package b1647;

import java.util.*;
import java.io.*;

public class Main {
    static int n, m;
    static int V[];
    static Edge[] edges;
    static int parents[];

    static class Edge implements Comparable<Edge> {
        int from, to, weight;

        public Edge(int from, int to, int weight) {
            this.from = from;
            this.to = to;
            this.weight = weight;
        }

        @Override
        public int compareTo(Edge o) {
            return weight - o.weight;
        }

        @Override
        public String toString() {
            return "Edge [from=" + from + ", to=" + to + ", weight=" + weight + "]";
        }
    }

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("b1647/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        parents = new int[n + 1];
        edges = new Edge[m];
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            edges[i] = new Edge(a, b, c);
        }

        Arrays.sort(edges);
        make();
        int sum = 0;
        int cnt = 0;
        if (n == 2) {
            System.out.println(sum);
            return;
        }
        for (Edge e : edges) {
            // System.out.println(e);
            if (!union(e.from, e.to))
                continue;
            sum += e.weight;
            if (++cnt == (n - 2))
                break;
        }
        System.out.println(sum);

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

    static void make() {
        for (int i = 0; i < n + 1; i++) {
            parents[i] = i;
        }
    }
}
