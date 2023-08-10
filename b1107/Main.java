package b1107;

import java.util.*;
import java.io.*;

public class Main {
    static boolean arr[] = new boolean[10];
    static String n;
    static int nLength;
    static int min = Integer.MAX_VALUE;
    static Set<Character> set = new HashSet<>();

    static String resultString = "";

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("b1107/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = br.readLine();
        nLength = n.length() - 1;

        int m = Integer.parseInt(br.readLine());

        StringTokenizer st = null;
        if (m != 0) {
            st = new StringTokenizer(br.readLine(), " ");
        }

        min = Integer.parseInt(n) - 100;
        for (int i = 0; i < m; i++) {
            set.add(st.nextToken().toCharArray()[0]);
        }

        fn(0, new StringBuilder());
        System.out.println(min);
    }

    static void findB() {

    }

    static void fn(int cnt, StringBuilder sb) {
        if (sb.length() == nLength + 1) {
            if (sb.toString().equals(n)) {
                if (min > cnt) {
                    min = cnt;
                    resultString = sb.toString();
                    System.out.println(resultString);
                }

            } else {
                int a = Integer.parseInt(sb.toString());
                int b = Integer.parseInt(n);
                System.out.println(cnt + Math.abs(a - b));

                min = cnt + Math.abs(a - b);

            }

            return;
        }
        int minGap = 100;
        char c = n.charAt(cnt);
        if (set.contains(c)) {
            for (int i = 0; i < 10; i++) {
                if (set.contains((char) (i + '0'))) {
                    continue;
                }
                int gap = Math.abs((i + '0') - n.charAt(cnt));
                if (minGap > gap) {
                    minGap = gap;
                    c = (char) (i + '0');
                }
            }
        }
        fn(cnt + 1, sb.append(c));
    }
}
