import java.io.*;
import java.util.*;

//Boj 2156 silver1
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
        int[] glass = new int[N];
        int[] dp = new int[N+1];
        if(N==1) {
            System.out.println(br.readLine());
            return;
        }
        for(int i=0; i<N; ++i) {
            glass[i] = pi(br.readLine());
        }
        dp[1] = glass[0];
        dp[2] = dp[1] + glass[1];
        for(int i=3; i<N+1; ++i) {
            dp[i] = Math.max(dp[i-3] + glass[i-1] + glass[i-2], Math.max(dp[i-2] + glass[i-1], dp[i-1]));
        }
        System.out.println(dp[N]);
    }

}