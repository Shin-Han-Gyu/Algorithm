import java.io.*;
import java.util.*;

//Boj 17268 Gold3
public class Solution {
    static int K, N, M, ans;
    static int pi(String a) {
        return Integer.parseInt(a);
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        N = pi(br.readLine());
        N/=2;
        long[] dp = new long[5001];
        dp[0] = 1;

        for(int i=1; i<N+1; ++i) {
            for(int j=0; j<i; ++j) {
                dp[i] += (dp[j]*dp[i-1-j])%987654321;
                dp[i] %=987654321;
            }
        }
        System.out.println(dp[N]);
    }

}