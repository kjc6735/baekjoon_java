package StringTest;

public class EqualsTest {
    public static void main(String[] args) {
        A a = new A();
        A b = new A();
        A c = a;
        System.out.println(a == b);
        System.out.println(a.equals(b));
        System.out.println("==============");
        System.out.println(c == b);
        System.out.println(c.equals(b));
        System.out.println("==============");
        System.out.println(c ==a );
        System.out.println(c.equals(a));
    }
}
