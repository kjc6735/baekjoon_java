package b1788;

import java.util.*;
import java.io.*;

public class Main {
    static long result = 1L;
    public static void main(String[] args) throws Exception {
        // System.setIn(new FileInputStream("b1788/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        boolean isNegative = n > 0 ? false : true;
        n = isNegative ? -1 * n : n; 

        if (n == 0 || n == 1 ) {
            result = n;
        } else {
            long prev = 0;
            for (int i = 1; i < n; i++) {
                long tmp = result;
                result  = (result+ prev)%1000000000;
                prev = tmp;
            }
        }
        
        if(isNegative && n %2 == 0) result*=-1L;

        if (result > 0) {
            System.out.println("1");
        } else if (result < 0) {
            System.out.println("-1");
        } else
            System.out.println(0);
        System.out.println(Math.abs(result));
    }    
}
