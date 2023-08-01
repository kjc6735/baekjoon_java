package p1210;

import java.util.*;
import java.io.*;

public class Main {
    static char[][] arr = new char[100][100];

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("p1210/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int tc = 1; tc <= 10; tc++) {
            int tmp = Integer.parseInt(br.readLine());
            String str[];
            for (int i = 0; i < 100; i++) {
                str = br.readLine().split(" ");
                for (int k = 0; k < 100; k++) {
                    arr[i][k] = str[k].charAt(0);
                }
            }

            int x = 99;
            int y = 0;
            for (y = 0; y < 100; y++) {
                if (arr[x][y] == '2')
                    break;
            }
            while (x > 0) {
                while (x > 0 &&
                        ((y + 1 >= 100 && y - 1 >= 0 && arr[x][y - 1] == '0') ||
                                (y + 1 < 100 && y - 1 < 0 && arr[x][y + 1] == '0') ||
                                ((y - 1 >= 0 && arr[x][y - 1] == '0') &&
                                        (y + 1 < 100 && arr[x][y + 1] == '0')))) {
                    x--;
                }
                int num = 0;

                if (y + 1 <= 99 && arr[x][y + 1] == '1') {
                    num = 1;
                } else
                    num = -1;

                while (y + num >= 0 && y + num < 100 && arr[x][y + num] == '1')
                    y += num;
                x--;
            }

            System.out.println("#" + tc + " " + y);
        }
    }

}
