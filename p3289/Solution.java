package p3289;

import java.util.*;
import java.io.*;

public class Solution {
    static int parents[];
    static Set<Integer> set = new HashSet<>();
    static int N, M;

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("p3289/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int test_case = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= test_case; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            sb.append("#").append(tc).append(" ");
            make();

            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                int c = Integer.parseInt(st.nextToken());

                if (a == 0) {
                    union(b, c);
                    continue;
                }

                sb.append(find(b) == find(c) ? 1 : 0);
                set.clear();
            }
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }

    static int find(int a) {

        if (a == parents[a])
            return a;
        return parents[a] = find(parents[a]);
    }

    static boolean union(int a, int b) { // a가 속한 집합과 b가 속한 집합을 합칠 수 있다면 합치고 true반환, 아니면 false 반환
        int aRoot = find(a);
        int bRoot = find(b);
        if (aRoot == bRoot)
            return false; // 대표자가 같을 때는 합치지 못함.

        // union처리( bRoot 를 aRoot 아래로 붙이기 => 임의로)

        parents[bRoot] = aRoot;
        return true;
    }

    static void make() {
        parents = new int[N + 1];
        for (int i = 0; i <= N; i++) {
            parents[i] = i; // 모든 요소는 자기만 원소로 갖는 단위 서로소 집합이 되게 한다. ( 자신이 곧 대표자)

        }
    }

}
