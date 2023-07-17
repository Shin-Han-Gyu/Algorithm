import java.io.*;
import java.util.*;

//Boj 11052 silver1
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
        int[] card = new int[N];
        int[] dp = new int[N+1];
        String[] temp = br.readLine().split(" ");
        for(int i=0; i<N; ++i) {
            card[i] = pi(temp[i]);
        }

        for(int i=1; i<N+1; ++i) {
            dp[i] = card[i-1];
            for(int j=1; j<i; ++j) {
                dp[i] = Math.max(dp[i], card[j-1]+dp[i-j]);
            }
        }
        System.out.println(dp[N]);
    }

}