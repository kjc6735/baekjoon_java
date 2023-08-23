package b2504;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("b2504/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        HashMap<Character, Character> map = new HashMap<>();

        char[] str = br.readLine().toCharArray();
        Stack<Character> stack = new Stack<>();
        map.put(')', '(');
        int result = 0;
        for (int i = 0; i < str.length; i++) {
            if (str[i] == '(' || str[i] == '[') {
                stack.add(str[i]);
                continue;
            }
        }

        System.out.println(result);
    }

}
