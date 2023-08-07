package b16928;

import java.util.*;
import java.io.*;

public class Main {
    static int cnt = Integer.MAX_VALUE;
    static HashMap<Integer, Integer> map = new HashMap<>();
    static Set<Integer> set = new HashSet<>();

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("b16928/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        for (int i = 0; i < n + m; i++) {

            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            map.put(a, b);
        }

        find(1, 0);
        System.out.println(cnt);
    }

}
