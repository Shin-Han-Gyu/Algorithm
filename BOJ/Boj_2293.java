import java.io.*;
import java.util.*;

//Boj 2293 gold5
public class Solution {
    static int K, N, M, ans;
    static int pi(String a) {
        return Integer .parseInt(a);
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String[] temp = br.readLine().split(" ");

        N = pi(temp[0]);
        K = pi(temp[1]);
        int[] dp = new int[10001], coin = new int[N+1];
        dp[0] = 1;

        for(int i=1; i<N+1; ++i) {
            coin[i] = pi(br.readLine());

            for(int j=coin[i]; j<K+1; ++j) {
                if(dp[j-coin[i]]!=0) {
                    dp[j] += dp[j-coin[i]];
                }
            }
        }
        System.out.println(dp[K]);
    }

}