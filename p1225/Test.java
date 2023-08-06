package p1225;


import java.util.*;
import java.io.*;

public class Test {
    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream("p1225/input.txt"));
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Queue<Integer> queue;
    
        for (int tc = 1; tc <= 10; tc++) {
            br.readLine();
            queue = new LinkedList<>();

            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for (int i = 0; i < 8; i++)
                queue.add(Integer.parseInt(st.nextToken()));
            
            int cnt = 1;
            while (queue.peek() - cnt%6 > 0) {
                queue.add(queue.poll() - cnt%6);
                cnt = cnt%6 != 5 ? cnt + 1 : cnt +2;
            }
            queue.poll(); queue.add(0);
            System.out.print("#" + tc + " ");
            while (!queue.isEmpty())
                System.out.print(queue.poll() + " ");
            System.out.println();
        }

    

    }
}
