package b14891;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static int arr[] = new int[4];
    static int index[] = new int[8];

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("b14891/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < 4; i++) {
            String str = br.readLine();

            for (int k = 0; k < 8; k++) {

            }

        }

        int m = Integer.parseInt(br.readLine());
        for (int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

        }
    }
}
