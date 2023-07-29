package b18111;

import java.util.*;
import java.io.*;
public class Test {
    public static void main(String[] args) {
        PriorityQueue<Node> pq = new PriorityQueue<>(new Comparator<Node>() {
            @Override
            public int compare(Node n1, Node n2) {
                return n1.value >= n2.value ? 1 : -1; 
            }
        });
        PriorityQueue<Node> order = new PriorityQueue<>(new Comparator<Node>() {
            @Override
            public int compare(Node n1, Node n2) {
                return n1.value < n2.value ? 1 : -1; 
            }
        });

        for (int i = 0; i < 3; i++) {
            for (int k = 0; k < 3; k++) {
                Node n = new Node(i, k, i - k);
                pq.add(n);
                order.add(new Node(i, k, i - k));
            }
        }

        
    }
    static class Node {
        int x;
        int y;
        int value;

        Node(int x, int y, int v) {
            this.x = x;
            this.y = y;
            this.value = v;
        }
        // @Override
        // public int compareTo(Node o) {
        //     if (this.value >= o.value) {
        //         return 1;
        //     }
        //     return -1;
        // }

        @Override
        public String toString() {
            return String.valueOf(this.x)+ " " + String.valueOf(this.y) + " "+String.valueOf(this.value);
        }
    }
    // static class Node implements Comparable<Node>{
    //     int x;
    //     int y;
    //     int value;

    //     Node(int x, int y, int v) {
    //         this.x = x;
    //         this.y = y;
    //         this.value = v;
    //     }
    //     // @Override
    //     // public int compareTo(Node o) {
    //     //     if (this.value >= o.value) {
    //     //         return 1;
    //     //     }
    //     //     return -1;
    //     // }

    //     @Override
    //     public String toString() {
    //         return String.valueOf(this.x)+ " " + String.valueOf(this.y) + " "+String.valueOf(this.value);
    //     }
    // }
}
