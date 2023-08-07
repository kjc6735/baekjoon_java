package b2493;

import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("b2493/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        Stack<Integer> stack = new Stack<>();

        for(int i = 0; i < n; i++){
            int num = Integer.parseInt(br.readLine());
            
            if(stack.isEmpty() || stack.peek() > stack)
        }

        

    }
}
