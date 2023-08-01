package q1021;

import java.util.*;
import java.io.*;

public class Main {
    static int totalCnt = 0;
    static int n, m;
    static LinkedList<Integer> list = new LinkedList<>();

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("q1021/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] str = br.readLine().split(" ");
        n = Integer.parseInt(str[0]);
        m = Integer.parseInt(str[1]);
        str = br.readLine().split(" ");

    }

}
