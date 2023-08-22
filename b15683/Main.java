package b15683;

import java.io.*;
import java.util.*;

public class Main {
    static List<Node> cctv = new LinkedList<>();
    static int n, m;
    static int arr[][];
    static int result = Integer.MAX_VALUE;
    static int[][] cctvNum = {
            { 0, 0, 0, 0 },
            { 1, 0, 0, 0 },
            { 1, 0, 1, 0 },
            { 1, 1, 0, 0 },
            { 1, 1, 1, 0 },
            { 1, 1, 1, 1 }
    };

    static int dir[][] = {
            { 0, 1 },
            { -1, 0 },
            { 0, -1 },
            { 1, 0 }
    };
    // 밀어야 하는 횟수
    static int[] dirCnt = {
            0, 4, 2, 4, 4, 1
    };

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("b15683/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str[] = br.readLine().split(" ");
        n = Integer.parseInt(str[0]);
        m = Integer.parseInt(str[1]);

        arr = new int[n][m];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int k = 0; k < m; k++) {
                arr[i][k] = Integer.parseInt(st.nextToken());
                if (arr[i][k] == 0 || arr[i][k] == 6)
                    continue;
                cctv.add(new Node(i, k));
            }
        }

        fn(0);
        System.out.println(result);

    }

    static void shift(int array[]) {
        int tmp = array[array.length - 1];
        for (int i = array.length - 1; i >= 1; i--) {
            array[i] = array[i - 1];
        }
        array[0] = tmp;
    }

    static void fn(int cnt) {
        if (cnt == cctv.size()) {
            int cctvCoverRange = 0;
            for (int i = 0; i < n; i++) {
                for (int k = 0; k < m; k++) {
                    if (arr[i][k] == 0) {
                        cctvCoverRange++;
                    }
                }
            }
            if (cctvCoverRange < result)
                result = cctvCoverRange;

            return;
        }

        Node currNode = cctv.get(cnt);

        int cctvNumber = arr[currNode.x][currNode.y]; // 3번 ...

        int rotateCnt = dirCnt[cctvNumber];

        int cctvRotateArray[] = Arrays.copyOf(cctvNum[cctvNumber], cctvNum[cctvNumber].length);

        for (int i = 0; i < rotateCnt; i++) {
            for (int k = 0; k < cctvRotateArray.length; k++) {
                if (cctvRotateArray[k] == 0)
                    continue;
                set(currNode.x, currNode.y, dir[k], 0, 9, 1);
            }
            fn(cnt + 1);
            for (int k = 0; k < cctvRotateArray.length; k++) {
                if (cctvRotateArray[k] == 0)
                    continue;
                set(currNode.x, currNode.y, dir[k], 9, 0, -1);
            }
            shift(cctvRotateArray);
        }
    }

    static void set(int xx, int yy, int dir[], int from, int to, int add) { // cctv 입력받음
        int x = xx + dir[0];
        int y = yy + dir[1];
        while (x >= 0 && y >= 0 && x < n && y < m && arr[x][y] != 6) {
            if (arr[x][y] == from) {
                arr[x][y] = to;
            } else if (arr[x][y] >= 9)
                arr[x][y] += add;

            x += dir[0];
            y += dir[1];
        }
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
