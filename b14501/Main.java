package b14501;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class Main {
    static int n;
    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("b14501/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        int arr[][] = new int[n + 1 ][2];
        for (int i = 1; i <=n; i++) {
            String str[] = br.readLine().split(" ");
            int t = Integer.parseInt(str[0]);
            int p = Integer.parseInt(str[1]);

            arr[i][0] = t;
            arr[i][1] = p;
        }
        int max = 0;
        for (int i = 1; i <= n; i++) {
            int m = 0;
            int current = i;
            for (int k = i; k <= n; k++) {
                if (current > k)
                    continue;

                if (current + (arr[k][0] - 1) > n) {
                    break;
                }
                current += arr[k][0];
                m += arr[k][1];
            }

            max = Math.max(max, m);
        }
        System.out.println(max);

    }

    
    
}
