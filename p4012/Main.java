package p4012;

import java.util.*;
import java.io.*;

public class Main {
    static int min = Integer.MAX_VALUE;
    static int n;
    static int arr[][];
    static int sumArr[];

    static int visited[] = new int[20];

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("p0412/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int test_case = Integer.parseInt(br.readLine());
        StringTokenizer st;
        for (int tc = 1; tc <= test_case; tc++) {
            n = Integer.parseInt(br.readLine());
            arr = new int[n][n];
            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                for (int k = 0; k < n; k++) {
                    arr[i][k] = Integer.parseInt(st.nextToken());
                }
            }
        }
    }

    static void find(int cnt, int aValue, int bValue) {
        if (cnt == n) {
            int result = Math.abs(aValue - bValue);
            if (min > result)
                min = result;
            return ;
        }
        int sum = 0;
        for(int i = 0; i < cnt; i++){
            if(visited[cnt] == 0) continue;
            sum+= arr[i][cnt];
            sum+= arr[cnt][i];
        }
        find(cnt + 1, );
        find(cnt + 1, );
    }
}
