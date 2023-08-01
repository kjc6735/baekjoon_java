package b11279;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("b11279/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());

        for (int i = 0; i < n; i++) {
            int a = Integer.parseInt(br.readLine());
            if (a != 0) {
                queue.add(a);
                continue;
            }
            System.out.println(queue.isEmpty() ? 0 : queue.poll());

        }

    }
}
