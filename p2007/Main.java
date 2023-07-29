package p2007;
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
import java.util.Scanner;
import java.io.*;

/*
   사용하는 클래스명이 Solution 이어야 하므로, 가급적 Solution.java 를 사용할 것을 권장합니다.
   이러한 상황에서도 동일하게 java Solution 명령으로 프로그램을 수행해볼 수 있습니다.
 */
class Solution
{
	public static void main(String args[]) throws Exception
    {

        System.setIn(new FileInputStream("p2007/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        /*
           여러 개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
        */

        for (int test_case = 1; test_case <= T; test_case++) {
            String str = br.readLine();

            int k = 0;
            for (k = 1; k < 30; k++) {
                if (str.charAt(0) != str.charAt(k))
                    continue;
                boolean isTrue = check(str, k);
                if (isTrue)
                    break;
            }

            System.out.println("#" + test_case + " " + k);
        }
    }
    
    static boolean check(String str,int start) {
        int i = 0;
        for (i = 0; i < start; i++) {
            if (str.charAt(i) != str.charAt(start + i))
                return false;
        }
        if (str.length() == i) {
            return true;
        }

        if (str.charAt(i) == str.charAt(0)) {
            return true;
        }
     
        return false;
    }
}