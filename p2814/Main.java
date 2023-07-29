package p2814;
import java.util.*;
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
    static Node[] list;
    static int max;
	public static void main(String args[]) throws Exception
    {
        /*
           아래의 메소드 호출은 앞으로 표준 입력(키보드) 대신 input.txt 파일로부터 읽어오겠다는 의미의 코드입니다.
           여러분이 작성한 코드를 테스트 할 때, 편의를 위해서 input.txt에 입력을 저장한 후,
           이 코드를 프로그램의 처음 부분에 추가하면 이후 입력을 수행할 때 표준 입력 대신 파일로부터 입력을 받아올 수 있습니다.
           따라서 테스트를 수행할 때에는 아래 주석을 지우고 이 메소드를 사용하셔도 좋습니다.
           단, 채점을 위해 코드를 제출하실 때에는 반드시 이 메소드를 지우거나 주석 처리 하셔야 합니다.
         */
        System.setIn(new FileInputStream("p2814/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Scanner sc = new Scanner(System.in);
        int T = Integer.parseInt(br.readLine());

        for (int test_case = 1; test_case <= T; test_case++) {
            max = 1;
            String[] str = br.readLine().split(" ");
            int n = Integer.parseInt(str[0]);
            int m = Integer.parseInt(str[1]);
            boolean[] visited = new boolean[n + 1];
            list = new Node[n + 1];

            for (int i = 0; i < list.length; i++) {
                list[i] = new Node();
            }

            //세팅
            for (int i = 0; i < m; i++) {
                str = br.readLine().split(" ");
                int a = Integer.parseInt(str[0]);
                int b = Integer.parseInt(str[1]);
                list[a].child.add(b);
                list[b].child.add(a);
            }


            for (int i = 1; i <= n; i++) {
                visited[i] = true;
                find(i, 1, visited);
                visited[i] = false;
            }
            //찾기
            // for (int i = 1; i <= n; i++) {
            //     boolean[] visited = new boolean[n + 1];
            //     Queue<Integer> queue = new LinkedList<>();
            //     visited[i]  = true;
            //     list[i].cnt = 1;
            //     queue.add(i);

            //     while (!(queue.size() == 1)) {
            //         int index = queue.poll();
            //         for (int k = 0; k < list[index].child.size(); k++) {
            //             if (visited[list[index].child.get(k)])
            //                 continue;
            //             visited[list[index].child.get(k)] = true;
            //             list[list[index].child.get(k)].cnt = list[index].cnt + 1;
            //             queue.add(list[index].child.get(k));
            //         }
            //     }
            //     for (int k = 0; k <= n; k++) {
            //         list[k].cnt = 0;
            //     }
            // }
            System.out.println("#" + test_case + " " + max);
        }
    }
   
    static void find(int index, int cnt, boolean[] visited) {
        for (int i = 0; i < list[index].child.size(); i++) {
            int nextIdx = list[index].child.get(i);
            if (visited[nextIdx])
                continue;
            visited[nextIdx] = true;
            max = Math.max(max, cnt + 1);
            find(nextIdx, cnt + 1, visited);
            visited[nextIdx] = false;
        }
    }


    static class Node {
        int cnt = 0;
        ArrayList<Integer> child = new ArrayList<>();
    }
}