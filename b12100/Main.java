package b12100;

import java.util.*;
import java.io.*;

public class Main {
    static int N;
    static int map[][];
    static int max = 0;
    static int dir[][] = {
            { 1, 0 }, { 0, 1 }, { 0, -1 }, { -1, 0 }
    };

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("b12100/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];

        for (int i = 0; i < N; i++) {
            String str[] = br.readLine().split(" ");
            for (int k = 0; k < N; k++) {
                map[i][k] = Integer.parseInt(str[k]);
            }
        }
    }

    static void find() {

    }

    static void move(int arr[][], int[] currDir) {
        for (int i = 0; i < arr.length; i++) {
            for (int k = 0; k < arr.length; k++) {
                int x = arr[i][k] + currDir[0];
                int y = arr[i][k] + currDir[1];

            }
        }
    }
}
