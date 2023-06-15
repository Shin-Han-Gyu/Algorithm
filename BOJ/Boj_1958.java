import java.io.*;
import java.util.*;

//Boj 1958 gold3
public class Solution {
    static int K, N, M, ans;
    static int pi(String a) {
        return Integer .parseInt(a);
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String A = br.readLine();
        String B = br.readLine();
        String C = br.readLine();

        int a_len = A.length();
        int b_len = B.length();
        int c_len = C.length();

        int[][][] dp = new int[a_len+1][b_len+1][c_len+1];

        for(int i=1; i<a_len+1; ++i) {
            for(int j=1; j<b_len+1; ++j) {
                for(int k=1; k<c_len+1; ++k) {
                    if(A.charAt(i-1) == B.charAt(j-1) && B.charAt(j-1) == C.charAt(k-1)) {
                        dp[i][j][k] = dp[i-1][j-1][k-1]+1;
                    }
                    else {
                        dp[i][j][k] = Math.max(dp[i-1][j][k], Math.max(dp[i][j-1][k], dp[i][j][k-1]));
                    }
                }

            }
        }
        System.out.println(dp[a_len][b_len][c_len]);
    }


}