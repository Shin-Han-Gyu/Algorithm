import java.io.*;
import java.util.*;

//Boj 13002 gold3
public class Solution {
    static int N, M, K, ans;
    static int pi(String a) {
        return Integer.parseInt(a);
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        N = pi(br.readLine());
        int[] rice = new int[N+1];
        int[][] dp = new int[N+1][N+1];
        String[] temp = br.readLine().split(" ");
        for(int i=0; i<N; ++i) {
            rice[i+1] = pi(temp[i]);
        }

        for(int i=1; i<N+1; ++i) {
            dp[i][i] = rice[i]*N;

            for(int j=i-1; j>0; --j) {
                dp[j][i] = Math.max(dp[j+1][i] + rice[j]*(N-i+j), dp[j][i-1] + rice[i]*(N-i+j));
            }
        }

        System.out.println(dp[1][N]);

    }

}