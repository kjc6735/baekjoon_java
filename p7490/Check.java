package p7490;

import java.io.*;
import java.util.*;

public class Check {
    public static void main(String[] args) throws Exception {

        BufferedReader br1 = new BufferedReader(new FileReader(new File("p7490/check.txt")));
        BufferedReader br2 = new BufferedReader(new FileReader(new File("p7490/check2.txt")));
        String str;
        boolean isTrue = true;
        while ((str = br1.readLine()) != null) {
            String str2 = br2.readLine();
            System.out.println(str + "  " + str2 + " " + str.equals(str2));
        }

        System.out.println(isTrue);

    }
}
