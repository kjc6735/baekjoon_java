package b1764;

import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("b1764/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");
        int n = Integer.parseInt(str[0]);
        int m = Integer.parseInt(str[1]);

        Set<String> set = new HashSet<>();
        List<String> ans = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            set.add(br.readLine());
        }
        String tmp;
        for (int i = 0; i < m; i++) {
            if (!set.contains(tmp = br.readLine()))
                continue;
            ans.add(tmp);
        }
        Collections.sort(ans);
        StringBuilder sb = new StringBuilder();
        sb.append(ans.size() + "\n");
        for(String a : ans) sb.append(a + "\n");
        System.out.print(sb.toString());
    }
}
