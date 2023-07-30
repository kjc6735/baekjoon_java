package b2606;

import java.util.*;
import java.io.*;

public class Main {
    static boolean visited[] = new boolean[101];
    static List<Integer>[] arr;
    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream("b2606/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        arr = new ArrayList[n + 1];
    
        for (int i = 0; i < n; i++)
            arr[i + 1] = new ArrayList<>();
            
        String[] str;
        for (int i = 0; i < m; i++) {
            str = br.readLine().split(" ");
            int a = Integer.parseInt(str[0]);
            int b = Integer.parseInt(str[1]);

            arr[a].add(b);
            arr[b].add(a);
        }
        Queue<List<Integer>> queue = new LinkedList<>();
        queue.add(arr[1]);
        visited[1] = true;
        while (!queue.isEmpty()) {
            List<List<Integer>> list = new ArrayList<>();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                list.add(queue.poll());
            }
            for (List<Integer> l : list) {
                for (int a : l) {
                    if (visited[a])
                        continue;
                    visited[a] = true;
                    queue.add(arr[a]);
                }
            }
        }

        int totalCnt = 0;
        for (int i = 1; i <= n; i++) {
            if (visited[i])
                totalCnt++;
        }
        System.out.println(Arrays.toString(visited));
        System.out.println(totalCnt - 1);
    }
}
