package p1289;
import java.io.*;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		for(int test_case = 1; test_case <= T; test_case++)
		{
			int cnt = 0; 
            char[] str = br.readLine().toCharArray();
            char[] str2 = new char[str.length];
            for (int i = 0; i < str.length; i++) {
                str2[i] = '0';
            }

            for (int i = 0; i < str.length; i++) {
                if (str[i] == str2[i])
                    continue;
                cnt ++;
                char tmp = str[i];
                for (int k = i; k < str.length; k++) {
                    str2[k] = tmp;
                }
            }
            System.out.println("#"+test_case+" " + cnt);

		}
	}
}