import java.io.*;
import java.util.*;

//Boj 2225 gold5
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
        int[] dp = new int[201];
        int mod = 1000000000;
        dp[0] = 1;
        String[] temp = br.readLine().split(" ");
        N = pi(temp[0]);
        K = pi(temp[1]);
        for(int i=1; i<K+1; ++i) {
            for(int j=1; j<N+1; ++j) {
                dp[j] = (dp[j-1]+dp[j])%mod;
            }
        }
        System.out.println(dp[N]%mod);

    }

}