package b16928;

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        // System.setIn(new FileInputStream("")))
        // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Integer test = new Integer(500);
        test(test);
        System.out.println(test);

        Node node = new Node();
        test2(node);
        System.out.println(node.a);
        System.out.println(node.test);

    }

    static void test(Integer t) {
        t = new Integer(100);

    }

    static void test2(Node test) {
        test.a = 200;
        test.test = "asdfg";
    }

    static class Node {
        int a = 300;
        String test = "test";
    }
}
