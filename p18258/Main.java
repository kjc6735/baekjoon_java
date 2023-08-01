package p18258;

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("p18258/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Deque<Integer> queue = new LinkedList<>();
        StringBuilder sb = new StringBuilder();
        String str[];
        for (int i = 0; i < n; i++) {
            str = br.readLine().split(" ");
            if (str[0].equals("push")) {
                queue.add(Integer.parseInt(str[1]));
            } else if (str[0].equals("front")) {
                if (queue.size() == 0) {
                    sb.append(-1).append("\n");
                    // System.out.println(-1);
                } else {
                    sb.append(queue.getFirst()).append("\n");

                    // System.out.println(queue.getFirst());
                }

            } else if (str[0].equals("back")) {
                if (queue.size() == 0) {
                    sb.append(-1).append("\n");

                    // System.out.println(-1);
                } else {
                    sb.append(queue.getLast()).append("\n");

                }
            } else if (str[0].equals("size")) {
                sb.append(queue.size()).append("\n");

                // System.out.println(queue.size());

            } else if (str[0].equals("empty")) {
                // System.out.println(queue.isEmpty() ? 1 : 0);
                sb.append(queue.isEmpty() ? 1 : 0).append("\n");
            } else if (str[0].equals("pop")) {
                if (queue.size() == 0) {
                    sb.append(-1).append("\n");
                } else {
                    int tmp = queue.peek();
                    sb.append(tmp).append("\n");
                    queue.pop();
                }

            }
        }
        System.out.println(sb.toString());

    }
}
