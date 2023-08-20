package b1260;

import java.io.*;
import java.util.*;

public class Main {
    static List<Integer>[] arr;

    static boolean[] visited;
    static int n ;
    static int m;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("b1260/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        arr = new ArrayList[1001];
        visited = new boolean[1001];
        StringTokenizer st = new StringTokenizer(br.readLine());

         n = Integer.parseInt(st.nextToken());
         m = Integer.parseInt(st.nextToken());
        int start = Integer.parseInt(st.nextToken());


        for (int i = 0; i <= n; i++)
            arr[i] = new ArrayList<Integer>();

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            arr[a].add(b);
            arr[b].add(a);
        }
        for (int i = 1; i <= n; i++) {
            arr[i].sort(Comparator.naturalOrder());
        }

        dfs(start);

        Arrays.fill(visited, false);

        sb.append("\n");

        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        visited[start] = true;
        while (!queue.isEmpty()) {
            int idx = queue.poll();
            sb.append(idx).append(" ");

            for (int i = 0; i < arr[idx].size(); i++) {
                if (visited[arr[idx].get(i)]) continue;
                queue.add(arr[idx].get(i));
                visited[arr[idx].get(i)] = true;
            }
        }
        System.out.println(sb.toString());
    }
    

    static void dfs(int idx) {
        sb.append(idx).append(" ");
        visited[idx] = true;

        for (int i = 0; i < arr[idx].size(); i++) {
            if (visited[arr[idx].get(i)]) continue;
            dfs(arr[idx].get(i));
        }
    }
}
