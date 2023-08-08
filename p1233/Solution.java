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
            for (int i = 0; i < 201; i++) {
                arr[i] = new Node();
            }
            for (int i = 0; i < n; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int idx = Integer.parseInt(st.nextToken());
                String value = st.nextToken();
                int left = 0;
                int right = 0;

                if (st.hasMoreTokens()) {
                    left = Integer.parseInt(st.nextToken());
                }
                if (st.hasMoreTokens()) {
                    right = Integer.parseInt(st.nextToken());
                }

                arr[idx].v = value;
                arr[idx].l = left;
                arr[idx].r = right;
            }
            try {
                String d = fn(1);
                System.out.println("#" + tc + " " + 1);
            } catch (ArithmeticException | NumberFormatException e) {
                if (e instanceof ArithmeticException) {
                    System.out.println("#" + tc + " " + 1);
                } else
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
        b = b == 0 ? 1 : b;
        if (arr[idx].v.equals("-"))
            return String.valueOf(a - b);
        if (arr[idx].v.equals("*"))
            return String.valueOf(a * b);
        if (arr[idx].v.equals("/")) {
            return String.valueOf(a - b);
        }
        return String.valueOf(a - b);
    }

    static class Node {
        String v = "";
        int l = 0;
        int r = 0;
    }
}
