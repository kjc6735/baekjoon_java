package b10799;

import java.util.Stack;
import java.io.*;
public class Main {
    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("b10799/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Stack<Character> stack = new Stack<>();
        char[] arr = br.readLine().toCharArray();

        int total = 0;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == '(') {
                stack.add('(');
                continue;
            }
            //처음부터 ) 로 나올 수 없음 

            //레이저인경우 () 
            stack.pop();

            if (arr[i - 1] == '(') {
                total += stack.size();
            } else {
                total += 1;
            }
        }
        System.out.println(total);

    }
}
