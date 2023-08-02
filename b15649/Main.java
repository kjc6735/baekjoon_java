package b15649;

import java.util.*;
import java.io.*;

public class Main {
    static int n;
    static int r;
    static boolean visited[];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        n = Integer.parseInt(s[0]);
        r = Integer.parseInt(s[1]);
        visited = new boolean[n];
        ArrayList<Integer> ans = new ArrayList<>();
        fn(0, ans);
    }

    static void fn(int cnt, ArrayList<Integer> a) {
        if (cnt == r) {
            for (int i = 0; i < a.size(); i++) {
                System.out.print(a.get(i) + " ");
            }
            System.out.println();
            return;
        }

        for (int i = 1; i <= n; i++) {
            if (visited[i - 1])
                continue;
            visited[i - 1] = true;
            a.add(i);
            fn(cnt + 1, a);
            a.remove(a.size() - 1);
            visited[i - 1] = false;
        }
    }
}
