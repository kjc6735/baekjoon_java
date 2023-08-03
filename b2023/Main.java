package b2023;

import java.util.*;
import java.io.*;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static int n;

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("b2023/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        int arr[] = new int[n];
        find(1, 2);
        find(1, 3);
        find(1, 5);
        find(1, 7);
        find(1, 9);
        System.out.println(sb.toString());
    }

    static void find(int cnt, int result) {
        if (cnt == n) {
            boolean check = true;
            for (int i = 1; result >= i; i *= 10) {
                if (!isPrime(result / i)) {
                    check = false;
                }
            }
            return;
        }

        for (int i = 1; i < 10; i += 2) {
            find(cnt + 1, result * 10 + i);
        }
    }

    static boolean isPrime(int num) {
        for (int i = 2; i * i <= num; i++) {
            if (num % i == 0)
                return false;
        }
        return true;
    }
}
