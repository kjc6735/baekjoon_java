package StringTest;

public class StringTest {
    public static void main(String[] args) {
        String str1 = "string";
        String str2 = "string";
        String str3 = new String("string");
        String str4 = new StringBuilder("string").toString();
        System.out.println(str1 == str2);
        System.out.println(str2 == str3);
        System.out.println(str3 == str4);
        System.out.println(str2 == str4);


        // System.out.println(str1.equals(str2));
        // System.out.println(str2.equals(str3));
        // System.out.println(str3.equals(str4));
        // System.out.println(str2.equals(str4));

    }
}