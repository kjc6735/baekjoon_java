package b2149;

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("b2149/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        char[] key = br.readLine().toCharArray();
        char[] sortedKey = new String(key).toCharArray();
        Arrays.sort(sortedKey);
        boolean visited[] = new boolean[key.length];
        String hashStr = br.readLine();
        char[][] result = new char[hashStr.length() / key.length][key.length];
        for(int i = 0; i < key.length; i++) {
            for(int k = 0 ; k < key.length; k++){
                if(visited[k] ||  key[i] != sortedKey[k]) continue;
                visited[k] = true;
                for(int c = 0; c < (hashStr.length() / key.length); c++){
             
                    result[c][i] = hashStr.charAt(k*((hashStr.length() / key.length)) + c);
                }
                break;
            }
        }
        for(int i = 0; i < result.length; i++){
            for(int k = 0; k < key.length; k++){
                System.out.print(result[i][k]);
            }
        }
 


    }

}
