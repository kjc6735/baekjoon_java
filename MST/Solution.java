package MST;

import java.io.*;
import java.util.*;

public class Solution {
    static int parents[];
    static int V;
    static int E;

    static class Edge implements Comparable<Edge> {
        int from, to, weight;

        Edge(int from, int to, int weight) {
            this.from = from;
            this.to = to;
            this.weight = weight;
        }

        @Override
        public int compareTo(Edge o) {
            return this.weight - o.weight;
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

    static void make() {
        parents = new int[V + 1];
        for (int i = 0; i <= V; i++) {
            parents[i] = i;
        }
    }

    public static void main(String[] args) throws Exception {
        // System.setIn(new FileInputStream("MST/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        Edge edgeList[] = new Edge[E];
        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            edgeList[i] = new Edge(from, to, weight);
        }

        Arrays.sort(edgeList);

        make();

        int result = 0;
        int count = 0;
        for (Edge edge : edgeList) {
            if (union(edge.from, edge.to)) {
                result += edge.weight;
                if (++count == V - 1)
                    break;
            }
        }
        // System.out.println("#" + tc + " " + result);
        System.out.println(result);

    }

}
