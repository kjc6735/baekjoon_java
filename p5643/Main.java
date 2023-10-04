package p5643;

import java.io.*;
import java.util.*;

public class Main {
    static ArrayList<Node> nodes = new ArrayList<>();

    static boolean visited[] = new boolean[501];
    static int total = 0;

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("p5643/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int test_case = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for (int tc = 1; tc <= test_case; tc++) {
            total = 0;
            int N = Integer.parseInt(br.readLine());
            int M = Integer.parseInt(br.readLine());
            nodes = new ArrayList<>();
            for (int i = 0; i <= N; i++) {
                nodes.add(new Node());
            }
            for (int i = 0; i < M; i++) {
                String str[] = br.readLine().split(" ");
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
                System.out.println("index: " + i + " " + cnt);
                if (cnt == N - 1) {
                    System.out.println("index: " + i + " !!!");

                    total++;
                }

            }
            sb.append("#").append(tc).append(" ").append(total).append("\n");

        }
        System.out.print(sb.toString());
    }

    static class Node {
        ArrayList<Integer> children = new ArrayList<>();
        ArrayList<Integer> parent = new ArrayList<>();
    }
}