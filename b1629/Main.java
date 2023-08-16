package b1629;

import java.util.*;
import java.io.*;

public class Main {
    static int a;
    static int b;
    static int c;

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("b1629/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        a = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        int value = fn()
    }

    static int fn(int bottom, int top) {
        if (bottom == top) {
            return a;
        }
        int mid = bottom + 
        return (fn(bottom) * fn()) % c;
    }

}
