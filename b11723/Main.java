package b11723;

import java.util.*;
import java.io.*;

public class Main {
    static int arr[] = new int[21];

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("b11723/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            String[] str = br.readLine().split(" ");
            int x = 0;
            if (!(str[0].equals("all") || str[0].equals("empty"))) {
                x = Integer.parseInt(str[1]);
            }
            if (str[0].equals("add")) {
                arr[x] = 1;
            } else if ((str[0].equals("remove"))) {
                arr[x] = 0;
            } else if ((str[0].equals("check"))) {
                sb.append((arr[x] == 1 ? 1 : 0) + "\n");
            } else if ((str[0].equals("toggle"))) {
                arr[x] = arr[x] != 0 ? 0 : 1;
            } else if ((str[0].equals("all"))) {
                Arrays.fill(arr, 1);
            } else if ((str[0].equals("empty"))) {
                Arrays.fill(arr, 0);
            }

        }
        System.out.println(sb.toString());

    }
}
