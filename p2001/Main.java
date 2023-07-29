package p2001;
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
        
		System.setIn(new FileInputStream("p2001/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		/*
		   표준입력 System.in 으로부터 스캐너를 만들어 데이터를 읽어옵니다.
		 */
		int T = Integer.parseInt(br.readLine());
     

		for(int test_case = 1; test_case <= T; test_case++)
		{
            String str[] = br.readLine().split(" ");
            int n = Integer.parseInt(str[0]);
            int m = Integer.parseInt(str[1]);
            int map[][] = new int[n][n];
            for(int i = 0; i < n; i++){
                str = br.readLine().split(" ");
                for(int k = 0; k < n ; k++){
                    map[i][k] = Integer.parseInt(str[k]);
                }
            }

            int result = 0;
            for (int i = 0; i <= n - m; i++) {
                for (int k = 0; k <= n - m; k++) {
                    int sum = 0;
                    for (int x = i; x < i + m; x++) {
                        for (int y = k; y < k + m; y++) {
                            sum += map[x][y];
                        }
                    }
                    result = Math.max(sum, result);
                }
            }
            System.out.println("#" +test_case + " " +  result);
		}
	}
}