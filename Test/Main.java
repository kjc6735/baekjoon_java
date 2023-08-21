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
        // Set<Integer> set = new HashSet<>();
        // set.add(1);

        // set.remove(2);
        // System.out.println();

        // Set<Node> set = new HashSet<>();
        // set.add(new Node(10, 20));

        // set.add(new Node(10, 20));

        // System.out.println(set.size());

        // List<Integer> list = new LinkedList<>();

        // System.out.println(list.get(200));

        TreeSet<Integer> tree = new TreeSet<>();

        tree.add(10);
        tree.add(15);
        tree.add(20);

        tree.add(22);
        for (int a : tree) {
            System.out.println(a);
        }
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

        @Override
        public boolean equals(Object obj) {
            if (this == obj)
                return true;
            Node node = (Node) obj;
            if (this.x == node.x && this.y == node.y)
                return true;
            return false;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }
    }
}
