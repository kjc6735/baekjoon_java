import java.util.*;
import java.io.*;

public class Main {
    static int n;
    static int m;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");
        ArrayList<Integer> arr = new ArrayList<>();
        n = Integer.parseInt(str[0]);
        m = Integer.parseInt(str[1]);
        fn(1, 0, arr);
    }

    static void fn(int start, int cnt, ArrayList<Integer> arr) {
        if (cnt == m) {
            for (int i = 0; i < arr.size(); i++) {
                System.out.print(arr.get(i) + " ");
            }
            System.out.println();
            return;
        }
        for (int i = start; i <= n; i++) {
            arr.add(i);
            fn(i + 1, cnt + 1, arr);
            arr.remove(arr.size() - 1);
        }
    }
}