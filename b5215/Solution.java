package b5215;

import java.util.*;
import java.io.*;

public class Solution {
    static int n;
    static int maxKcal;
    static int cnt;
    static int result = 0;
    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("b5215/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Buuuuuck[] ingredients = new Buuuuuck[20];
        StringBuilder sb = new StringBuilder();

        int test_case = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= test_case; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            cnt = Integer.parseInt(st.nextToken());
            maxKcal = Integer.parseInt(st.nextToken());

            for (int i = 0; i < cnt; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                ingredients[i] = new Buuuuuck(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
            }
            sb.append("#").append(tc).append(" ").append(result).append("\n");

            result = 0;
        }
        System.out.print(sb.toString());
    }
    
    static void find(int currCnt, int score, int currKcal, boolean[] visited, Buuuuuck[] ingredients) {
        
    }

    static class Buuuuuck {
        int score;
        int kcal;

        public Buuuuuck(int score, int kcal) {
            this.score = score;
            this.kcal = kcal;
        }

        @Override
        public String toString() {
            return "[score = "+ this.score + " kcal = " + this.kcal +"]";
        }
    }
}
