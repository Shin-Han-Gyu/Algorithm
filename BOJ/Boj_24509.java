import java.io.*;
import java.util.*;

//Boj 24509 silver5
public class Main {
    static int K, N, M, ans;

    static int pi(String a) {
        return Integer.parseInt(a);
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = pi(br.readLine());
        int[][] scores = new int[N][5];
        for (int i = 0; i < N; ++i) {
            String[] a = br.readLine().split(" ");
            scores[i][0] = pi(a[0]);
            scores[i][1] = pi(a[1]);
            scores[i][2] = pi(a[2]);
            scores[i][3] = pi(a[3]);
            scores[i][4] = pi(a[4]);
        }
        StringBuilder sb = new StringBuilder();
        boolean[] chk = new boolean[N + 1];
        for (int i = 1; i < 5; ++i) {
            int finalI = i;

            Arrays.sort(scores, new Comparator<int[]>() {
                @Override
                public int compare(int[] o1, int[] o2) {
                    if (chk[o1[0]] && !chk[o2[0]]) return 1;
                    if (!chk[o1[0]] && chk[o2[0]]) return -1;
                    if (o1[finalI] == o2[finalI]) {
                        return o1[0] - o2[0];
                    }
                    return o2[finalI] - o1[finalI];
                }
            });
            chk[scores[0][0]] = true;
            sb.append(scores[0][0] + " ");
        }
        System.out.println(sb);
    }

}