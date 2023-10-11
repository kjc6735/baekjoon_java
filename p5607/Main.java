package p5607;

import java.io.*;

public class Main {
    static long MOD = 1234567891;
    static long arr[] = new long[1000001];

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("p5607/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int test_case = Integer.parseInt(br.readLine());
        long tmpN = 0L;
        for (int i = 1; i <= tmpN; i++)
            arr[i] = (arr[i - 1] * (long) i) % MOD;
        StringBuilder sb = new StringBuilder();
        for (int tc = 1; tc <= test_case; tc++) {
            String str[] = br.readLine().split(" ");
            int N = Integer.parseInt(str[0]);

            int R = Integer.parseInt(str[1]);

            sb.append("#").append(tc).append(" ").append(((arr[tmpN] / arr[tmpN - R]) / arr[R]) % MOD).append("\n");
        }

        System.out.print(sb.toString());
    }
}
