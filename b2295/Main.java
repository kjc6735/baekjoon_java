package b2295;

import java.util.*;
import java.io.*;

public class Main {
    static int n;
    static int[] arr;
    static int max = 0;
  public static void main(String[] args) throws Exception{
    System.setIn(new FileInputStream("b2295/input.txt"));
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
    n = Integer.parseInt(br.readLine());
    arr = new int[n];
    for(int i = 0; i < n; i++){
        arr[i] = Integer.parseInt(br.readLine());
    }
    Arrays.sort(arr);
    ArrayList<Integer> arr2 = new ArrayList<>();
    for(int i = 0; i < n ; i++){
        for(int k = i ; k < n; k++){
            arr2.add(arr[i] + arr[k]);
        }
    }
    Collections.sort(arr2);

    for(int i = arr.length-1; i >= 0; i--){
        for(int k = i; k >= 0; k--){
           int value = arr[i] - arr[k];
          
           if(Collections.binarySearch(arr2, value)> -1){
            System.out.println(arr[i]);
            return ;
           }
        }
    }
    System.out.println(max);
}

  
}