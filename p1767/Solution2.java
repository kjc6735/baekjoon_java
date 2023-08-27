package p1767;

import java.io.*;
import java.util.*;

public class Solution2 {
    static int dir[][] = {
            { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 }
    };
    static int arr[][];
    static int N;
    static ArrayList<Node> nodes = new ArrayList<>();
    static int result = Integer.MAX_VALUE;
    static int maxCellCnt = 0;
    static int row[], col[] ;
    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("p1767/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int test_case = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int tc = 1; tc <= test_case; tc++) {
            N = Integer.parseInt(br.readLine());
            arr = new int[N][N];

            for (int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int k = 0; k < N; k++) {
                    arr[i][k] = Integer.parseInt(st.nextToken());
                    if (arr[i][k] == 1 && !(i == 0 || i == N - 1 || k == 0 || k == N - 1))
                        nodes.add(new Node(i, k));
                }
            }
             row = new int[N];
             col = new int[N];
            for (int i = 0; i < N; i++) {
                for (int k = 0; k < N; k++) {
                    if(arr[i][k] == 1) {
                        row[i] |= 1 << k; 
                        col[k] |= 1 << i;
                    }
                }
            }
            fn(0, 0, 0);
            sb.append("#").append(tc).append(" ").append(result).append("\n");
            nodes = new ArrayList<>();
            result = Integer.MAX_VALUE;
            maxCellCnt = 0;
        }
        System.out.println(sb);

    }

    static void fn(int idx, int cellCnt, int lineCnt) {
        if (idx == nodes.size()) {
            if (cellCnt > maxCellCnt) {
                maxCellCnt = cellCnt;
                result = lineCnt;
            } else if (cellCnt == maxCellCnt) {
                if (result > lineCnt) {
                    result = lineCnt;
                }
            }

            return;
        }
        Node node = nodes.get(idx);
        int x = node.x;
        int y = node.y;
        // 복구 보기
        //
        
        if((col[y] ^ ((1 << (x+1)) -1))== col[y]) {
            int tmp = col[y];
      
            col[y] |= (((1 << x) -1));
            for(int i = 0; i < x; i++) row[i] += (1 << y);
          
            fn(idx+ 1, cellCnt + 1, lineCnt + y);
            for(int i = 0; i < x; i++) row[i] -= (1 << y);
            col[y] -= tmp;
           
        }

        if((row[x] ^ ((1 << (y)) -1))== row[y]) {
            int tmp = row[x];
            row[x] |= (((1 << y) -1));
            for(int i = 0; i < y; i++) col[i] += (1 << x);
            fn(idx+ 1, cellCnt + 1, lineCnt + x);
            for(int i = 0; i < y; i++) col[i] -= (1 << x);
            row[x] -= tmp;
        }
    

        if( ( (((1 << N) -1) - ((1 << (x+1))-1)) & col[y]) == 0) { 
              
            int tmp = col[y];
            col[y] |= (((1 << N) -1) - ((1 << (y +1 )) -1 ));
            for(int i = x+1; i < N; i++) row[i] |= (1 << y);
            
            fn(idx+ 1, cellCnt + 1, lineCnt + (N - y - 1));
            for(int i = x+1; i < N; i++) row[i] -= (1 << y);
            col[y] = tmp;
            
        }


       if( ( (((1 << N) -1) - ((1 << (y+1))-1)) & row[x]) == 0) { 
        
            int tmp = row[x];
            row[x] |= (((1 << N) -1) - ((1 << (x +1 )) -1 ));
            for(int i = y+1; i < N; i++) col[i] |= (1 << x);
             
            fn(idx+ 1, cellCnt + 1, lineCnt + (N - x  -1 ));
            for(int i = y+1; i < N; i++) col[i] -= (1 << x);
            row[x] = tmp;
           
        }
         
        fn(idx+ 1, cellCnt, lineCnt );
    }

    static class Node {
        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }

        int x, y;

    }
}
