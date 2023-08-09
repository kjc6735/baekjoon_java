package b16926;

public class Test {
    public static void main(String[] args) {
        int tmp = getSize(1, 1, 1);
        System.out.println(tmp);
    }
    

    static int getSize(int idx,int n, int m) {
        return (n - idx * 2) * (m - idx * 2) - ((n - (idx + 1) * 2) * (m - (idx + 1) * 2));
    }
}
