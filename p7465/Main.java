package p7465;

import java.io.*;
import java.util.*;

public class Main {
    static ArrayList<Integer>[] arr = new ArrayList[101];
    static boolean[] visited = new boolean[101];

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("p7465/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int test_case = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int tc = 1; tc <= test_case; tc++) {
            String[] str = br.readLine().split(" ");
            int n = Integer.parseInt(str[0]);
            int m = Integer.parseInt(str[1]);
            Arrays.fill(visited, false);
            for (int i = 0; i <= n; i++) {
                arr[i] = new ArrayList<>();
            }

            for (int i = 0; i < m; i++) {
                str = br.readLine().split(" ");
                int a = Integer.parseInt(str[0]);
                if (str.length == 2) {
                    int b = Integer.parseInt(str[1]);
                    arr[a].add(b);
                    arr[b].add(a);
                }

            }
            int result = 0;

            Queue<Integer> queue = new LinkedList<>();

            for (int i = 1; i <= n; i++) {
                if (visited[i])
                    continue;
                result++;
                queue.add(i);
                visited[i] = true;
                while (!queue.isEmpty()) {
                    int idx = queue.poll();

                    for (int k = 0; k < arr[idx].size(); k++) {
                        if (visited[arr[idx].get(k)])
                            continue;
                        visited[arr[idx].get(k)] = true;
                        queue.add(arr[idx].get(k));
                    }
                }
            }
            sb.append("#").append(tc).append(" ").append(result).append("\n");
        }
        System.out.print(sb.toString());
    }

}
