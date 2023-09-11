package b2149;

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("b2149/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        char[] key = br.readLine().toCharArray();
        Node[] nodes = new Node[key.length];
        for (int i = 0; i < key.length; i++) {
            nodes[i] = new Node(i, key[i]);
        }
        String str = br.readLine();

        for (int i = 0; i < str.length(); i++) {
            nodes[i % key.length].arr.add(str.charAt(i));
        }

        Arrays.sort(nodes);
        boolean used[] = new boolean[key.length];
        ArrayList<Integer> result = new ArrayList<>();
        for (int k = 0; k < key.length; k++) {
            for (int c = 0; c < nodes.length; c++) {
                if (nodes[c].key == key[k]) {
                    if (used[c])
                        continue;
                    result.add(c);
                    used[c] = true;
                }
            }
        }

        for (int i = 0; i < key.length; i++) {
            for (int k = 0; k < result.size(); k++) {
                System.out.print(nodes[k].arr.get(i));
            }
        }
    }

    static class Node {
        int index;
        char key;
        ArrayList<Character> arr = new ArrayList<>();

        Node(int index, char key) {
            this.index = index;
            this.key = key;
        }

        // @Override
        // public int compareTo(Node o) {
        // if (this.key == o.key) {
        // return this.index - o.index;
        // }
        // return this.key - o.key;
        // }

    }
}
