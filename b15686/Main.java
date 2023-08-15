package b15686;

import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static int m;
    static int arr[][];
    static List<Pos> chick = new ArrayList<>();
    static List<Pos> home = new ArrayList<>();
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("b15686/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[n][n];
        chick = new ArrayList<>();
        home = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int k = 0; k < n; k++) {
                arr[i][k] = Integer.parseInt(st.nextToken());
                if (arr[i][k] == 2)
                    chick.add(new Pos(i, k));
                else if (arr[i][k] == 1) {
                    home.add(new Pos(i, k));
                }
            }
        }

        find(0, 0, new boolean[chick.size()]);
        System.out.println(min);

    }

    static void find(int idx, int cnt, boolean visited[]) {
        if (cnt == m) {
            int s = 0;
            for (int k = 0; k < home.size(); k++) {
                int tmp = Integer.MAX_VALUE;

                for (int i = 0; i < chick.size(); i++) {
                    if (!visited[i])
                        continue;
                    int result = Math.abs(home.get(k).x - chick.get(i).x) + Math.abs(home.get(k).y - chick.get(i).y);
                    if (tmp > result)
                        tmp = result;
                }
                s += tmp;
            }
            if (min > s)
                min = s;
            return;
        }
        if(cnt < m && idx == chick.size()) return ;
        visited[idx] = true;
        find(idx + 1, cnt + 1, visited);
        visited[idx] = false;
        find(idx + 1, cnt, visited);
    }

    static void find(int idx, int cnt, boolean visited[]) {
        if (cnt == m) {
            int s = 0;
            for (int k = 0; k < home.size(); k++) {
                int tmp = Integer.MAX_VALUE;

                for (int i = 0; i < chick.size(); i++) {
                    if (!visited[i])
                        continue;
                    int result = Math.abs(home.get(k).x - chick.get(i).x) + Math.abs(home.get(k).y - chick.get(i).y);
                    if (tmp > result)
                        tmp = result;
                }
                s += tmp;
            }
            if (min > s)
                min = s;
            return;
        }

        for (int i = 0; i < chick.size(); i++) {
            if (visited[i])
                continue;

            visited[i] = true;
            find(idx + 1, cnt + 1, visited);
            visited[i] = false;
        }
    }

    static int calc(int x, int y, int x1, int y1) {
        return Math.abs(x - x1) + Math.abs(y - y1);
    }

    static class Pos {
        int x;
        int y;

        Pos(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
