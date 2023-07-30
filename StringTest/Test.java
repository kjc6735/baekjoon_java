package StringTest;

import java.util.*;

public class Test {
    public static void main(String[] args) {
        // Integer a = Integer.valueOf("10");
        // Integer b = 10;
        // Integer c = new Integer(10);
        // Integer d = Integer.parseInt("10");
        Integer a = Integer.valueOf("200");
        Integer b = 200;
        Integer c = new Integer(200);
        Integer d = Integer.parseInt("200");

        System.out.println(a == b);
        System.out.println(a == c);
        System.out.println(a.equals(c));
        System.out.println(a == d);
        System.out.println(b == d);

        int  e = 200;
        System.out.println(e == c);

    }
}
