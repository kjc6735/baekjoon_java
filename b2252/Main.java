package b2252;

import java.util.*;
import java.io.*;

public class Main {
    // static int[][] arr;
    static int n, m;
    static int cnt[];
    static LinkedList<Integer> arr[];
    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("b2252/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");
         n = Integer.parseInt(str[0]);
         m = Integer.parseInt(str[1]);
         // arr = new int[n+1][n+1];
         arr = new LinkedList[n+1];
         for (int i = 1; i < n + 1; i++)
             arr[i] = new LinkedList<>();
        

        Queue<Integer> queue = new LinkedList<>();
        cnt = new int[n+1];
        for (int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            arr[a].add(b);
            cnt[b] += 1;
        }

        for (int i = 1; i <= n; i++) {
            if (cnt[i] != 0) continue;
            queue.add(i);
        }
        StringBuilder sb = new StringBuilder();
        while (!queue.isEmpty()) {
            int poll = queue.poll();
            sb.append(poll).append(" ");
          
            for (Integer idx : arr[poll]) {
                cnt[idx] -= 1;
                if (cnt[idx] == 0) {
                    queue.add(idx);
                }
            }
        }
        System.out.println(sb.toString());
    }
}
