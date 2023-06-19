import java.io.*;
import java.util.*;

//Boj 1947 gold3
public class Solution {
    static int K, N, M, ans;
    static int pi(String a) {
        return Integer .parseInt(a);
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        N = pi(br.readLine());
        if(N==1) {
            System.out.println(0);
            return;
        }
        long[] dp = new long[N+1];
        dp[1]=0;
        dp[2]=1;

        for(int i=3; i<N+1; ++i) {
            dp[i] = ((i-1)*(dp[i-1] + dp[i-2]))%1000000000;
        }

        System.out.println(dp[N]);
    }

}