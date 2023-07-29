package p1940;

import java.util.Scanner;
import java.io.*;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		
		System.setIn(new FileInputStream("p1940/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());		

		for(int test_case = 1; test_case <= T; test_case++)
		{
            int comm = Integer.parseInt(br.readLine());
            String[] str;
            int distance = 0;
            int a = 0;

            while (comm-- > 0) {
                str = br.readLine().split(" ");
                int key = Integer.parseInt(str[0]);
                if (key == 0) {
                    distance += a;
                    continue;
                }
                int v = Integer.parseInt(str[1]);
                v = key == 1 ? v : v * -1;
                a = Math.max(a + v, 0);
                distance += a;
            }
			System.out.println(distance);
		}
	}
}