package p1928;

public class Test {
    public static void main(String[] args) {

        StringBuilder sb = new StringBuilder();
        // char[] str = { 'A', 'B', 'C' };
        int i = 1;
        
        char[] str = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/".toCharArray();
        for (int k = 0; k < str.length; k++) {

            i = i << 6;
            i = i ^ (str[k]);
        }

        for (int k = 2; k >= 0; k--) {
            int curr = i >> (8 * k);
            int result = 0;
            for (int bit = 0; bit < 8; bit++) {
                if ((curr & (1 << bit)) != 0) {
                    result += (1 << bit);
                }

            }
            System.out.println( Character.toChars(result) );
        }
        
        
        // System.out.println(Integer.toBinaryString(i).length());

        // System.out.println(Integer.toBinaryString( ((i | (0 << 24)))  ));

        // for (int k = 0; k < 3; k++) {
            
        //     System.out.println( (i ^ (0 << (8*(3-k) ) )) >> (8*(3-k-1)));
        // }
    }
}
