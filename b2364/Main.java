package b2364;

import java.io.*;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
public class Main {
    public static void main(String[] args)throws Exception {
        System.setIn(new FileInputStream("b2364/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String str[] = br.readLine().split(" ");

        Deque<Integer> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            queue.add(Integer.parseInt(str[i]));
        }

        int curr = 0;
        while(!queue.isEmpty()){
            int tmp = queue.
           
        }
    }   
}
