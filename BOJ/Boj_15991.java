import java.io.*;
import java.util.*;

//Boj 15991 silver1
public class Solution {
    static int K, N, M, ans;
    static long Ans;
    static int pi(String a) {
        return Integer .parseInt(a);
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        K = pi(br.readLine());
        long[] dp = new long[100001];
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 2;
        dp[4] = 3;
        dp[5] = 3;
        dp[6] = 6;

        for(int i=7; i<100001; ++i) {
            dp[i] = (dp[i-2] + dp[i-4] + dp[i-6])%1000000009;
        }
        for(int k=0; k<K; ++k) {
            N = pi(br.readLine());
            sb.append(dp[N] + "\n");
        }
        System.out.print(sb);
    }

}