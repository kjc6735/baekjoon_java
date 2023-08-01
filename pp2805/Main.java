package pp2805;
// package p2805;

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        // System.setIn(new FileInputStream("p2805/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        boolean check = false;
        for (int test_case = 1; test_case <= 1; test_case++) {
            int n = Integer.parseInt(br.readLine());
            int tmp = n / 2;
            int cnt = 0;
            int sum = 0;

            for (int i = 0; i < n; i++) {
                String str = br.readLine();
                for (int k = 0; k < n; k++) {

                    if (tmp > k || tmp + cnt < k) {
                        continue;
                    }
                    int num = Integer.valueOf(str.charAt(k) - '0');
                    sum += num;
                }
                if (check == false && tmp == 0)
                    check = true;
                tmp = check ? tmp + 1 : tmp - 1;
                cnt = check ? cnt - 2 : cnt + 2;
            }
            System.out.println("#" + test_case + " " + sum);
        }
    }
}
