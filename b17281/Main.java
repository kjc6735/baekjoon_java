package b17281;

import java.io.*;
import java.util.*;

public class Main {

    static int arr[] = { 1, 2, 3, 4, 5, 6, 7, 8 };
    static int max = 0;

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("b17281/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int game = Integer.parseInt(br.readLine());

        int currGame[][] = new int[game][9];
        for (int t = 0; t < game; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < 9; i++)
                currGame[t][i] = Integer.parseInt(st.nextToken());
        }
        do {
            int position = 0;
            int totalScore = 0;

            ArrayList<Integer> list = new ArrayList<>();
            for (int i = 0; i < 9; i++) {
                if (i == 3) {
                    list.add(0);
                } else if (i >= 4)
                    list.add(arr[i - 1]);
                else
                    list.add(arr[i]);
            }
            int idx = 0;
            for (int gameCnt = 0; gameCnt < game; gameCnt++) {
                int outCnt = 0; // 아웃 갯수 끝나는 조건 3
                position = 0; // 
                while (true) {
                    int userIdx = list.get((idx++)%9 );
                  
                    position += 1; 
                    
                    int currLuta = currGame[gameCnt][userIdx];

                    if (currLuta == 0) {
                        position--;
                        outCnt++;
                        if (outCnt == 3)
                            break;
                        continue;
                    }

                    int currScore = 0;

                    int is = 1 << 3;

                    for (int i = 0; i < currLuta; i++) {
                        if ((is & (position)) != 0)
                            currScore++;
                        position = position << 1;
                    }

                    position = position & ((1 << 4) - 1);
                    totalScore += currScore;
                }
            }
            if (totalScore > max) {
                max = totalScore;
                totalScore = 0;
            }

        } while (np(arr));

        System.out.println(max);
    }

    static boolean np(int[] p) {
        int N = p.length;
        int i = N - 1;

        while (i > 0 && p[i - 1] >= p[i])
            --i;
        if (i == 0)
            return false;

        int j = N - 1;
        while (p[i - 1] >= p[j])
            --j;

        swap(p, i - 1, j);

        int k = N - 1;
        while (i < k)
            swap(p, i++, k--);

        return true;
    }

    static void swap(int p[], int a, int b) {
        int tmp = p[a];
        p[a] = p[b];
        p[b] = tmp;
    }
}
