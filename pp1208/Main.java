package pp1208;

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("p1208/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PriorityQueue<Integer> min = new PriorityQueue<>();
        PriorityQueue<Integer> max = new PriorityQueue<>(Collections.reverseOrder());

        for (int tc = 1; tc <= 10; tc++) {
            min.clear();
            max.clear();
            int n = Integer.parseInt(br.readLine());
            String str[] = br.readLine().split(" ");
            for (int i = 0; i < 100; i++) {
                int num = Integer.parseInt(str[i]);
                min.add(num);
                max.add(num);
            }

            for (int i = 0; i < n; i++) {
                int maxNum = max.poll();
                int minNum = min.poll();
                max.remove(minNum);
                min.remove(maxNum);
                maxNum -= 1;
                minNum += 1;
                min.add(maxNum);
                min.add(minNum);

                max.add(minNum);
                max.add(maxNum);
            }

            System.out.println("#" + tc + " " + (max.poll() - min.poll()));

        }
    }
}
