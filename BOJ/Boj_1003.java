import java.io.*;
import java.util.*;

//Boj 1003 silver3
public class Solution {
    static int K, N, M, ans;
    static long Ans;
    static int pi(String a) {
        return Integer .parseInt(a);
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        K = pi(br.readLine());
        int[] dp = new int[41];
        dp[1] = 1;
        dp[2] = 1;
        for(int i=3; i<41; ++i) {
            dp[i] = dp[i-1] + dp[i-2];
        }
        for(int k=0; k<K; ++k) {
            N = pi(br.readLine());
            if(N==0) {
                System.out.println("1 0");
                continue;
            }
            if(N==1) {
                System.out.println("0 1");
                continue;
            }
            System.out.println(dp[N-1] + " " + dp[N]);
        }
    }

}