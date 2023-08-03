package b12891;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("b12891/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str[] = br.readLine().split(" ");
        int n = Integer.parseInt(str[0]);
        int m = Integer.parseInt(str[1]);
        String s = br.readLine();
        int result = 0;
        str = br.readLine().split(" ");
        int[] arr = {
                Integer.parseInt(str[0]),
                Integer.parseInt(str[1]),
                Integer.parseInt(str[2]),
                Integer.parseInt(str[3]),
        };
        Map<Character, Integer> map = new HashMap<>();
        map.put('A', 0);
        map.put('C', 1);
        map.put('G', 2);
        map.put('T', 3);

        int[] cntArr = new int[4];
        for (int i = 0; i < m - 1; i++)
            cntArr[map.get(s.charAt(i))]++;
        for (int i = -1; i + m < n; i++) {
            cntArr[map.get(s.charAt(i + m))]++;
            if (i >= 0)
                cntArr[map.get(s.charAt(i))]--;

            boolean check = true;
            for (int cnt = 0; cnt < 4; cnt++) {
                if (cntArr[cnt] < arr[cnt]) {
                    check = false;
                    break;
                }
            }
            if (check)
                result++;
        }
        System.out.println(result);
    }

}
