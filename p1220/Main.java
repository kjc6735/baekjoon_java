package p1220;

import java.util.*;
import java.io.*;

class Solution
{
	static int S = 2;
	static int N = 1;
	static int length;
	public static void main(String args[]) throws Exception
	{

		System.setIn(new FileInputStream("p1220/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = 10;
		// int map[][] = new int[100][100];

		for (int test_case = 1; test_case <= T; test_case++) {
			length = Integer.parseInt(br.readLine());
			int map[][] = new int[length][length];

			for (int i = 0; i < length; i++) {
				String str[] = br.readLine().split(" ");
				for (int k = 0; k < length; k++) {
					map[i][k] = Integer.parseInt(str[k]);
				}
			}

			for (int i = 0; i < length; i++) {
				boolean flag = false;
				for (int a = 0; a < length; a++) {
					if (map[a][i] == 0)
						continue;
					if (map[a][i] == N) {
						break;
					}
					map[a][i] = 0;
				}
				for (int a = 99; a >= 0; a--) {
					if (map[a][i] == 0)
						continue;
					if (map[a][i] == S) {
						break;
					}
					map[a][i] = 0;
				}
			}

			int result = 0;
			for (int i = 0; i < 100; i++) {
				int a = check(map, i);
				// System.out.print(a + " ");
				result += a;
			}
			System.out.println("#" + test_case + " " + result);
		}
	}
	

	static int check(int map[][], int a) {

		//맨 위는 빨간색이라고 가정한다 ..
		int cnt = 0;
		int initial = N;
		for (int i = 0; i < 100; i++) {
			if (map[i][a] == 0 || map[i][a] == initial)
				continue;
			cnt++;
			initial = initial == 1 ? 2 : 1;
		}
		return (cnt + 1)/2;
	}
	
}