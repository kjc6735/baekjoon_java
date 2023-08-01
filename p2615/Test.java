package p2615;

public class Test {
    public static void main(String[] args) {

        int a = 1;
        int b = 2;
        int tmp = 10;
        boolean check = (tmp = tmp + 1) >= 11 && tmp == 10;
        System.out.println(check);
    }
}
