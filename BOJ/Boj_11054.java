import java.io.*;
import java.util.*;

//Boj 11054 gold4
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
        int[][] dp = new int[2][N];
        String[] temp = br.readLine().split(" ");

        for(int i=0; i<N; ++i) {
            int chk = 0;
            for(int j=0; j<i; ++j) {
                if(pi(temp[i])>pi(temp[j]) && dp[0][j]>chk) {
                    chk = dp[0][j];
                }
            }
            dp[0][i] = chk+1;
        }

        for(int i=N-1; i>-1; --i) {
            int chk = 0;
            for(int j=N-1; j>i; --j) {
                if(pi(temp[i])>pi(temp[j]) && dp[1][j]>chk) {
                    chk = dp[1][j];
                }
            }
            dp[1][i] = chk+1;
        }
        for(int i=0; i<N; ++i) {
            ans = Math.max(ans, dp[0][i] + dp[1][i] -1);
        }
        System.out.println(ans);

    }


}