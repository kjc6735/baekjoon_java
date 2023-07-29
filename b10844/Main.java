package b10844;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class Main {
    static long total_cnt = 0;
    static int n;
    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("b10844/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        for (int i = 1; i <10; i++) {
            fn(String.valueOf(i), 1);
        }

        System.out.println(total_cnt);

    }

    static void fn(String str, int cnt) {
        if (cnt == n) {
            total_cnt = (total_cnt + 1) % 1000000000;
            return;
        }

        if (str.charAt(cnt - 1) == '0') {
            fn(str + "0", cnt + 1);
        }else if(str.charAt(cnt - 1) == '9'){
            fn(str + "8", cnt + 1);
        } else {
           String s1 = String.valueOf( str.charAt(cnt - 1) + 1);
           String s2 = String.valueOf( str.charAt(cnt - 1) - 1);

           fn(str + s1, cnt + 1);
           fn(str + s2, cnt + 1);
        }
      
    }
    
}
