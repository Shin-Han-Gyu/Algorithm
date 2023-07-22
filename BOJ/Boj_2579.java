import java.io.*;
import java.util.*;

//Boj 2579 silver3
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
        int[] arr = new int[301];
        for(int i=1; i<N+1; ++i) {
            arr[i] = pi(br.readLine());
        }
        int[] dp = new int[301];
        dp[1] = arr[1];
        dp[2] = arr[1] + arr[2];
        for(int i=3; i<N+1; ++i) {
            dp[i] = Math.max(dp[i-2], dp[i-3]+arr[i-1]) + arr[i];
        }

        System.out.println(dp[N]);
    }

}