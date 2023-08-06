package p1218;

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream("p1218/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Map<Character, Character> map = new HashMap<>();
        map.put('{', '}');
        map.put('<', '>');
        map.put('(', ')');
        map.put('[', ']');

        for (int tc = 1; tc <= 10; tc++) {
            br.readLine();
            String str = br.readLine();
            Stack<Character>  stack = new Stack<>();
            boolean check = true;
            for (int i = 0; i < str.length(); i++) {
                if (map.getOrDefault(str.charAt(i), null) != null) {
                    stack.add(str.charAt(i));
                    continue;
                }

                if (stack.isEmpty() || map.get(stack.peek()) != str.charAt(i)) {
                    check = false;
                    break;
                }

                stack.pop();

            }
            System.out.println("#" + tc +" " + (check ? 1 : 0 ));
        }

    }
    
}
