package b17281;

public class Test {
    public static void main(String[] args) {

        int is = 1 << 3;
        int position = 10;
        int currScore = 0;

        position += 1;
        // 루타만큼 밀면서 점수 득점하기
        for (int i = 0; i < 3; i++) {
            if ((is & (position)) != 0)
                currScore++;
            position = position << 1;
        }
        position = position & ((1 << 4) - 1);
        System.out.println(currScore);
        System.out.println(position);
    }
}
