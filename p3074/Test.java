package p3074;

import java.util.PriorityQueue;

public class Test {
    public static void main(String[] args) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        for (int i = 0; i < 10; i++) {
            pq.add(new Node(i, (long) 10 - i));
        }

        for (int i = 0; i < 10; i++) {
            System.out.println(pq.poll().time);
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