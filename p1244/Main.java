package p1244;
import java.util.HashMap;
import java.util.HashSet;
/////////////////////////////////////////////////////////////////////////////////////////////
// 기본 제공코드는 임의 수정해도 관계 없습니다. 단, 입출력 포맷 주의
// 아래 표준 입출력 예제 필요시 참고하세요.
// 표준 입력 예제
// int a;
// double b;
// char g;
// String var;
// long AB;
// a = sc.nextInt();                           // int 변수 1개 입력받는 예제
// b = sc.nextDouble();                        // double 변수 1개 입력받는 예제
// g = sc.nextByte();                          // char 변수 1개 입력받는 예제
// var = sc.next();                            // 문자열 1개 입력받는 예제
// AB = sc.nextLong();                         // long 변수 1개 입력받는 예제
/////////////////////////////////////////////////////////////////////////////////////////////
// 표준 출력 예제
// int a = 0;                            
// double b = 1.0;               
// char g = 'b';
// String var = "ABCDEFG";
// long AB = 12345678901234567L;
//System.out.println(a);                       // int 변수 1개 출력하는 예제
//System.out.println(b); 		       						 // double 변수 1개 출력하는 예제
//System.out.println(g);		       						 // char 변수 1개 출력하는 예제
//System.out.println(var);		       				   // 문자열 1개 출력하는 예제
//System.out.println(AB);		       				     // long 변수 1개 출력하는 예제
/////////////////////////////////////////////////////////////////////////////////////////////
import java.util.*;
import java.io.*;

/*
   사용하는 클래스명이 Solution 이어야 하므로, 가급적 Solution.java 를 사용할 것을 권장합니다.
   이러한 상황에서도 동일하게 java Solution 명령으로 프로그램을 수행해볼 수 있습니다.
 */
class Solution
{
    static int result;
    static int test_case;
	public static void main(String args[]) throws Exception
    {

        System.setIn(new FileInputStream("p1244/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for ( test_case = 1; test_case <= T; test_case++) {
            result = 0;
            String[] str = br.readLine().split(" ");
            int cnt = Integer.parseInt(str[1]);
            ArrayList<Integer> in = new ArrayList<>();
            in.add(Integer.parseInt(str[0]));
            fn(cnt, in);
            System.out.println(result);
        }
    }
    
    public static void fn(int cnt, ArrayList<Integer> list) {
        if (cnt == 0) {
            for (int i = 0; i < list.size(); i++)
                result = Math.max(list.get(i), result);
            return;
        }
       
        Set<String> localSet = new HashSet<>();
        ArrayList<Integer> arr = new ArrayList<>();
        for (int a = 0; a < list.size(); a++) {
            char[] c = list.get(a).toString().toCharArray();
            for (int i = 0; i < c.length; i++) {
                for (int k = 0; k < c.length; k++) {
                    if (i == k)
                        continue;
    
                    char tmp = c[i];
                    c[i] = c[k];
                    c[k] = tmp;


                    String str = String.valueOf(c);
                    if (!localSet.contains(str)) {
                        localSet.add(str);
                        arr.add(Integer.parseInt(str));
                    }

                    c[k] = c[i];
                    c[i] = tmp;
                }
            }
        }
        fn(cnt - 1, arr);
    }
}