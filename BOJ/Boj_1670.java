import java.io.*;
import java.util.*;

//Boj 1670 Gold3
public class Solution {
    static int K, N, M, ans;
    static int pi(String a) {
        return Integer.parseInt(a);
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        N = pi(br.readLine());

        long[] dp = new long[10001];
        dp[0] = 1;
        dp[1] = 0;

        for(int i=2; i<N+1; i+=2) {
            for(int j=0; j<i/2; ++j) {
                dp[i] += (dp[j*2]*dp[i-2-(j*2)])%987654321;
                dp[i] %=987654321;
            }
        }
        System.out.println(dp[N]);
    }

}