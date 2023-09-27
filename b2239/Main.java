package b2239;

import java.util.*;
import java.io.*;

public class Main {
    static int arr[][] = new int[9][9];
    static int n = 9;

    static int row[] = new int[10];
    static int col[] = new int[10];
    static int mini[] = new int[9];
    static boolean check = false;
    static ArrayList<Integer> zeroList = new ArrayList<>();

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("b2239/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            for (int k = 0; k < n; k++) {
                arr[i][k] = str.charAt(k) - '0';
                if (arr[i][k] != 0) {
                    row[i] |= (1 << arr[i][k]);
                    col[k] |= (1 << arr[i][k]);
                    mini[(i / 3) * 3 + (k / 3)] |= (1 << arr[i][k]);
                }
            }
        }

        find(0);

    }

    static void print() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 9; i++) {
            for (int k = 0; k < 9; k++) {
                sb.append(arr[i][k]);
            }
            sb.append("\n");
        }

        System.out.print(sb.toString());
    }

    static void find(int index) {
        if (index == 81) {
            print();
            check = true;
            return;
        }

        if (check)
            return;

        int x = index / 9;
        int y = index % 9;

        if (arr[x][y] != 0) {
            find(index + 1);
        } else {

            for (int i = 1; i <= 9; i++) {
                if ((row[x] & (1 << i)) == 0 && (col[y] & (1 << i)) == 0
                        && (mini[(x / 3) * 3 + (y / 3)] & (1 << i)) == 0) {
                    row[x] |= (1 << i);
                    col[y] |= (1 << i);
                    mini[(x / 3) * 3 + (y / 3)] |= (1 << i);
                    arr[x][y] = i;
                    find(index + 1);
                    if (check)
                        return;
                    arr[x][y] = 0;
                    row[x] ^= (1 << i);
                    col[y] ^= (1 << i);
                    mini[(x / 3) * 3 + (y / 3)] ^= (1 << i);

                }
            }
        }
    }

}
