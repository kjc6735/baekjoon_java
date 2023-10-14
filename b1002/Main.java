package b1002;

import java.util.*;
import java.io.*;

public class Main {
  public static void main(String[] args) throws Exception{
    System.setIn(new FileInputStream("b1002/input.txt"));
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int test_case = Integer.parseInt(br.readLine());
    for(int tc = 1; tc <= test_case; tc ++){
        StringTokenizer st = new StringTokenizer(br.readLine());
        int x1 = Integer.parseInt(st.nextToken());
        int y1 = Integer.parseInt(st.nextToken());
        int r1 = Integer.parseInt(st.nextToken());
        int x2 = Integer.parseInt(st.nextToken());
        int y2 = Integer.parseInt(st.nextToken());
        int r2 = Integer.parseInt(st.nextToken());

        int dist1 =(x1 - x2)*(x1 - x2) + (y1 - y2)* (y1 - y2);
        int dist2 = (r1 + r2)*(r1 + r2);
        int dist3 =(r1 - r2) * (r1 - r2);
        if(dist3 < dist1 && dist2 > dist1 )  System.out.println(2);
        else if(dist2 == dist1 || (dist3 == dist1 && dist1 != 0)) System.out.println(1);
        else if(dist2 < dist1 || dist3 > dist1 ) System.out.println(0);
        else System.out.println(-1);
    }

}
}