package b17471;

import java.io.*;
import java.util.*;

public class Main {
    // static ArrayList<Integer>[] arr;
    static Set<Integer>[] arr;
    static int cnt[];
    static boolean visited[];
    static int N;

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("b17471/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        cnt = new int[N + 1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        // arr = new ArrayList[N + 1];
        arr = new HashSet[N + 1];
        for (int i = 0; i < N + 1; i++)
            arr[i] = new HashSet<>();

        for (int i = 0; i < N +1; i++)
            cnt[i] = Integer.parseInt(st.nextToken());

        for (int i = 0; i < N + 1; i++) {
            st = new StringTokenizer(br.readLine());

            int nodeCnt = Integer.parseInt(st.nextToken());

            for (int k = 0; k < nodeCnt; k++) {
                arr[k + 1].add(Integer.parseInt(st.nextToken())); // 간선 정보
            }
        }
    }
    
    public static void fn(int cnt) {
        if (cnt == N) {
            int a = set(true); //visited[i] = true 인거
            int b = set(false); //visited[i] == false 인거

            return;
        }
        visited[cnt] = true;
        fn(cnt + 1);
        visited[cnt] = false;
        fn(cnt + 1);
    }
    
    public static int set(boolean a) {
        int sum = 0;
        for (int i = 1; i < N+1; i++) {
            if (visited[i] != a)
                continue;
            if(arr[])
            
        }
        return -1;
    }
}
