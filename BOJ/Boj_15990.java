import java.io.*;
import java.util.*;

//Boj 15990 silver2
public class Solution {
    static int K, N, M, ans;
    static boolean[] isPrime;
    static long Ans;
    static int pi(String a) {
        return Integer .parseInt(a);
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        long[][] dp = new long[100001][4];
        long mod = 1000000009;
        dp[1][1] = dp[2][2] = 1;
        dp[3][1] = dp[3][2] = dp[3][3] = 1;

        for(int i=4; i<100001; i++) {
            dp[i][1] = (dp[i-1][2] + dp[i-1][3]) % mod;
            dp[i][2] = (dp[i-2][1] + dp[i-2][3]) % mod;
            dp[i][3] = (dp[i-3][1] + dp[i-3][2]) % mod;
        }

        K = pi(br.readLine());
        for(int k=0; k<K; ++k) {
            N = pi(br.readLine());
            System.out.println((dp[N][1] + dp[N][2] + dp[N][3])%mod);
        }

    }

}