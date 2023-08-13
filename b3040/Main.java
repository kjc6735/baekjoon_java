package b3040;

import java.util.*;
import java.io.*;

public class Main {
    static int arr[] = new int[9];
    static int ans = 0;
    static boolean check = false;
    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("b3040/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < 9; i++)
            arr[i] = Integer.parseInt(br.readLine());

        find(0, 0, 0, new boolean[9]);
    }

    static void find(int idx, int cnt, int sum, boolean visited[]) {
        if(check == true) return;

        if (cnt == 7) {
            if (sum == 100) {
                check = true;
                for (int i = 0; i < 9; i++) {
                    if (!visited[i])
                        continue;
                    System.out.println(arr[i]);
                }
                return ;
            }
        }

        for (int i = 0; i < 9; i++) {
            if (visited[i])
                continue;
            visited[i] = true;
            find(idx + 1, cnt + 1, sum + arr[i], visited);
            visited[i] = false;
        }
    }
}
