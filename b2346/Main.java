package b2346;

import java.util.*;
import java.io.*;
public class Main {
    
    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("b2346/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        String str[] = br.readLine().split(" ");

        Deque<Node> queue = new ArrayDeque<>();

        for (int i = 0; i < n; i++)
            queue.add(new Node(i + 1, Integer.parseInt(str[i])));
        
        while(!queue.isEmpty()){
            Node node = queue.poll();
            int num = node.num;
            System.out.print(node.index + " ");
            if(queue.isEmpty()) break;
            if (num > 0)
                for(int i = 0; i < num -1 ; i++) queue.add(queue.poll());

            else {
                num *= -1;
                for(int i = 0; i < num ; i++) queue.addFirst(queue.pollLast());
            }
        }
    }

    static class Node {
        int index;
        int num;

        public Node(int index, int num) {
            this.index = index;
            this.num = num;
        }
    }
}
