package b1043;

import java.util.*;
import java.io.*;

class Main {
    static int arr[][] = new int[50][51];
    static int n;
    static int m;
    static Set<Integer> set = new HashSet<>();
    static List<Integer>[] party;
    static ArrayList<Integer> list = new ArrayList<>();
    static int result = 0;

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("b1043/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine(), " ");

        party = new ArrayList[m];
        for (int i = 0; i < m; i++)
            party[i] = new ArrayList<>();
        int partyUserCnt = Integer.parseInt(st.nextToken());
        for (int i = 0; i < partyUserCnt; i++) {
            set.add(Integer.parseInt(st.nextToken()));
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int cnt = Integer.parseInt(st.nextToken());
            boolean check = true;
            for (int k = 0; k < cnt; k++) {
                int num = Integer.parseInt(st.nextToken());
                if (set.contains(num)) {
                    check = false;
                    break;
                }
                party[i].add(num);
            }
            if (check)
                list.add(i);
        }

        find(0, 0, new boolean[list.size()]);
        System.out.println(result);
    }

    static void find(int cnt, int cnt2, boolean visited[]) {
        if (cnt2 == list.size()) {
            if (result < cnt) {
                result = cnt;
            }
            return;
        }

        for (int i = 0; i < list.size(); i++) {
            if (visited[i])
                continue;
            visited[i] = true;
            boolean contains = contains(i);
            if (!contains)
                setAdd(i);
            find(contains ? cnt : cnt + 1, cnt2 + 1, visited);
            if (!contains)
                remove(i);
            visited[i] = false;

        }

    }

    static void remove(int index) {
        for (int i = 0; i < party[index].size(); i++) {
            set.remove(party[index].get(i));
        }
    }

    static void setAdd(int index) {
        for (int i = 0; i < party[index].size(); i++) {
            set.add(party[index].get(i));
        }
    }

    static boolean contains(int index) {
        for (int i = 0; i < party[index].size(); i++) {
            if (set.contains(party[index].get(i))) {
                return true;
            }
        }
        return false;
    }

}