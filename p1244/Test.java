package p1244;

import java.util.ArrayList;

public class Test {
    public static void main(String[] args) {
        ArrayList<Integer> in = new ArrayList<>();
        in.add(1234);
        char[] c = in.get(0).toString().toCharArray();
        System.out.println(String.valueOf(c));
    }
}
