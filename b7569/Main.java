// package b7569;

import java.util.*;
import java.io.*;

public class Main {
    static int arr[][][];
    static int n ;
    static int m ;
    static int h;
    
    static int dir[][]= {
        {0,1,0}, 
        {0,-1, 0 },
        {0,0,1},
        {0,0,-1},
        {1,0,0},
        {-1,0,0},
    };
    public static void main(String[] args) throws Exception {
        // System.setIn(new FileInputStream("b7569/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        h = Integer.parseInt(st.nextToken());
        arr= new int[h][m][n];

        Queue<Node> queue = new LinkedList<>();

        for (int k = 0; k < h; k++) {
            for (int a = 0; a < m; a++) {
                st = new StringTokenizer(br.readLine(), " ");
                for (int i = 0; i < n; i++) {
                    arr[k][a][i] = Integer.parseInt(st.nextToken());
                    if (arr[k][a][i] == 1)
                        queue.add(new Node(k, a, i));
                }
            }
        }
        int cnt = 0;
        
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size-- > 0) {
                Node node = queue.poll();
                for (int i = 0; i < 6; i++) {
                    int hh = node.h + dir[i][0];
                    int mm = node.m + dir[i][1];
                    int nn = node.n + dir[i][2];

                    if (!range(hh, mm, nn))
                        continue;

                    if (arr[hh][mm][nn] != 0) {
                        continue;
                    }
                    arr[hh][mm][nn] = 1;

                    queue.add(new Node(hh, mm, nn));
                }
            }
            if(!queue.isEmpty()) cnt ++;
        }
        // System.out.println(cnt + " "+ check());
        if (check()) {
            if (cnt == 0)
                System.out.println(0);
            else System.out.println(cnt);
        }else System.out.println(-1);
    }
    
    static boolean range(int _h, int _m, int _n) {
        return _h >= 0 && _h < h && _m >= 0 && _m < m && _n >= 0 && _n < n; 
    }

    static boolean check() {
        for (int k = 0; k < h; k++) {
            for (int a = 0; a < m; a++) {
                for (int i = 0; i < n; i++) {
                    if (arr[k][a][i] == 0)
                        return false;
                }
            }
        }
        return true;
    }
    static class Node {
        int h;
        int m;
        int n;

        Node(int h, int m, int n) {
            this.h = h;
            this.m = m;
            this.n = n;
        }
    }
}
