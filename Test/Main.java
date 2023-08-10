package Test;

import java.util.*;

import org.xml.sax.HandlerBase;

public class Main {
    public static void main(String[] args) {
        // Node node1 = new Node(0, 0, 0);
        // Node node2 = new Node(1, 1, 1);
        // Node node3 = new Node(0, 0, 0);

        // Map<Node, Integer> map = new HashMap<>();
        // map.put(new Node(0, 0, 0), 1);
        // System.out.println(map.get(new Node(0, 0, 0)));
        System.out.println();
    }

    static class Node {
        int x;
        int y;
        int cnt = 0;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public Node(int x, int y, int cnt) {
            this(x, y);
            this.cnt = cnt;
        }
    }
}
