import java.io.*;
import java.util.*;

//Boj 1106 Gold5
public class Solution {
    static int C, N, M, ans;
    static int[][] map;
    static int pi(String a) {
        return Integer.parseInt(a);
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] temp = br.readLine().split(" ");
        C = pi(temp[0]);
        N = pi(temp[1]);
        int[] dp = new int[C+101];
        Arrays.fill(dp, (C+101) * 100);
        dp[0] = 0;
        ans = (C+101) * 100;

        for(int i=0; i<N; ++i) {
            temp = br.readLine().split(" ");

            for(int j=pi(temp[1]); j<C+101; ++j) {
                dp[j] = Math.min(dp[j], pi(temp[0]) + dp[j-pi(temp[1])]);
            }
        }


        for(int i=C; i<C+101; ++i) {
            ans = Math.min(ans, dp[i]);
        }
        System.out.println(ans);
    }

}