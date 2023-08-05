import java.io.*;
import java.util.*;

//Boj 1699 silver2
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
        N = pi(br.readLine());
        int[] dp = new int[100001];
        for(int i=1; i<N+1; ++i) {
            dp[i] = i;
            for(int j=1; j*j<i+1; ++j) {
                dp[i] = Math.min(dp[i], dp[i-j*j]+1);
            }
        }
        System.out.println(dp[N]);

    }

}