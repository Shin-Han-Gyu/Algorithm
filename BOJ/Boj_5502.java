import java.io.*;
import java.util.*;

//Boj 5502 gold3
public class Solution {
    static int K, N, M, ans;
    static int pi(String a) {
        return Integer .parseInt(a);
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        N = pi(br.readLine());
        String S = br.readLine();
        char[] a = S.toCharArray();
        char[] b = new StringBuffer(S).reverse().toString().toCharArray();
        int[][] dp = new int[N+1][N+1];

        for(int i=1; i<N+1; ++i) {
            for(int j=1; j<N+1; ++j) {
                if(a[i-1] == b[j-1]) {
                    dp[i][j] = dp[i-1][j-1] + 1;
                }
                else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }

        int a_ = N;
        int b_ = N;

        while(a_!=0 && b_!=0) {
            if(dp[a_-1][b_] == dp[a_][b_]) {
                a_--;
            }
            else if(dp[a_][b_-1] == dp[a_][b_]) {
                b_--;
            }
            else {
                ans += a[a_-1];
                a_--;
                b_--;
            }
        }

        System.out.println(N-dp[N][N]);
    }

}