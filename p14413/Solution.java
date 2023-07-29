package p14413;
import java.util.ArrayList;
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
    static char[][] map;
    static int n;
    static int m;
    static ArrayList<Node> not;
    static boolean result;
    static int dir[][] = {
            { 0, 1 },
            { 0, -1 },
            { 1, 0 },
            {-1,0}
    };
	public static void main(String args[]) throws Exception
    {

        System.setIn(new FileInputStream("p14413/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for (int test_case = 1; test_case <= T; test_case++) {
            String[] str = br.readLine().split(" ");
             n = Integer.parseInt(str[0]);
             m = Integer.parseInt(str[1]);
            not = new ArrayList<>();
            map = new char[n][m];
            for (int i = 0; i < n; i++) {
                char[] chars = br.readLine().toCharArray();
                for (int k = 0; k < m; k++) {
                    map[i][k] = chars[k];
                    if (map[i][k] == '?') {
                        not.add(new Node(i, k));
                    }
                }
            }

        }
    }
    
    static void fn(int index) {
        if (index == not.size()) {
            result = true;
        }
        
        char tmp = 
        for()

        // int cnt = 0;
        // Node current = not.get(index);
        // boolean isPossible = true;
        // Character tmp = null;
        // for (int i = 0; i < 4; i++) {
        //     int x = current.x + dir[i][0];
        //     int y = current.y + dir[i][1];
        //     if (x < 0 || y < 0 || x >= n || y >= m)
        //         continue;
        //     if (map[x][y] == '?')
        //         continue;
        //     if (tmp == null) {
        //         tmp = map[x][y];
        //     } else if (tmp != map[x][y]) {
        //         isPossible = false;
        //         break;
        //     }
        // }
        // if (isPossible) {
            
        // }
        
    }

    static class Node {
        int x;
        int y;

        Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}