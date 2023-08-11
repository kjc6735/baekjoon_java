package p5215;

import java.util.*;
import java.io.*;

public class Main {
    static int maxCal = 0;
    static int n = 0;
    static int maxScore = 0;
    static int arr[][] = new int[20][2];

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("b5215/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int test_case = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= test_case; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            n = Integer.parseInt(st.nextToken());
            maxCal = Integer.parseInt(st.nextToken());

            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                arr[i][0] = Integer.parseInt(st.nextToken());
                arr[i][1] = Integer.parseInt(st.nextToken());
            }

            find(0, 0, 0);
            System.out.println("#" + tc + " " + maxScore);
            maxScore = 0;
        }

    }

    static void find(int cnt, int score, int cal) {
        if (maxCal < cal)
            return;
        maxScore = maxScore < score ? score : maxScore;
        if (cnt == n) {
            return;
        }
        find(cnt + 1, score + arr[cnt][0], cal + arr[cnt][1]);
        find(cnt + 1, score, cal);
    }

}
