import java.io.*;
import java.util.*;

//Boj 12892 Gold4
public class Solution {
    static int D, N, M, ans;
    static int[][] map;
    static int pi(String a) {
        return Integer.parseInt(a);
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] temp = br.readLine().split(" ");
        N = pi(temp[0]);
        D = pi(temp[1]);
        long[][] present = new long[N][2];
        for (int i=0; i<N; ++i) {
            temp = br.readLine().split(" ");
            present[i][0] = pi(temp[0]);
            present[i][1] = pi(temp[1]);
        }
        Arrays.sort(present, Comparator.comparingLong(o -> o[0]));

        long this_ans = present[0][1];
        long sum = this_ans;
        int j = 0;
        for (int i=1; i<N; ++i) {
            sum += present[i][1];
            while (present[i][0] - present[j][0] >= D) {
                sum -= present[j][1];
                j++;
            }
            this_ans = Math.max(this_ans, sum);
        }
        System.out.println(this_ans);


    }



}