package StringTest;

public class StringObjStringEqualsTest {
    public static void main(String[] args) {
        A a = new A();
        a.str = "test";
        String str = "test";

        System.out.println(a.str == str);

        A b = new A();
        A c = new A();
        b.str = "test";
        c.str = "test";

        System.out.println(b.str == c.str);
        System.out.println(b == c);
        
        
        System.out.println(b.str.hashCode()== c.str.hashCode());
    }
}
