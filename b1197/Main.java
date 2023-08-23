package b1197;

import java.util.*;
import java.io.*;

public class Main {
    static Node[] arr;
    static int[] parents;
    static int v, e;

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("b1197/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        v = Integer.parseInt(st.nextToken());
        e = Integer.parseInt(st.nextToken());
        long result = 0;
        arr = new Node[e];

        for (int i = 0; i < e; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int value = Integer.parseInt(st.nextToken());
            arr[i] = new Node(a, b, value);
        }
        for (int i = 0; i < v; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int value = Integer.parseInt(st.nextToken());

        }

    }

    static void make() {
        parents = new int[v + 1];
        for (int i = 0; i <= v; i++) {
            parents[i] = i;
        }
    }

    static int find(int a) {
        if (parents[a] == a)
            return a;
        return parents[a] = find(parents[a]);
    }

    static boolean union(int a, int b) {
        int aroot = find(a);
        int broot = find(b);
        if (aroot == broot)
            return false;
        parents[broot] = aroot;
        return true;
    }

    static class Node implements Comparable<Node> {
        int from, to, value;

        Node(int f, int t, int v) {
            this.from = f;
            this.to = t;
            this.value = v;
        }

        @Override
        public int compareTo(Node o) {
            return Integer.compare(this.value, o.value);
        }
    }
}
