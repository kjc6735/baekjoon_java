package p1238;

import java.io.*;
import java.util.*;

public class Solution {
    static ArrayList<Integer> arr[];

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("p1238/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int test_case = 10;
        for (int tc = 1; tc <= test_case; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int start = Integer.parseInt(st.nextToken());
            arr = new ArrayList[101];
            for (int i = 0; i < 101; i++)
                arr[i] = new ArrayList<>();
            boolean visited[] = new boolean[101];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < (N / 2); i++) {
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                arr[a].add(b);
            }

            Queue<Integer> queue = new LinkedList<>();

            queue.add(start);
            visited[start] = true;
            int result = 0;
            ArrayList<Integer> tmp = new ArrayList<>();
            while (!queue.isEmpty()) {
                int max = 0;
                int size = queue.size();
                tmp = new ArrayList<>();
                for (int k = 0; k < size; k++) {
                    int poll = queue.poll();

                    for (int data : arr[poll]) {
                        if (visited[data])
                            continue;
                        visited[data] = true;
                        queue.add(data);
                        tmp.add(data);
                    }
                }
                if (tmp.size() == 0)
                    break;
                for (int i = 0; i < tmp.size(); i++) {
                    if (max < tmp.get(i))
                        max = tmp.get(i);
                }
                result = max;
            }

            System.out.println("#" + tc + " " + result);
        }
    }

}
