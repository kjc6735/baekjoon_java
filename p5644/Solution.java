package p5644;

import java.util.*;
import java.io.*;

public class Solution {
    static int dir[][] = {
            { 0, 0 }, // 제자리
            { -1, 0 }, // 위로
            { 0, 1 }, // 우
            { 1, 0 },
            { 0, -1 }
    };
    static User userA = new User(0, 0);
    static User userB = new User(9, 9);
    static Set<BC> used = new HashSet<>();
    static List<BC> bc = new ArrayList<>();

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("p5644/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int test_case = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= test_case; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int M = Integer.parseInt(st.nextToken());
            int A = Integer.parseInt(st.nextToken());
            int[] userAmove = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int[] userBmove = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

            for (int i = 0; i < A; i++) {
                int[] newBC = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
                bc.add(new BC(newBC[0], newBC[1], newBC[2], newBC[3]));
            }

            go(userA, 0);
            go(userB, 0);
            BC userABC[] = findList(userA.x, userA.y, bc);
            BC userBBC[] = findList(userB.x, userB.y, bc);
            if (userABC.length != 0)
                used.add(userABC[0]);
            if (userBBC.length != 0)
                used.add(userBBC[0]);
            charge(userA, userABC.length != 0 ? userABC[0].performance : 0);
            charge(userB, userBBC.length != 0 ? userBBC[0].performance : 0);
            for (int m = 0; m < M; m++) {

            }

        }

    }

    static void go(User user, int dirIdx) {
        user.x += dir[dirIdx][0];
        user.y += dir[dirIdx][1];
    }

    static void charge(User user, int value) {
        user.total += value;
    }

    // 범위에 있는 거 내림차순으로 정렬해서 가져옴
    static BC[] findList(int x, int y, List<BC> bc) {
        return bc.stream().filter(b -> (Math.abs(x - b.x) + Math.abs(y - b.y) <= b.cover))
                .sorted(Comparator.comparing(BC::getPerformance).reversed()).toArray(BC[]::new);
    }

    static class BC {
        int x;
        int y;
        int cover;
        int performance;

        public BC(int x, int y, int cover, int performance) {
            this.x = x;
            this.y = y;
            this.cover = cover;
            this.performance = performance;
        }

        public int getX() {
            return x;
        }

        public void setX(int x) {
            this.x = x;
        }

        public int getY() {
            return y;
        }

        public void setY(int y) {
            this.y = y;
        }

        public int getCover() {
            return cover;
        }

        public void setCover(int cover) {
            this.cover = cover;
        }

        public int getPerformance() {
            return performance;
        }

        public void setPerformance(int performance) {
            this.performance = performance;
        }

        @Override
        public boolean equals(Object b) {
            if (this == b)
                return true;
            BC bb = (BC) b;
            if (this.x == bb.x && this.y == bb.y)
                return true;
            return false;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }

    }

    static class User {
        int x = 0;
        int y = 0;
        int total = 0;

        public User(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }

        public int getTotal() {
            return total;
        }
    }

}
