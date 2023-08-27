package p1767;

import java.util.Arrays;

public class TTest {
    public static void main(String[] args) {
            int col[]= {16, 48, 3, 16, 0, 4, 0};
            int N = 7;
            int x = 2;
            int y = 5;

           // 이건 col을 보면 됨 0이면 없다는 의미 // 위쪽
           System.out.println(Arrays.toString(col));
            System.out.println(col[y] + " " + (1 << (x)));
           if((col[y] ^ (1 << (x)))== 0) {
                col[y] |= (((1 << x) -1));
                //fn()
                col[y] -=((1<< x) -1);

                // for(int i = 0; i < x; i++) row[i] += (i << y);
                // fn(idx+ 1, cellCnt + 1, lineCnt + y);
                // col[y] ^= ((1 << y)); // 잎ㅇ[ㅔ 변경
            }
    }
}
