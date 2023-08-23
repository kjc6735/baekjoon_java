package b13023;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

class Main {
    static int n;
    static int m;
    static boolean visited[];
    static ArrayList<Integer>[] arr;
    static boolean isTrue = false;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        n = Integer.parseInt(s[0]);
        m = Integer.parseInt(s[1]);
        arr = new ArrayList[n];
        visited = new boolean[n];

        for (int i = 0; i < n; i++) {
            arr[i] = new ArrayList<>();
        }
        for (int i = 0; i < m; i++) {
            s = br.readLine().split(" ");
            int a = Integer.parseInt(s[0]), b = Integer.parseInt(s[1]);
            arr[a].add(b);
            arr[b].add(a);
        }
        for (int i = 0; i < n; i++) {
            fn(i, 1);
            if (isTrue)
                break;
        }
        System.out.println(isTrue ? 1 : 0);
    }

    static void fn(int current, int depth) {
        if (depth == 5 || isTrue) {
            isTrue = true;
            return;
        }
        visited[current] = true;
        for (int i = 0; i < arr[current].size(); i++) {
            if (!visited[arr[current].get(i)]) {
                fn(arr[current].get(i), depth + 1);
            }
        }
        visited[current] = false;
    }
}