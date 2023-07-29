package p1217;

import java.util.*;
import java.io.*;

class Solution
{
	public static void main(String args[]) throws Exception
    {

        System.setIn(new FileInputStream("p1217/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int test_case = 1; test_case <= 10; test_case++) {
            String r = br.readLine();
            String str[] = br.readLine().split(" ");
            int a = Integer.parseInt(str[0]);
            int b = Integer.parseInt(str[1]);

            System.out.println("#" + test_case + " " + fn(1,a,b));

        }
    }

    static int fn(int a,int b,  int cnt) {
        if (cnt == 0)
            return a;
        return fn(a * b , b, cnt-1);
    }
}
