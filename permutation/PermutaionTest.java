package permutation;

import java.util.Scanner;

public class PermutaionTest {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int r = sc.nextInt();
        int[] input = new int[n];
        int[] p = new int[n];

        for (int i = 0; i < n; i++)
            input[i] = sc.nextInt();

        
        int cnt = 0;
        while (++cnt <= r)
            p[n - cnt] = 1;
        
            
        do {
            
            for (int i = 0; i < n; i++) {
                if (p[i] == 0)
                    continue;
                
                    System.out.println(input[i] + "\t");
            }
                
            
            System.out.println();

        }while(perm(p));
    }
    
    static boolean np(int[] p) {
        int N = p.length;
        int i = N - 1;
        
        while (i > 0 && p[i - 1] >= p[i])
            --i;
        if (i == 0)
            return false;
        
        int j = N - 1;
        while (p[i - 1] >= p[j])
            --j;
        
        swap(p, i-1, j);

        int k = N - 1;
        while(i < k ) swap(p, i++, k--);

        return true;
    }
    
    static boolean perm(int p[]) {
        int N = p.length;
        int i = N - 1;

        while (i > 0 && p[i - 1] >= p[i])
            i--;

        if (i - 1 == 0)
            return false;

        int j = N - 1;

        while (p[i - 1] >= p[j])
            j--;

        swap(p, i - 1, j);

        int k = N - 1;
        while (i < k) {
            swap(p, j, k);
        }

        return true;
    }  
    
    static void swap(int[] p, int a, int b) {
        int tmp = p[a];
        p[a] = p[b];
        p[b] = tmp;
    
    }
}
