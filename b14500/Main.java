package b14500;

import java.util.*;
import java.io.*;

public class Main {
    static int shape[][][] = {
            {
                    { 1, 1, 1 },
                    { 1, 0, 0 },
                    { 0, 0, 0 }
            },
            {
                    { 1, 1, 1 },
                    { 0, 0, 1 },
                    { 0, 0, 0 }
            },
            {
                    { 1, 0, 0 },
                    { 1, 0, 0 },
                    { 1, 1, 0 }
            },
            {
                    { 0, 1, 0 },
                    { 0, 1, 0 },
                    { 1, 1, 0 }
            },
            {
                    { 1, 1, 0 },
                    { 0, 1, 0 },
                    { 0, 1, 0 }
            },
            {
                    { 1, 1, 0 },
                    { 1, 0, 0 },
                    { 1, 0, 0 },

            },
            {
                    { 1, 0, 0 },
                    { 1, 1, 1 },
                    { 0, 0, 0 }
            },
            {
                    { 0, 0, 1 },
                    { 1, 1, 1 },
                    { 0, 0, 0 }
            },
            ////// ---------주황색
            {
                    { 1, 0, 0 },
                    { 1, 1, 0 },
                    { 0, 1, 0 }
            },
            {
                    { 0, 1, 0 },
                    { 1, 1, 0 },
                    { 1, 0, 0 }
            },
            {
                    { 1, 1, 0 },
                    { 0, 1, 1 },
                    { 0, 0, 0 }
            },
            {
                    { 0, 1, 1 },
                    { 1, 1, 0 },
                    { 0, 0, 0 }
            },
            /// ---핑크
            {
                    { 1, 1, 1 },
                    { 0, 1, 0 },
                    { 0, 0, 0 },

            },
            {
                    { 0, 1, 0 },
                    { 1, 1, 1 },
                    { 0, 0, 0 },

            }, {
                    { 0, 1, 0 },
                    { 1, 1, 0 },
                    { 0, 1, 0 },

            }, {
                    { 1, 0, 0 },
                    { 1, 1, 0 },
                    { 1, 0, 0 },

            },
            // -----노랑
            {
                    { 1, 1, 0 },
                    { 1, 1, 0 },
                    { 0, 0, 0 }

            }
    };

    static int arr[][];

    public static void main(String[] args) throws Exception {

        System.setIn(new FileInputStream("b14500/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str[] = br.readLine().split(" ");
        int n = Integer.parseInt(str[0]);
        int m = Integer.parseInt(str[1]);
        arr = new int[n][m];
        for (int i = 0; i < n; i++) {
            str = br.readLine().split(" ");
            for (int k = 0; k < m; k++) {
                arr[i][k] = Integer.parseInt(str[k]);
            }
        }
        int max = 0;

        for (int i = 0; i < n; i++) {
            for (int k = 0; k < m - 3; k++) {
                int sum = 0;
                for (int a = 0; a < 4; a++)
                    sum += arr[i][k + a];
                max = max > sum ? max : sum;

            }
        }
        for (int i = 0; i < m; i++) {
            for (int k = 0; k < n - 3; k++) {
                int sum = 0;
                for (int a = 0; a < 4; a++)
                    sum += arr[k + a][i];
                max = max > sum ? max : sum;
            }
        }

        for (int i = 0; i < n; i++) {
            for (int k = 0; k < m; k++) {
                for (int shapeNum = 0; shapeNum < shape.length; shapeNum++) {
                    int sum = 0;
                    for (int x = 0; x < 3; x++) {
                        for (int y = 0; y < 3; y++) {
                            if (shape[shapeNum][x][y] == 0)
                                continue;
                            if (i + x >= n || k + y >= m)
                                continue;

                            sum += arr[i + x][k + y];
                        }
                    }
                    max = max > sum ? max : sum;
                }
            }
        }
        System.out.println(max);
    }
}
