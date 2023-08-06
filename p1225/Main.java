package p1225;
import java.util.*;
import java.io.BufferedReader;
import java.io.*;

class Solution
{
	public static void main(String args[]) throws Exception
	{
	
		// System.setIn(new FileInputStream("p1225/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Deque<Integer> dq = new LinkedList<>();

		for(int test_case = 1; test_case <= 10; test_case++)
		{
            br.readLine();
            String str[] = br.readLine().split(" ");    
			for (int i = 0; i < str.length; i++)
				dq.add(Integer.parseInt(str[i]));
			
			while (true) {
				for (int i = 1; i <=5; i++) {
					int first = dq.poll();
					dq.add(first- i <= 0 ? 0 : first - i);
					if (first - i <= 0) {
						break;
					}
				}
				if (dq.getLast() == 0)
					break;
			}
			System.out.print("#" + test_case);
			while (!dq.isEmpty()) {
				System.out.print(" " + dq.poll());
			}
			System.out.println();
		}
	}
}