import java.io.*;
import java.util.*;

//Boj 13699 silver4
public class Solution {
    static int K, N, M, ans;
    static long Ans;
    static int pi(String a) {
        return Integer .parseInt(a);
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        N = pi(br.readLine());
        long[] dp = new long[36];

        dp[0] = 1;

        for(int i=1; i<36; ++i) {
            for(int j=1; j<i+1; ++j) {
                dp[i] += dp[j-1]*dp[i-j];
            }
        }
        System.out.println(dp[N]);

    }

}