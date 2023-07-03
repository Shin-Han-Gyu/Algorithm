import java.io.*;
import java.util.*;

//Boj 2294 gold5
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
        Arrays.fill(dp, 10001);
        dp[0] = 0;

        for(int i=1; i<N+1; ++i) {
            coin[i] = pi(br.readLine());

            for(int j=coin[i]; j<K+1; ++j) {
                dp[j] = Math.min(dp[j], dp[j-coin[i]]+1);
            }
        }

        if(dp[K]==10001) {
            System.out.println(-1);
        }
        else {
            System.out.println(dp[K]);
        }

    }

}