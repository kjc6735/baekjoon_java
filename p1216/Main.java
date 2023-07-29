package p1216;
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
	public static void main(String args[]) throws Exception
	{
		
		System.setIn(new FileInputStream("p1216/input.txt"));

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
        char map[][] = new char[100][100];

		for(int test_case = 1; br.readLine() != null; test_case++)
        {
            int result = 1;
            
            for (int i = 0; i < 100; i++) {
                String str = br.readLine();
                map[i] = str.toCharArray();
            }

            for (int i = 0; i < 100; i++) {
                for (int a = 0; a < 100; a++) {
                    //좌우? ?? 완전 좌우대칭 경우 // CAC CCACC... 
                    int b = 0;
                    for (b = 0; !(a + b >= 100 || map[i][a] != map[i][a + b]); b++) {
                    }

                    int cnt = 0;
                    cnt += b;
                    for (int c = 1; !(a - c < 0 || a + b -1 + c >= 100 || map[i][a - c] != map[i][a + b + c -1]); c++) {
                        cnt+=2;
                    }
                    result = Math.max(result, cnt);

                    cnt = 0;
                    //상하 
                    b = 0;
                    for (b = 0; !(i + b >= 100 || map[i][a] != map[i+b][a]); b++) {
                    }

                    cnt += b;
                    for (int c = 1; !(i - c < 0 || i + b + c -1>= 100 || map[i - c][a] != map[i+b+c-1][a]); c++) {
                        cnt+=2;
                    }
                    
                    result = Math.max(result, cnt);
                }
            }


            System.out.println("#" + test_case + " " + result);
		}
	}
}