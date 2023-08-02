package b1011;

import java.util.*;
import java.io.*;

public class Main {
    static int n;
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("b1011/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        Queue<Node> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            String str[] = br.readLine().split(" ");
            int a = Integer.parseInt(str[0]);
            int b = Integer.parseInt(str[1]);
            queue.add(new Node(0, a, 0));

            while (!queue.isEmpty()) {
                int size = queue.size();
                for(int k = 0; k < size; k++){
                    Node node = queue.poll();
                    if(node.pos > )
                    queue.add(new Node(node.cnt + 1,  ));
                }                
            }
        }
    }

    static class Node {
        int cnt;
        int pos;
        int len;

        public Node(int cnt, int pos, int len) {
            this.cnt = cnt;
            this.pos = pos;
            this.len = len;
        }
    }

    // static void find(int pos, int len, int cnt) {
    // if (pos == n / 2) {

    // return;
    // }
    // if (pos > n / 2)
    // return;
    // if(pos -1)

    // find(pos + len + 1, len + 1, cnt + 1);
    // find(pos + len, len, cnt + 1);
    // find(pos + len - 1, len - 1, cnt + 1);
    // }
}
