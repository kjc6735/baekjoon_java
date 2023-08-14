package squareTest;

import java.util.Scanner;

public class SquareTest {
    static int N;
    static long X;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        X = sc.nextLong();
        N = sc.nextInt();

    }

    // 재귀
    // X^n = X * X^(n-1)
    // X *n-1 = X * X^(n-2)
    private static long exp1(long x, int n) {
        if (n == 1)
            return x;
        return x * exp1(x, n - 1);
    }

    private static long exp2(long x, int n) {
        if (n == 1)
            return x;
        long y = exp2(x, n / 2);
        return (n % 2 == 0) ? y * y : y * y * x;
    }
}
