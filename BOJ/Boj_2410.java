import java.io.*;
import java.util.*;

//Boj 2410 gold5
public class Solution {
    static int K, N, M, ans;
    static int pi(String a) {
        return Integer .parseInt(a);
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        N = pi(br.readLine());
        int[] dp = new int[1000001];
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;

        for(int i=3; i<1000001; ++i) {
            if(i%2==1) {
                dp[i] = dp[i-1];
            }
            else {
                dp[i] = (dp[i-1] + dp[i/2])%1000000000;
            }
        }

        System.out.println(dp[N]);
    }

}