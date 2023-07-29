package p1859;

import java.io.*;
public class Main {
    
    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream("p1859/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            int n = Integer.parseInt(br.readLine());
            int arr[] = new int[n];
            String[] str = br.readLine().split(" ");

            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(str[i]);
            }
            Long total = 0L;
            int max = arr[arr.length - 1];
            for (int i = arr.length-2; i>=0; i--) {
                if (max > arr[i]) {
                    total += max - arr[i];
                } else if (max < arr[i]) {
                    max = arr[i];
                }
            }
            System.out.println("#" + t + " " + total);
        }
    }
}
