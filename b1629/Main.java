package b1629;

import java.util.*;
import java.io.*;

public class Main {
    static long a;
    static long b;
    static long c;

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("b1629/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        a = Long.parseLong(st.nextToken());
        b = Long.parseLong(st.nextToken());
        c = Long.parseLong(st.nextToken());

        
        long ans = fn(a, b);
        System.out.println(ans);

    }

    static long fn(long base, long e){
        if(e == 1) return base%c;

        long tmp = fn(base, e/2);

        if(e %2 == 1 )return (tmp * tmp % c) *base % c;
        return tmp * tmp % c;
    }
    

}
