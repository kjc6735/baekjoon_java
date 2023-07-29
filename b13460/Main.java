package b13460;

import java.util.*;
import java.io.*;

public class Main {
    static int result;
    static Node blue;
    static Node red;
    static Node hole;
    static int n;
    static int m;
    static int dir[][] = {
        {1,0},
        {-1,0},
        {0,1},
        {0,-1}
    };
    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("b13460/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str[] = br.readLine().split(" ");
        n = Integer.parseInt(str[0]);
        m = Integer.parseInt(str[1]);
        char map[][] = new char[n][m];
        Node blue;
        Node red;
        Node hole;

        for (int i = 0; i < n; i++) {
            char[] chars = br.readLine().toCharArray();
            for (int k = 0; k < m; k++) {
                map[i][k] = chars[k];
                if (map[i][k] == 'B') {
                    blue = new Node(i, k);
                } else if (map[i][k] == 'R') {
                    red = new Node(i, k);
                } else if (map[i][k] == 'O') {
                    hole = new Node(i, k);
                }
            }
        }

        fn();

    }

    static void fn(int cnt){
        if (cnt == 11) {
            result = -1;
            return;
        }

        for (int i = 0; i < 4; i++) {
            int x = 
        }
        
    }

    // static boolean check(int _x, int _y, int d) {
    //     while (true) {
    //         int x = _x + dir[d][0];
    //         int y = _y + dir[d][1];
    //         if (x < 0 || y < 0 || x >= n || y >= m)
    //             return true;

    //     }
    //     return true;

    // }
    static class Node {
        int x;
        int y;

        Node(int x, int y) {
            this.x = x;
            this.y = y;

        }
    }
}
