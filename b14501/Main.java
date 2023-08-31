package b14501;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    static int n;

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("b14501/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        int arr[] = new int[n + 2];
        for (int i = 1; i <= n; i++) {
            String str[] = br.readLine().split(" ");
            int t = Integer.parseInt(str[0]);
            int p = Integer.parseInt(str[1]);
            if (i + t <= n + 1) {
                arr[i + t] = Math.max(arr[i + t], arr[i] + p);
            }

            arr[i + 1] = Math.max(arr[i + 1], arr[i]);
            // arr[i][0] = t;
            // arr[i][1] = p;
        }

        System.out.println(arr[n + 1]);

    }

}
