package p1210;
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
		
		System.setIn(new FileInputStream("p1210/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		/*
		   표준입력 System.in 으로부터 스캐너를 만들어 데이터를 읽어옵니다.
		 */
        int t;
        String s = "";
		/*
		   여러 개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
		*/
        int map[][] = new int[100][100];
        while ((s = br.readLine()) != null) {
            t = Integer.parseInt(s);
            String str[];
            for (int i = 0; i < 100; i++) {
                str = br.readLine().split(" ");
                for (int k = 0; k < 100; k++) {
                    map[i][k] = Integer.parseInt(str[k]);
                }
            }
            int start  = 0;
            for (int i = 0; i < 100; i++) {
                if (map[99][i] != 2)
                    continue;
                start = i;
                break;
            }

            for (int i = 98; i >= 0; i--) {
                boolean tmp = false;
                while (check(i, start, 1) && map[i][start + 1] == 1) {
                    start += 1;
                    tmp = true;
                }
                if (tmp == true)
                    continue;
                
                while (check(i, start, -1) && map[i][start - 1] == 1) {
                    start -= 1;
                }
            }
            System.out.println("#" + t + " " + start);
          
        }
	}


    static boolean check(int x, int y, int dir) {
        int calc = y + dir;
        if( calc>= 100 ||  calc < 0 || calc == 0){
            return false;
        }
        return true;
    }


}