import java.io.*;
import java.util.*;

//Boj 2133 gold4
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
        int[] dp = new int[31];
        dp[0] = 1;
        dp[2] = 3;
        for(int i=4; i<31; ++i) {
            for(int j=0; j<i-2; j+=2) {
                dp[i] += dp[j]*2;
            }
            dp[i] += dp[i-2]*dp[2];
        }
        N = pi(br.readLine());
        if(N%2==1) {
            System.out.println(0);
            return;
        }
        System.out.println(dp[N]);

    }

}