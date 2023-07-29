package b20114;

import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("b20114/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");
        int n = Integer.parseInt(str[0]);
        int h = Integer.parseInt(str[1]);
        int w = Integer.parseInt(str[2]);
        char[] c = new char[n];
        Arrays.fill(c, '?');
        for (int i = 0; i < h; i++) {
            String s = br.readLine();
            for (int k = 0; k < n * w; k++) {
                if (s.charAt(k) == '?')
                    continue;
                if (c[k / w] != '?')
                    continue;

                c[(k / w)] = s.charAt(k);
            }
        }
        for (int i = 0; i < n; i++) {
            System.out.print(c[i]);
        }
        System.out.println();
    }
}
