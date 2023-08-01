package p1389;

import java.util.*;
import java.io.*;

public class Main {
    static int n;
    static int m;
    static Map<Integer, Integer>[] user = new HashMap[5001];

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("p1389/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str[] = br.readLine().split(" ");
        Queue<Integer> queue = new LinkedList<>();

        int n = Integer.parseInt(str[0]);
        int m = Integer.parseInt(str[1]);
        for (int i = 0; i < n + 1; i++)
            user[i] = new HashMap<>();
        for (int i = 0; i < m; i++) {
            str = br.readLine().split(" ");
            int a = Integer.parseInt(str[0]);
            int b = Integer.parseInt(str[1]);
            user[a].put(b, 1);
            user[b].put(a, 1);
        }
        int max = Integer.MAX_VALUE;
        for (int i = 1; i <= n; i++) {

        }
    }

}
