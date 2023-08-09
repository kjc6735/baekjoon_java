package b11286;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws Exception {
        // System.setIn(new FileInputStream("b11286/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2)->{
            int first = Math.abs(o1);
            int second = Math.abs(o2);

            if (first == second) {
                return o1 > o2 ? 1 : -1;
            } else {
                return first - second;
            }
        });

        for (int i = 0; i < n; i++) {
            int tmp = Integer.parseInt(br.readLine());
            if (tmp == 0) {
                System.out.println(!pq.isEmpty() ? pq.poll() : 0);
                continue;
            }
            pq.add(tmp);
            
        }
        
    }
}
