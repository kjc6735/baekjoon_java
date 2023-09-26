package b14502;

import java.util.*;
import java.io.*;

public class Main2 {
    static int tmpCnt = 0, cnt = 0, max = 0, wallCnt = 0;
    static int dir[][] = {
            { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 }
    };
    static long visited2 = 0L, arr = 0L, n, m;
    static ArrayList<int[]> virus = new ArrayList<>();

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("b14502/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str[] = br.readLine().split(" ");

        n = Long.parseLong(str[0]);
        m = Long.parseLong(str[1]);

        for (int i = 0; i < n; i++) {
            str = br.readLine().split(" ");
            for (int k = 0; k < m; k++) {
                long tmp = Long.parseLong(str[k]);
                if (tmp != 0L)
                    arr |= (1L << (i * m + k));

                if (tmp == 1L)
                    wallCnt++;
                else if (tmp == 2L) {
                    virus.add(new int[] { i, k });
                }
            }
        }
        int size = (int) (n * m);
        for (int a = 0; a < size - 2; a++) {
            if ((arr & (1L << a)) != 0)
                continue;
            arr |= (1L << a);
            for (int b = a + 1; b < size - 1; b++) {
                if ((arr & (1L << b)) != 0)
                    continue;
                arr |= (1L << b);
                for (int c = b + 1; c < size; c++) {
                    if ((arr & (1L << c)) != 0)
                        continue;
                    arr |= (1L << c);

                    for (int[] v : virus) {
                        find(v[0], v[1]);
                    }
                    // 총 배열 크기 - 벽 갯수 - 방문 갯수 - 벽3개 - 기존 바이러스 갯수
                    int tmpMax = size - wallCnt - Long.bitCount(visited2) - 3 - virus.size();
                    if (max < tmpMax)
                        max = tmpMax;

                    visited2 = 0L;
                    arr ^= (1L << c);
                }
                arr ^= (1L << b);
            }
            arr ^= (1L << a);
        }

        System.out.println(max);
    }

    static void find(int xx, int yy) {
        for (int i = 0; i < 4; i++) {
            int x = xx + dir[i][0];
            int y = yy + dir[i][1];

            if (x < 0 || y < 0 || x >= n || y >= m || (arr & (1L << (x * m + y))) != 0
                    || (visited2 & (1L << (x * m + y))) != 0)
                continue;
            visited2 |= (1L << (x * m + y));
            find(x, y);
        }
    }
}
