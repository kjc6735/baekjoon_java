package p1230;//////////////////////////////
import java.util.*;
import java.io.*;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		
		System.setIn(new FileInputStream("p1230/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		
		int T = 10;
		
        
		for(int test_case = 1; test_case <= T; test_case++)
		{
            LinkedList<Integer> list = new LinkedList<>();
            int n = Integer.parseInt(br.readLine());
            String str[] =  br.readLine().split(" ");
            for (int i = 0; i < str.length; i++) {
                list.add(Integer.parseInt(str[i]));
            }
            int comm_len = Integer.parseInt(br.readLine());
            String commands[] = br.readLine().split(" ");
            for (int i = 0; i < comm_len; i++) {
                if (commands[i].equals("I")) {
                    int x = Integer.parseInt(commands[i + 1]) ;
                    int y = Integer.parseInt(commands[i + 2]);

                    for (int a = 0; a < y; a++) {
                        list.add(x + a, Integer.parseInt(commands[i + 3 + a]));
                    }
                    i = (i + y + 2);

                } else if (commands[i].equals("D")) {
                        int x = Integer.parseInt(commands[i + 1])+1;
                        int y = Integer.parseInt(commands[i + 2]);
                        for (int a = 0; a < y; a++) {
                            list.remove(x);
                        }
                        i+=2;

                } else {
                    int y = Integer.parseInt(commands[i + 1]);
                    for (int a = 0; a < y; a++) {
                        list.add(Integer.parseInt(commands[i + 2 + a]));
                    }
                    i += (y + 1);
                }
            }
            StringBuilder sb = new StringBuilder();
            sb.append("#" + test_case);
            for (int i = 0; i < 10; i++) {
                sb.append(" " + list.get(i));
            }
            System.out.println(sb);
		}
	}
}

