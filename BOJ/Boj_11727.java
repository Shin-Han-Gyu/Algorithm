import java.io.*;
import java.util.*;

//Boj 11727 silver3
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
        int[] dp = new int[N+1];
        dp[0] = 1;
        dp[1] = 1;
        for(int i=2; i<N+1; ++i) {
            dp[i] = (dp[i-1] + dp[i-2]*2)% 10007;
        }
        System.out.println(dp[N]);
    }

}