// package b1676;

import java.util.*;
import java.io.*;
import java.math.BigInteger;

public class Main {
    public static void main(String[] args) throws Exception{
        // System.setIn(new FileInputStream("b1676/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        BigInteger n = new BigInteger(br.readLine());

        
        BigInteger d = new BigInteger("1");
        BigInteger zero = new BigInteger("0");
        if(n.compareTo(zero) == 0) {
            System.out.println(0);
            return ;
        }
        for (BigInteger i = new BigInteger("1"); i.compareTo(n) != 1 ; i = i.add(new BigInteger("1"))) {
            d = d.multiply(i);
        }
        String str = d.toString();
        int i;
        for (i = str.length() - 1; i >= 0 && str.charAt(i) == '0' ; i--) {}
        System.out.println(str.length()-1 - i);

    }
}
