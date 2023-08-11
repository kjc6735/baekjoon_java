package b2839;

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("b2839/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int kg5 = n / 5;
        int kg3 = (n - kg5 * 5) / 3;
        int ans = n - (kg5 * 5) - (kg3 * 3);

        while (ans != 0 && kg5 > 0) {
            ans += 5;
            kg5--;
            if (ans % 3 == 0) {
                int cnt = ans / 3;
                kg3 += cnt;
                ans = 0;
                break;
            }
        }

        System.out.println(ans != 0 ? -1 : (kg3 + kg5));

    }
}
