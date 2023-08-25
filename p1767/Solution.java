package p1767;

import java.io.*;
import java.util.*;

public class Solution {
    static int dir[][] = {
            { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 }
    };
    static int arr[][];
    static int N;
    static ArrayList<Node> nodes = new ArrayList<>();
    static int result = Integer.MAX_VALUE;
    static int maxCellCnt = 0;

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("p1767/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int test_case = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int tc = 1; tc <= test_case; tc++) {
            N = Integer.parseInt(br.readLine());
            arr = new int[N][N];

            // 입력
            for (int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int k = 0; k < N; k++) {
                    arr[i][k] = Integer.parseInt(st.nextToken());
                    if (arr[i][k] == 1 && !(i == 0 || i == N - 1 || k == 0 || k == N - 1))
                        nodes.add(new Node(i, k));
                }
            }

            fn(0, 0, 0);
            sb.append("#").append(tc).append(" ").append(result).append("\n");
            nodes = new ArrayList<>();
            result = Integer.MAX_VALUE;
            maxCellCnt = 0;
        }
        System.out.println(sb);

    }

    static void fn(int idx, int cellCnt, int lineCnt) {
        if (idx == nodes.size()) {
            if (cellCnt > maxCellCnt) {
                maxCellCnt = cellCnt;
                result = lineCnt;
            } else if (cellCnt == maxCellCnt) {
                if (result > lineCnt) {
                    result = lineCnt;
                }
            }

            return;
        }
        Node node = nodes.get(idx);
        for (int i = 0; i < 4; i++) {
            int x = node.x + dir[i][0];
            int y = node.y + dir[i][1];

            while (!(x < 0 || y < 0 || x >= N || y >= N) && arr[x][y] == 0) {
                x += dir[i][0];
                y += dir[i][1];
            }
            // 중간에 뭘 만난거임
            if (!(x < 0 || y < 0 || x >= N || y >= N)) {
                fn(idx + 1, cellCnt, lineCnt);
                continue;
            }
            x = node.x + dir[i][0];
            y = node.y + dir[i][1];
            int cnt = 0;
            // 세팅
            while (!(x < 0 || y < 0 || x >= N || y >= N)) {
                arr[x][y] -= 1;
                x += dir[i][0];
                y += dir[i][1];
                cnt++;
            }

            fn(idx + 1, cellCnt + 1, lineCnt + cnt);
            x = node.x + dir[i][0];
            y = node.y + dir[i][1];
            while (!(x < 0 || y < 0 || x >= N || y >= N)) {
                arr[x][y] += 1;
                x += dir[i][0];
                y += dir[i][1];
            }

        }
    }

    static class Node {
        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }

        int x, y;

    }
}
