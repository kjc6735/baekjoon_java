package b1389;

import java.util.*;
import java.io.*;

public class Main {

    static List<Integer>[] arr = new ArrayList[101];
    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream("b1389/input.txt"));
        int minIdx = -1;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");
        int n = Integer.parseInt(str[0]);
        int m = Integer.parseInt(str[1]);
        int min = Integer.MAX_VALUE;
        for (int i = 0; i <= n; i++)
            arr[i] = new ArrayList<>();
    
        for (int i = 0; i < m; i++) {
            str = br.readLine().split(" ");
            int a = Integer.parseInt(str[0]);
            int b = Integer.parseInt(str[1]);
            arr[a].add(b);
            arr[b].add(a);
        }
        Queue<List<Integer>> queue = new LinkedList<>();

        int visited[] = new int[101];
        for (int i = 1; i <= n; i++) {
            Arrays.fill(visited, -1);
            int sum = 0;
            queue.add(arr[i]);
            visited[i] = 0;
            int depth = 1;

            while (!queue.isEmpty()) {
                List<List<Integer>> list = new LinkedList<>();
                while (!queue.isEmpty()) 
                    list.add(queue.poll());
                
                for (List<Integer> userList : list) {
                    for (int user : userList) {
                        if (visited[user] != -1)
                            continue;
                        // System.out.print(user + " ");
                        sum += depth;
                        visited[user] = depth;
                        queue.add(arr[user]);
                    }
                }
                depth++;
            }
            // System.out.println( " ===> "  + i + " "  + sum);
            if (sum < min) {
                min = sum;
                minIdx = i;
            }
        }

        System.out.println(minIdx);
    }
}
