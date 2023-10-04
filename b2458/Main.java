package b2458;

import java.io.*;
import java.util.*;

public class Main {
    static ArrayList<Node> nodes = new ArrayList<>();

    static boolean visited[] = new boolean[501];
    static int total = 0;

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("b2458/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        total = 0;
        String str[] = br.readLine().split(" ");
        int N = Integer.parseInt(str[0]);
        int M = Integer.parseInt(str[1]);
        nodes = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            nodes.add(new Node());
        }
        for (int i = 0; i < M; i++) {
            str = br.readLine().split(" ");
            int a = Integer.parseInt(str[0]);
            int b = Integer.parseInt(str[1]);
            nodes.get(b).children.add(a);
            nodes.get(a).parent.add(b);
        }

        for (int i = 1; i <= N; i++) {
            int cnt = 0;

            Arrays.fill(visited, false);
            Queue<Integer> queue = new LinkedList<>();
            queue.add(i);
            visited[i] = true;

            while (!queue.isEmpty()) {
                int tmp = queue.poll();
                ArrayList<Integer> tmpList = nodes.get(tmp).children;
                int size = tmpList.size();

                for (int k = 0; k < size; k++) {
                    if (visited[tmpList.get(k)])
                        continue;
                    visited[tmpList.get(k)] = true;
                    cnt++;
                    queue.add(tmpList.get(k));
                }
            }
            queue.add(i);
            while (!queue.isEmpty()) {
                int tmp = queue.poll();
                ArrayList<Integer> tmpList = nodes.get(tmp).parent;
                int size = tmpList.size();

                for (int k = 0; k < size; k++) {
                    if (visited[tmpList.get(k)])
                        continue;
                    visited[tmpList.get(k)] = true;
                    cnt++;
                    queue.add(tmpList.get(k));
                }
            }
            if (cnt == N - 1) {
                total++;
            }
        }
        System.out.println(total);

    }

    static class Node {
        ArrayList<Integer> children = new ArrayList<>();
        ArrayList<Integer> parent = new ArrayList<>();
    }
}