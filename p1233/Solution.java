package p1233;

import java.util.*;
import java.io.*;

public class Solution {
    static Node arr[];

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("p1233/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        arr = new Node[201];

        for (int tc = 1; tc <= 10; tc++) {
            int n = Integer.parseInt(br.readLine());

            for (int i = 0; i < n; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int idx = Integer.parseInt(st.nextToken());
                String value = st.nextToken();
                int l = 0;
                int r = 0;

                if (st.hasMoreTokens()) {
                    l = Integer.parseInt(st.nextToken());
                }
                if (st.hasMoreTokens()) {
                    r = Integer.parseInt(st.nextToken());
                }

                arr[idx] = new Node(value, l, r);
            }
            try {
                String d = fn(1);
                System.out.println("#" + tc + " " + 1);
            } catch (NumberFormatException e) {
                System.out.println("#" + tc + " " + 0);

            }
        }
    }

    static String fn(int idx) {
        if (arr[idx].l == 0 || arr[idx].r == 0) {
            return arr[idx].v;
        }
        int a = Integer.parseInt(fn(arr[idx].l));
        int b = Integer.parseInt(fn(arr[idx].r));
        return String.valueOf(a - b);
    }

    static class Node {
        String v = "";
        int l = 0;
        int r = 0;

        public Node(String v, int l, int r) {
            this.v = v;
            this.l = l;
            this.r = r;
        }
    }

}
