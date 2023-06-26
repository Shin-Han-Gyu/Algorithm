import java.io.*;
import java.util.*;

//Boj 20500 gold5
public class Solution {
    static int K, N, M, ans;
    static int pi(String a) {
        return Integer .parseInt(a);
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = pi(br.readLine());
        long mod = 1000000007L;
        long[][] dp = new long[3][N+1];
        if(N==1) {
            System.out.println(0);
            return;
        }

        dp[0][2] = 1;
        dp[1][2] = 1;

        for(int i=3; i<N+1; ++i) {
            dp[0][i] = (dp[1][i - 1] + dp[2][i - 1]) % mod;
            dp[1][i] = (dp[0][i - 1] + dp[2][i - 1]) % mod;
            dp[2][i] = (dp[0][i - 1] + dp[1][i - 1]) % mod;
        }

        System.out.println(dp[0][N]);
    }

}