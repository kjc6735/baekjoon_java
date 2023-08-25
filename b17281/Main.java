import java.io.*;
import java.util.*;

public class Main {

    static int arr[] = { 1, 2, 3, 0, 4, 5, 6, 7, 8 };
    static int max = 0;
    static int checkBit = 1 << 4 | 1 << 5 | 1 << 6 | 1 << 7;

    public static void main(String[] args) throws Exception {
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

            int idx = 0;
            for (int gameCnt = 0; gameCnt < game; gameCnt++) {
                int outCnt = 0; // 아웃 갯수 끝나는 조건 3
                position = 0; //
                while (true) {
                    int userIdx = arr[(idx++) % 9];

                    position |= 1;

                    int currLuta = currGame[gameCnt][userIdx];

                    if (currLuta == 0) {
                        outCnt++;
                        if (outCnt == 3)
                            break;
                        continue;
                    }

                    int currScore = 0;

                    currScore += (Integer.bitCount((position << currLuta) & checkBit));

                    position = (position << currLuta) & ((1 << 4) - 1);
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
        while (i > 0 && ((i == 4 && p[i - 2] >= p[i] || i == 3 && true) || (i != 4 && i != 3 && p[i - 1] >= p[i])))
            --i;

        if (i == 0)
            return false;

        int end = i != 4 ? i - 1 : i - 2;

        int j = N - 1;

        while (p[end] >= p[j])
            j = j == 4 ? j - 2 : j - 1;

        swap(p, end, j);

        int k = N - 1;
        while (true) {
            if (i == 3)
                i++;
            if (k == 3)
                k--;

            if (i < k)
                swap(p, i++, k--);
            else
                break;
        }
        return true;
    }

    static void swap(int p[], int a, int b) {
        int tmp = p[a];
        p[a] = p[b];
        p[b] = tmp;
    }
}
