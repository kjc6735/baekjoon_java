package b20529;

import java.util.*;
import java.io.*;

public class Main {
    static List<MBTI> list = new ArrayList<>();

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("b20529/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int test_case = Integer.parseInt(br.readLine());
        Map<String, Integer> map = new HashMap<>();
        PriorityQueue<MBTI> pq = new PriorityQueue<>();
        StringBuilder sb = new StringBuilder();
        for (int tc = 0; tc < test_case; tc++) {
            int n = Integer.parseInt(br.readLine());
            String[] str = br.readLine().split(" ");
            for (int i = 0; i < n; i++) {
                map.put(str[i], map.getOrDefault(str[i], 0) + 1);
            }
            for (Map.Entry<String, Integer> e : map.entrySet()) {
                pq.add(new MBTI(e.getKey(), e.getValue()));
                list.add(new MBTI(e.getKey(), e.getValue()));
            }
            int min = Integer.MAX_VALUE;
            MBTI m = pq.peek();
            // while (!pq.isEmpty()) {
            // System.out.print(pq.poll().cnt + " ");
            // }
            if (m.cnt >= 3) {
                min = 0;
            } else {
                if (m.cnt == 2) {

                    while (!pq.isEmpty() && pq.peek().cnt == 2) {
                        MBTI mbti = pq.poll();
                        int size = list.size();
                        for (int i = 0; i < size; i++) {
                            if (mbti.mbti.equals(list.get(i).mbti))
                                continue;
                            int r = calc(mbti.mbti, list.get(i).mbti) * 2;
                            if (r < min)
                                min = r;
                        }
                    }
                }
                int size = list.size();
                for (int i = 0; i < size - 2; i++) {
                    for (int k = i + 1; k < size - 1; k++) {
                        for (int a = k + 1; a < size; a++) {
                            int result = calc(list.get(i).mbti, list.get(k).mbti)
                                    + calc(list.get(k).mbti, list.get(a).mbti)
                                    + calc(list.get(a).mbti, list.get(i).mbti);
                            if (result < min)
                                min = result;
                        }
                    }
                }
            }
            list.clear();
            pq.clear();
            map.clear();
            System.out.println(min);
            min = Integer.MAX_VALUE;
        }

    }

    static int calc(String a, String b) {

        int cnt = 0;
        if (a.charAt(0) != b.charAt(0))
            cnt++;
        if (a.charAt(1) != b.charAt(1))
            cnt++;
        if (a.charAt(2) != b.charAt(2))
            cnt++;
        if (a.charAt(3) != b.charAt(3))
            cnt++;

        return cnt;

    }

    static class MBTI implements Comparable<MBTI> {
        String mbti;
        int cnt = 0;

        public MBTI(String mbti, int cnt) {
            this.mbti = mbti;
            this.cnt = cnt;
        }

        @Override
        public int compareTo(MBTI o) {
            return o.cnt - this.cnt;
        }
    }
}
