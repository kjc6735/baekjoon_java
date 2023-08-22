import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");
        int n = Integer.parseInt(str[0]);
        int m = Integer.parseInt(str[1]);
        HashSet<Integer> set = new HashSet<>();
        Queue<Integer> queue = new LinkedList<>();
        int time = 0;
        queue.add(n);
        set.add(n);
        boolean isFind = false;
        while (!queue.isEmpty()) {
            time++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int d = queue.poll();
                if (d == m) {
                    isFind = true;
                    time--;
                    break;
                }
                if (d + 1 == m || d - 1 == m || d * 2 == m) {
                    isFind = true;
                    break;
                }
                if (!set.contains(d + 1) && d + 1 >= 0 && d + 1 <= 100000) {
                    queue.add(d + 1);
                    set.add(d + 1);
                }
                if (!set.contains(d - 1) && d - 1 >= 0 && d - 1 <= 100000) {
                    queue.add(d - 1);
                    set.add(d - 1);
                }
                if (!set.contains(d * 2) && d * 2 >= 0 && d * 2 <= 100000) {
                    queue.add(d * 2);
                    set.add(d * 2);
                }
            }
            if (isFind)
                break;
        }
        System.out.println(time);
    }
}