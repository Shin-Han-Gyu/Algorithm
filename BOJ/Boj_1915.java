import java.io.*;
import java.util.*;

//Boj 1915 gold4
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
        int[][] dp = new int[1000][1000];
        String[] temp = br.readLine().split(" ");
        N = pi(temp[0]);
        M = pi(temp[1]);

        for(int i=0; i<N; ++i) {
            String t = br.readLine();
            for(int j=0; j<M; ++j) {
                dp[i][j] = t.charAt(j)-'0';
            }
        }

        for(int i=1; i<N; ++i) {
            for(int j=1; j<M; ++j) {
                if(dp[i][j]!=0) {
                    dp[i][j] += Math.min(dp[i-1][j], Math.min(dp[i][j-1], dp[i-1][j-1]));
                }
            }
        }

        for(int i=0; i<N; ++i) {
            for(int j=0; j<M; ++j) {
                ans = Math.max(ans, dp[i][j]);
            }
        }
        System.out.println(ans*ans);

    }

}