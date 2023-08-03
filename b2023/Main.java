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
        find(1, 2);
        find(1, 3);
        find(1, 5);
        find(1, 7);
        find(1, 9);
        System.out.println(sb.toString());
    }

    static void find(int cnt, int result) {
        if (n == cnt) {
            if (isPrime(result))
                sb.append(result).append("\n");
            return;
        }
        if (isPrime(result)) {
            find(cnt+1, result*10 + 1);
            find(cnt+1, result*10 + 3);
            find(cnt+1, result*10 + 5);
            find(cnt+1, result*10 + 7);
            find(cnt+1,result*10 + 9);
        }
    }

    static boolean isPrime( int num2) {
        if (num2 == 2 )
            return true;
        if (num2 % 2 == 0)
            return false;
        
        int i ;
        for ( i = 3; i * i <= num2; i+=2) {
            if (num2 % i == 0)
                return false;
        }
        return true;
    }
}
