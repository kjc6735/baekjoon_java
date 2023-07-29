package p1240;
import java.util.*;
import java.io.*;

class Solution
{
    static Map<String, Integer> map = new HashMap<>();


	public static void main(String args[]) throws Exception
    {
        map.put("0001101", 0);
        map.put("0011001",1);
        map.put("0010011",2);
        map.put("0111101",3);
        map.put("0100011",4);
        map.put("0110001",5);
        map.put("0101111",6);
        map.put("0111011",7);
        map.put("0110111",8);
        map.put("0001011", 9);
        System.setIn(new FileInputStream("p1240/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int test_case = 1; test_case <= T; test_case++) {
            String[] str = br.readLine().split(" ");
            int n = Integer.parseInt(str[0]);
            int m = Integer.parseInt(str[1]);
            char arr[] = new char[m];
            boolean flag = false;
            for (int i = 0; i < n; i++) {
                String s = br.readLine();
                if (flag)
                    continue;

                for (int k = 0; k < m; k++) {
                    arr[k] = s.charAt(k);
                    if (arr[k] == '1')
                        flag = true;
                }
            }
            int first = findFirst(arr);
            int last = findLast(arr);
            String s = get(arr, first, last);
            ArrayList<String> r = new ArrayList<>();
            for (int i = first - 1; (i >= 0) && s.length() != 56; i--) {
                s = "0" + s;
            }
            for (int i = last + 1; s.length() != 56; i++) {
                s += "0";
            }
            
            int result[] = calc(s);
            int checked[] = check(result);
            System.out.print("#" + test_case + " ");
            System.out.println(checked[0] == -1 ? 0 : checked[1]);      
        }
        
    }

    static int[] calc(String s) {
        int result[] = new int[8];

        for (int i = 0; i < 55; i += 7) {
            String str = "";
            for (int a = 0; a < 7; a++) {
                str += s.charAt(i + a);
            }
            if (map.get(str) != null) {
                result[(i / 7)] = map.get(str);
            } else {
                result[0] = -1;
                return result;
            }
        }
        return result;
    }

    static int[] check(int arr[]) {
        int r[] = new int[2];
        int result = (arr[0] + arr[2] + arr[4] + arr[6]) * 3 + arr[1] + arr[3] + arr[5] + arr[7];
        
        if(result % 10 != 0) return r;

        r[0] = result;
        r[1] = arr[0] + arr[2] + arr[4] + arr[6] + arr[1] + arr[3] + arr[5] + arr[7];
        
        return r;
    }

    static String get(char[] c, int first, int last) {
        String result = new String();
        for (int i = first; i <= last; i++) {
            result += String.valueOf(c[i]);
        }
        return result;
    }
    
    static int findFirst(char arr[]) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == '1')
                return i;
        }
        return 0;
    }

    static int findLast(char arr[]) {
        for (int i = arr.length - 1; i >= 0; i--) {
            if (arr[i] == '1')
                return i;
        }
        return 0;
    }
}