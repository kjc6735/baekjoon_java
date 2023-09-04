// package b2295;

// import java.util.*;
// import java.io.*;

// public class Main {
//     static int n;
//     static int[] arr;
//     static Set<Integer> set = new HashSet<>();
//     static int max = 0;
//   public static void main(String[] args) throws Exception{
//     System.setIn(new FileInputStream("b2295/input.txt"));
//     BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
//     n = Integer.parseInt(br.readLine());
//     arr = new int[n];
//     for(int i = 0; i < n; i++){
//         arr[i] = Integer.parseInt(br.readLine());
//         set.add(arr[i]);
//     }

//     PriorityQueue<Integer> pq  = new PriorityQueue<>();

    
//     int arrMax = arr[arr.length-1];
//     for(int i = 0; i < arr.length; i++){
//        int sum = arr[i]; 
//         for(int k = 0; k < arr.length; k++){
//             if(sum + arr[k] > arrMax) {
//                 break; 
//             }
//             sum += arr[k];
//             for(int c = 0; c < arr.length; c++){
//                 if(sum + arr[c] > arrMax) {
//                     break;
//                 }
//                 sum += arr[c];
//                 if(set.contains(sum) && max < sum){
//                     max = sum;
//                 }
//                 sum -= arr[c];
//             }
//             sum -= arr[k];
//         }
//     }
//     System.out.println(max);
// }

  
// }