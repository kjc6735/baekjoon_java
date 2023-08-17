package p1873;

import java.util.*;
import java.io.*;

public class Solution {
    static int[] currPos = new int[3]; // x y dir
    static StringBuilder sb = new StringBuilder();
    static char arr[][];
    static int dir[][] = {
            { -1, 0 }, // 상
            { 1, 0 }, // 하
            { 0, -1 }, // 좌
            { 0, 1 } // 우
    };
    static Map<Character, Integer> dirMap = new HashMap<Character, Integer>() {
        {
            put('U', 0);
            put('D', 1);
            put('L', 2);
            put('R', 3);

        }
    };

    static int n;
    static int m;

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("p1873/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int test_case = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= test_case; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());

            arr = new char[n][m];

            for (int i = 0; i < n; i++) {
                String str = br.readLine();
                for (int k = 0; k < m; k++) {
                    arr[i][k] = str.charAt(k);
                    boolean check = arr[i][k] == '^' || arr[i][k] == 'v' || arr[i][k] == '<' || arr[i][k] == '>';
                    if (check) {
                        currPos[0] = i;
                        currPos[1] = k;
                        currPos[2] = arr[i][k] == '^' ? 0 : arr[i][k] == 'v' ? 1 : arr[i][k] == '<' ? 2 : 3;
                    }
                }
            }

            int commCnt = Integer.parseInt(br.readLine());

            String commStr = br.readLine();
            for (int i = 0; i < commCnt; i++) {
                char comm = commStr.charAt(i);
                if (comm == 'S') {
                    boom();
                } else {
                    changeDir(comm);
                }
            }
            arr[currPos[0]][currPos[1]] = currPos[2] == 0 ? '^'
                    : currPos[2] == 1 ? 'v' : currPos[2] == 2 ? '<' : '>';
            sb.append("#").append(tc).append(" ");
            print();
        }
        System.out.println(sb.toString());
    }

    static void changeDir(char c) {
        int dirIdx = dirMap.get(c);

        // 방향 변경
        currPos[2] = dirIdx;

        int moveX = currPos[0] + dir[dirIdx][0];
        int moveY = currPos[1] + dir[dirIdx][1];

        // 좌표 확인
        boolean check = moveX >= 0 && moveY >= 0 && moveX < n && moveY < m;

        // 범위 벗어나거나, 평지가 아니면
        if (!check || arr[moveX][moveY] != '.')
            return;

        arr[currPos[0]][currPos[1]] = '.';

        // 이동
        currPos[0] = moveX;
        currPos[1] = moveY;

    }

    static void print() {
        for (int i = 0; i < n; i++) {
            for (int k = 0; k < m; k++) {
                sb.append(arr[i][k]);
            }
            sb.append('\n');
        }
    }

    static boolean inRange(int x, int y) {
        return x >= 0 && y >= 0 && x < n && y < m;
    }

    static void boom() {
        int currDir = currPos[2];

        int currX = currPos[0] + dir[currDir][0];
        int currY = currPos[1] + dir[currDir][1];

        // 범위 벗어나기 전까지.. 땅/강이 아니고
        while (inRange(currX, currY) && (arr[currX][currY] == '.' || arr[currX][currY] == '-')) {
            currX += dir[currDir][0];
            currY += dir[currDir][1];
        }

        // 범위 나가거나 철이면
        if (!inRange(currX, currY) || arr[currX][currY] == '#')
            return;

        arr[currX][currY] = '.';
    }

}
