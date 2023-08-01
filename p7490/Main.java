package p7490;

import java.util.*;
import java.io.*;

class Main {

    static StringBuilder sb = new StringBuilder();
    static int n;
    static List<String> list = new ArrayList<>();

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("p7490/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());

        for (int i = 0; i < tc; i++) {
            n = Integer.parseInt(br.readLine());

            find(1, "1");

            for (String s : list)
                sb.append(s).append('\n');

            if (list.size() != 0)
                sb.append('\n');
            list.clear();
        }
        System.out.println(sb.toString());

    }

    static void find(int cnt, String str) {
        if (cnt == n) {
            if (calc(str) == 0) {
                list.add(str);
            }
            return;
        }

        find(cnt + 1, str + " " + (cnt + 1));
        find(cnt + 1, str + "+" + (cnt + 1));
        find(cnt + 1, str + "-" + (cnt + 1));
    }

    static int calc(String str) {
        str = str.replace(" ", "");
        int result = 0;
        char prev = '+';
        String s = "";
        for (int i = 0; i < str.length(); i++) {

            if (str.charAt(i) == '+' || str.charAt(i) == '-') {
                result = prev == '+' ? result + Integer.parseInt(s) : result - Integer.parseInt(s);
                s = "";
                prev = str.charAt(i);
            } else {
                s += String.valueOf(str.charAt(i));
            }
        }

        result = prev == '+' ? result + Integer.parseInt(s) : result - Integer.parseInt(s);

        return result;
    }

}