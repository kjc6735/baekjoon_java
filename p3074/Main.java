package p3074;

import java.util.*;
import java.io.*;

class Solution
{
	public static void main(String args[]) throws Exception
    {
      
        System.setIn(new FileInputStream("p3074/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int T = Integer.parseInt(br.readLine());
      
        int[] delay = new int[100000];

        for (int test_case = 1; test_case <= T; test_case++) {
            long max = 0;
            String[] str = br.readLine().split(" ");
            int n = Integer.parseInt(str[0]);
            int m = Integer.parseInt(str[1]);
            PriorityQueue<Node> pq = new PriorityQueue<>();
            for (int i = 0; i < n; i++) {
                int tmp = Integer.parseInt(br.readLine());
                delay[i] = tmp;
                pq.add(new Node(i, delay[i]));
            }
            while (m-- > 0) {
                Node node = pq.poll();
                // max = Math.max(max, node.time);
                max = max < node.time ? node.time : max;
                node.time += (long) delay[node.index];
                pq.add(node);
            }
            System.out.println("#" + test_case + " " + max);
        }

    }

    static class Node implements Comparable<Node> {
        int index;
        long time;

        Node(int i, long t) {
            this.index = i;
            this.time = t;
        }

        @Override
        public int compareTo(Node o) {

            if (this.time > o.time) {
                return 1;
            }
            return -1;
           
        }
    }
}