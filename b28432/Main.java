package b28432;

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Set<String> set = new HashSet<>();
        String[] arr = new String[100];
        int idx = 0;
        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            if (str.equals("?")) {
                idx = i;
            } else
                set.add(str);
            arr[i] = str;
        }

        int m = Integer.parseInt(br.readLine());

        for (int i = 0; i < m; i++) {
            set.remove(br.readLine());
        }
        Iterator iter = set.iterator();

        if (idx == 0) {
            while (iter.hasNext() && arr[idx + 1].charAt(0) != arr[idx].charAt(arr[idx].length() - 1)) {

            }
        }else if(idx )

    }
}
