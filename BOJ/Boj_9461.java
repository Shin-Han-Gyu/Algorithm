import java.io.*;
import java.util.*;

//Boj 9461 silver3
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
        long[] dp = new long[101];
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 1;
        dp[3] = 1;

        for(int i=4; i<101; ++i) {
            dp[i] = dp[i-3] + dp[i-2];
        }
        K = pi(br.readLine());
        for(int k=0; k<K; ++k) {
            System.out.println(dp[pi(br.readLine())]);
        }

    }

}