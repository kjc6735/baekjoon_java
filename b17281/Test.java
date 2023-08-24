package b17281;

public class Test {
    public static void main(String[] args) {
        int t = 10;
        System.out.println((t++)%10);
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
