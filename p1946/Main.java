package p1946;

import java.util.Scanner;
import java.io.*;


class Solution
{
	public static void main(String args[]) throws Exception
	{
		
		System.setIn(new FileInputStream("p1946/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		/*
		   표준입력 System.in 으로부터 스캐너를 만들어 데이터를 읽어옵니다.
		 */
		int T=Integer.parseInt(br.readLine());
		/*
		   여러 개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
		*/

		for(int test_case = 1; test_case <= T; test_case++)
        {
            int n = Integer.parseInt(br.readLine());
            int idx = 0;
            for (int i = 0; i < n; i++) {
                String str[] = br.readLine().split(" ");
                int cnt = Integer.parseInt(str[1]);
                for (int k = 0; k < cnt; k++) {
                    System.out.print(str[0].charAt(0));
                    idx++;
                    if (idx % 10 == 0)
                        System.out.println();
                }
            }
            System.out.println();
            System.out.println("#" + test_case);

        }
        
	}
}