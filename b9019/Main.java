package b9019;

import java.io.*;
import java.util.*;

public class Main {
    static boolean[] visited = new boolean[10000];

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("b9019/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            Queue<Node> queue = new LinkedList<>();
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            queue.add(new Node(a, new StringBuilder()));

            int cnt = 0;
            visited[a] = true;
            while (!queue.isEmpty()) {
                if (queue.peek().data == b) {
                    System.out.println(queue.peek().sb.toString());
                    break;
                }

                Node data = queue.poll();
                int first = data.data / 1000;
                int L = ((data.data) % 1000) * 10 + (data.data / 1000);
                // 앞에꺼 뺴써 뒤로

                // 뒤에꺼 뺴서 앞으로
                int last = data.data % 10;
                int R = (data.data / 10 + last * 1000) % 10000;
                if (!visited[(data.data * 2) % 10000]) {
                    queue.add(new Node((data.data * 2) % 10000,
                            new StringBuilder(data.sb.toString() + "D"))); // l
                    visited[(data.data * 2) % 10000] = true;
                }
                if (!visited[data.data - 1 < 0 ? 9999 : data.data - 1]) {
                    queue.add(new Node(data.data - 1 < 0 ? 9999 : data.data - 1,
                            new StringBuilder(data.sb.toString() + "S")));// s
                }
                if (!visited[L]) {
                    queue.add(new Node(L, new StringBuilder(data.sb.toString() + "L"))); // l
                    visited[L] = true;
                }
                if (!visited[R]) {
                    queue.add(new Node(R, new StringBuilder(data.sb.toString() + "R"))); // l
                    visited[R] = true;
                }

            }
            Arrays.fill(visited, false);

        }

    }

    static class Node {
        int data;
        StringBuilder sb;

        public Node(int data, StringBuilder sb) {
            this.data = data;
            this.sb = sb;
        }
    }
}
