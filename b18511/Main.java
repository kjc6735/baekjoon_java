package b18511;

import java.util.*;
import java.io.*;

public class Main {
    static int arr[];
    static int maxValue;
    static int result = 0;
    static int totalLen ;

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("b18511/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] str = br.readLine().split(" ");

        maxValue = Integer.parseInt(str[0]);
        int k = Integer.parseInt(str[1]);
        str = br.readLine().split(" ");
        arr = new int[k];
        
        for (int i = 0; i < k; i++) {
            arr[i] = Integer.parseInt(str[i]);
        }

        String maxValuetoString = String.valueOf(maxValue);

        //저ㅇ렬
        Arrays.sort(arr);
        // 제일 작은 수 보다 더 작은 수라면 ..길이 하나 줄이자
        totalLen = arr[0] < (maxValuetoString.charAt(0) - '0') ? maxValuetoString.length()
                : maxValuetoString.length() - 1;
        fn(0, "");
        System.out.println(result);

    }
    
    static void fn(int cnt, String str) {
        if (cnt == totalLen) {
            int n = Integer.parseInt(str);
            if (maxValue < n)
                return;
            if (result < n) {
                result = n;
            }
            return;
        }
        
        for (int i = 0; i < arr.length; i++) {
            fn(cnt + 1, str + arr[i]);
        }
    }
        
    
}
