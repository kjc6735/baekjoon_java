package b1967;

import java.util.*;
import java.io.*;

public class Main2 {
    static int N;

    static ArrayList<Node> arr[];
    static int totalMax = 0;

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("b1967/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new ArrayList[N+1];
        for(int i = 0; i < N+ 1; i++){
          arr[i] = new ArrayList();
        } 
        for (int i = 0; i < N-1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            arr[a].add(new Node(b,c));
        }

        arr[0].add(new Node(1, 0));
        find(arr[0].get(0));
        System.out.println(totalMax);

    }
    static int find(Node node){
        if(arr[node.idx].size() == 0 ) {
          return node.value;
        }

        int sum = 0;
        int max = 0;
        ArrayList<Node> tmpArr = arr[node.idx];

        for(int i = 0; i < tmpArr.size(); i++){
          int tmp = find(tmpArr.get(i));
           sum += tmp;
           if(max < tmp) {
            max = tmp;
           }
        }

        if(totalMax < sum) totalMax = sum;

        return max + node.value;
      }
    static class Node{
      int value = 0; 
      int idx = 0;
      Node(int idx, int v){
        this.idx = idx;
        this.value = v;
      }
     }
}
