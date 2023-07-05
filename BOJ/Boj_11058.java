import java.io.*;
import java.util.*;

//Boj 11058 gold5
public class Solution {
    static int K, N, M, ans;
    static int pi(String a) {
        return Integer .parseInt(a);
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        N = pi(br.readLine());
        long[] dp = new long[101];

        for(int i=1; i<6; ++i) {
            dp[i] = i;
        }

        for(int i=7; i<101; ++i) {
            for(int j=2; j<6; ++j) {
                dp[i] = Math.max(dp[i-(j+1)]*j, dp[i]);
            }
        }
        System.out.println(dp[N]);

    }

}