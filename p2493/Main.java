package p2493;

import java.util.*;
import java.io.*;

class Main {
    static int MAX = 500000;
    static int arr[] = new int[MAX];
    static int result[] = new int[MAX];

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("p2493/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        String[] str = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(str[i]);
        }
        StringBuilder sb = new StringBuilder();
        sb.append(0).append(" ");
        for (int i = 1; i < n; i++) {
            int k = i - 1;
            for (; k != -1 && arr[i] > arr[k]; k--) {
            }
            if (k < 0)
                sb.append(0);
            else {
                sb.append(k + 1);
            }
            sb.append(" ");
        }

        System.out.println(sb.toString());
    }

}
