import java.io.*;
import java.util.*;

//Boj 15988 silver2
public class Solution {
    static int K, N, M, ans;
    static int pi(String a) {
        return Integer .parseInt(a);
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        K = pi(br.readLine());
        long[] dp = new long[1000001];
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;

        for(int i=4; i<1000001; ++i) {
            dp[i] = (dp[i-3] + dp[i-2] + dp[i-1])%1000000009;
        }

        for(int i=0; i<K; ++i) {
            sb.append(dp[pi(br.readLine())]+"\n");
        }
        System.out.print(sb);

    }

}