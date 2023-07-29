package p1221;
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
    static Map<Integer, String> map1 = new HashMap<>();
    static Map<String, Integer> map2 = new HashMap<>();
	public static void main(String args[]) throws Exception
	{
		
        map2.put("ZRO", 0);
        map2.put("ONE", 1);
        map2.put("TWO", 2);
        map2.put("THR", 3);
        map2.put("FOR", 4);
        map2.put("FIV", 5);
        map2.put("SIX", 6);
        map2.put("SVN", 7);
        map2.put("EGT", 8);
        map2.put("NIN", 9);

        map1.put(0, "ZRO");
        map1.put(1, "ONE");
        map1.put(2, "TWO");
        map1.put(3, "THR");
        map1.put(4, "FOR");
        map1.put(5, "FIV");
        map1.put(6, "SIX");
        map1.put(7, "SVN");
        map1.put(8, "EGT");
        map1.put(9, "NIN");


        System.setIn(new FileInputStream("p1221/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T =  Integer.parseInt(br.readLine());
		
		for(int test_case = 1; test_case <= T; test_case++)
		{
            String str[] = br.readLine().split(" ");
            int n = Integer.parseInt(str[1]);

            int arr[] = new int[n];
            String ss[] = br.readLine().split(" ");
            for (int i = 0; i < n; i++) {
                arr[i] = map2.get(ss[i]);
            }
            Arrays.sort(arr);
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < n; i++) {
                sb.append(map1.get(arr[i])).append(" ");
            }
            System.out.println("#" + test_case);
            System.out.println(sb);
		}
	}
}