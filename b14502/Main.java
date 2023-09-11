package b14502;

import java.util.*;
import java.io.*;

public class Main {
    static int n, m, arr[][], tmpCnt = 0, cnt = 0, wallCnt = 0;
    static int dir[][] = {
            { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 }
    };
    static int visited[];
    static int visitedTmp[];

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("b14502/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str[] = br.readLine().split(" ");

        n = Integer.parseInt(str[0]);
        m = Integer.parseInt(str[1]);
        visited = new int[n];
        ArrayList<Node> virus = new ArrayList<>();
        arr = new int[n][m];
        for (int i = 0; i < n; i++) {
            str = br.readLine().split(" ");
            for (int k = 0; k < m; k++) {
                arr[i][k] = Integer.parseInt(str[k]);
                if (arr[i][k] == 1)
                    wallCnt += 1;
                if (arr[i][k] == 2) {
                    virus.add(new Node(i, k));
                }
            }
        }

        for (int a = 0; a < n * m - 2; a++) {
            if (arr[a / m][a % m] != 0)
                continue;
            arr[a / m][a % m] = 1;
            for (int b = a + 1; b < n * m - 1; b++) {

                if (arr[b / m][b % m] != 0)
                    continue;
                arr[b / m][b % m] = 1;
                for (int c = b + 1; c < n * m; c++) {
                    if (arr[c / m][c % m] != 0)
                        continue;
                    arr[c / m][c % m] = 1;

                    arr[c / m][c % m] = 0;
                }
                arr[b / m][b % m] = 0;
            }
            arr[a / m][a % m] = 0;
        }
    }

    static void find(int xx, int yy) {

    }

    static class Node {
        int x;
        int y;

        Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
