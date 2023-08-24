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

            Queue<Integer> queue = new LinkedList<>();

            for (int i = 0; i < 9; i++) {
                if (i == 3) {
                    queue.add(0);
                } else if (i >= 4)
                    queue.add(arr[i - 1]);
                else
                    queue.add(arr[i]);
            }

            for (Integer i : queue) {
                System.out.print(i + " ");
            }
            System.out.println();

            for (int gameCnt = 0; gameCnt < game; gameCnt++) {
                int outCnt = 0;
                position = 0;
                for (int k = 0; k < 9; k++) {
                    int userIdx = queue.poll();
                    queue.add(userIdx);
                    position += 1;
                    // 루타 가져오기
                    int currLuta = currGame[gameCnt][userIdx];
                    if (currLuta == 0)
                        outCnt++;

                    // 아웃3일 시 다음 게임
                    if (outCnt == 3) {
                        break;
                    }

                    // 루타가 나옴 이러면 안타 루타 홈런 확인
                    // 비트마스킹..?
                    // 나갈 수 있는 사람 수
                    int currScore = 0;

                    // 마지막 (3루타 기준으로 )
                    int is = 1 << 3;

                    // 루타만큼 밀면서 점수 득점하기
                    for (int i = 0; i < currLuta; i++) {
                        if ((is & (position)) != 0)
                            currScore++;
                        position = position << 1;
                    }

                    // 민 다음 해당 position 다시 16이내로 만들기
                    // System.out.println(
                    // "{position} " + position + " " + ((1 << 4) - 1) + " result "
                    // + (position & ((1 << 4) - 1)));
                    position = position & ((1 << 4) - 1);
                    totalScore += currScore;
                }
            }
            if (totalScore > max) {
                System.out.println(totalScore + " " + max);
                max = totalScore;
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
