package p1228;

import java.util.*;

import java.io.*;

class Solution {
    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("p1228/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        for (int tc = 1; tc <= 10; tc++) {
            int n = Integer.parseInt(br.readLine());

            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            LinkedList<Integer> link = new LinkedList<>();

            for (int i = 0; i < n; i++)
                link.add(Integer.parseInt(st.nextToken()));

            int commCnt = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine(), " ");

            for (int cnt = 1; cnt <= commCnt; cnt++) {
                String comm = st.nextToken();
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                for (int i = 0; i < y; i++)
                    link.add(x + i, Integer.parseInt(st.nextToken()));
            }
            // System.out.print("#" + tc + " ");
            sb.append("#").append(tc).append(" ");
            int cnt = 10;
            while (cnt-- > 0)
                sb.append(link.poll()).append(" ");
            sb.append("\n");
        }

        System.out.println(sb.toString());

    }
}