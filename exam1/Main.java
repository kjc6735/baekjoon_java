package exam1;

import java.util.*;
import java.io.*;

public class Main {
    static int cnt = 0;
    static int N = 0;
    static final int YELLOW = 0;
    static final int BLUE = 1;

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("exam1/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        System.out.println(cnt);
    }

    static void find(int c, int prev, int prev2) {
        if (c == N) {
            cnt++;
            return;
        }

        if (prev == prev2) { // 둘 다 옐로
            find(c + 1, BLUE, prev);
        } else if (prev == BLUE) { // 전이 블루
            find(c + 1, YELLOW, prev);
        } else { // 나머지
            find(c + 1, BLUE, prev);
            find(c + 1, YELLOW, prev);
        }

    }
}
