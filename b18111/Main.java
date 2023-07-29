package b18111;

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("b18111/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str[] = br.readLine().split(" ");
        int n = Integer.parseInt(str[0]);
        int m = Integer.parseInt(str[1]);
        int b = Integer.parseInt(str[2]);

        int result_time = Integer.MAX_VALUE;

        int map[][] = new int[n][m];
        int minH = 256; 
        int maxH = 0;
        int resultH = 0;
        for (int i = 0; i < n; i++) {
            str = br.readLine().split(" ");
            for (int k = 0; k < m; k++) {
                map[i][k] = Integer.parseInt(str[k]);
                minH = Math.min(minH, map[i][k]);
                maxH = Math.max(maxH, map[i][k]);
            }
        }

        for (int h = minH; h <= maxH; h++) {
            int time = 0;
            int block = b;
            for (int x = 0; x < n; x++) {
                for (int y = 0; y < m; y++) {
                    if (h < map[x][y]) {
                        int cnt = (map[x][y] - h);
                        time += cnt * 2;
                        block += cnt;
                    } else {
                        int cnt = (h - map[x][y]);
                        time += cnt;
                        block -= 1;
                    }
                }
            }
            if (block < 0)
                break;
            if(time <= result_time){
                result_time = time;
                resultH = h;
            }

        }
        System.out.println(result_time + " " + resultH);


    }
   
}
