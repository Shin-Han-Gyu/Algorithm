import java.io.*;
import java.util.*;

//Boj 11049 gold3
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
        int[][] arr = new int[N][2];
        int[][] dp = new int[N][N];

        for(int i=0; i<N; ++i) {
            String[] temp = br.readLine().split(" ");
            arr[i][0] = pi(temp[0]);
            arr[i][1] = pi(temp[1]);
        }

        for(int i=1; i<N; ++i) {
            for(int j=0; j+i<N; ++j) {
                dp[j][i+j] = Integer.MAX_VALUE;
                for(int k=0; k<i; ++k) {
                    dp[j][i+j] = Math.min(dp[j][j+k] + dp[j+k+1][i+j] + arr[j][0]*arr[j+k][1]*arr[i+j][1],dp[j][i+j]);
                }
            }
        }

        System.out.println(dp[0][N-1]);
    }

}