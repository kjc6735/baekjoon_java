package b1987;

import java.util.*;
import java.io.*;

public class Main {
    static int dir[][] = {
            { 0, 1 },
            {0,-1},
            {1,0},
            {-1,0}
    };
    static int max = 0;
    static String str[];
    static int r, c;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("b1987/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
         r = Integer.parseInt(st.nextToken());
         c = Integer.parseInt(st.nextToken());
        
        str = new String[r];

        for (int i = 0; i < r; i++)
            str[i] = br.readLine();
        sb.append(str[0].charAt(0));
        fn(0, 0, 1);
        System.out.println(max);
    }
    
    static void fn(int xx, int yy, int cnt) {
        for (int i = 0; i < 4; i++) {
            int x = xx + dir[i][0];
            int y = yy + dir[i][1];
             
            if (x < 0  || y < 0 || x >= r || y >= c || sb.toString().contains(String.valueOf(str[x].charAt(y)))) {
                max = max < cnt ? cnt : max;
                continue;
            }
            sb.append(str[x].charAt(y));
            fn(x, y, cnt + 1);
            sb.deleteCharAt(sb.length() -1);
        }
    }
}
