package b16935;

import java.util.*;
import java.io.*;

public class Main {
    static int n;
    static int m;

    static int arr[][];

    public static void main(String[] args) throws Exception {
        // System.setIn(new FileInputStream("b16935/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        int commCnt = Integer.parseInt(st.nextToken());
        arr = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");

            for (int k = 0; k < m; k++) {
                arr[i][k] = Integer.parseInt(st.nextToken());
            }
        }
        String commStr[] = br.readLine().split(" ");
        for (int comm = 0; comm < commCnt; comm++) {
            int com = Integer.parseInt(commStr[comm]);
            if (com == 1)
                comm1();
            if (com == 2)
                comm2();
            if (com == 3)
                comm3();
            if (com == 4)
                comm4();
            if (com == 5)
                comm5();
            if (com == 6)
                comm6();
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < arr.length; i++) {
            for (int k = 0; k < arr[0].length; k++) {
                sb.append(arr[i][k]).append(" ");
            }
            sb.append("\n");
        }
        System.out.print(sb.toString());
    }

    static void comm1() {
        int tmp = arr.length / 2;

        for (int i = 0; i < tmp; i++) {
            for (int k = 0; k < arr[0].length; k++) {
                int t = arr[i][k];
                arr[i][k] = arr[arr.length - 1 - i][k];
                arr[arr.length - 1 - i][k] = t;
            }
        }
    }

    static void comm2() {
        int tmp = arr[0].length / 2;

        for (int i = 0; i < arr.length; i++) {
            for (int k = 0; k < tmp; k++) {
                int t = arr[i][k];
                arr[i][k] = arr[i][arr[0].length - k - 1];
                arr[i][arr[0].length - k - 1] = t;
            }
        }

    }

    static void comm3() {
        int tmpArr[][] = new int[arr[0].length][arr.length];
        for (int i = 0; i < arr.length; i++) {
            for (int k = 0; k < arr[0].length; k++) {
                tmpArr[k][arr.length - 1 - i] = arr[i][k];
            }
        }

        arr = new int[arr[0].length][arr.length];
        for (int i = 0; i < arr.length; i++) {
            for (int k = 0; k < arr[0].length; k++) {
                arr[i][k] = tmpArr[i][k];
            }
        }
    }

    static void comm4() {

        int tmpArr[][] = new int[arr[0].length][arr.length];
        for (int i = 0; i < arr.length; i++) {
            for (int k = 0; k < arr[0].length; k++) {
                tmpArr[arr[0].length - 1 - k][i] = arr[i][k];
            }
        }

        arr = new int[arr[0].length][arr.length];
        for (int i = 0; i < arr.length; i++) {
            for (int k = 0; k < arr[0].length; k++) {
                arr[i][k] = tmpArr[i][k];
            }
        }

    }

    static void comm5() {
        int a = (arr.length / 2);
        int b = (arr[0].length / 2);

        int tmpArr[][] = new int[a][b];

        // 그룹1을 tmpArr에 복사
        for (int i = 0; i < a; i++) {
            for (int k = 0; k < b; k++) {
                tmpArr[i][k] = arr[i][k];
            }
        }
        // 4- >1 복사
        for (int i = 0; i < a; i++) {
            for (int k = 0; k < b; k++) {
                arr[i][k] = arr[i + a][k];
            }
        }

        // 3 -> 4
        for (int i = 0; i < a; i++) {
            for (int k = 0; k < b; k++) {
                arr[i + a][k] = arr[i + a][k + b];
            }
        }

        // 2 -> 3
        for (int i = 0; i < a; i++) {
            for (int k = 0; k < b; k++) {
                arr[i + a][k + b] = arr[i][k + b];
            }
        }

        // tmp -> 2
        for (int i = 0; i < a; i++) {
            for (int k = 0; k < b; k++) {
                arr[i][k + b] = tmpArr[i][k];
            }
        }

    }

    static void comm6() {
        int a = (arr.length / 2);
        int b = (arr[0].length / 2);

        int tmpArr[][] = new int[a][b];

        // 1 copy
        for (int i = 0; i < a; i++) {
            for (int k = 0; k < b; k++) {
                tmpArr[i][k] = arr[i][k];
            }
        }

        // 2-> 1
        for (int i = 0; i < a; i++) {
            for (int k = 0; k < b; k++) {
                arr[i][k] = arr[i][k + b];
            }
        }

        // 3->2
        for (int i = 0; i < a; i++) {
            for (int k = 0; k < b; k++) {
                arr[i][k + b] = arr[i + a][k + b];
            }
        }
        // 4- >3
        for (int i = 0; i < a; i++) {
            for (int k = 0; k < b; k++) {
                arr[i + a][k + b] = arr[i + a][k];
            }
        }

        // tmp ->4
        for (int i = 0; i < a; i++) {
            for (int k = 0; k < b; k++) {
                arr[i + a][k] = tmpArr[i][k];
            }
        }

    }

}
