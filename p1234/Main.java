package p1234;

import java.util.*;
import java.io.*;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		

        System.setIn(new FileInputStream("p1234/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
		for(int test_case = 1; test_case <= 10; test_case++)
        {
            String str[] = br.readLine().split(" ");
            String s = str[1];
            for (int i = 0; i < s.length() - 1; i++) {
                if (s.charAt(i) == s.charAt(i + 1)) {
                    String tmp = s.substring(0, i);
                    tmp += s.substring(i + 2);
                    s = tmp;
                    i = -1;
                }
            }
            System.out.println("#" + test_case + " " + s);
        }
        
	}
}