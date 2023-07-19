import java.io.*;
import java.util.*;

//Boj 1912 silver2
public class Main {
    static int K, N, M, ans;
    static long Ans;
    static int pi(String a) {
        return Integer .parseInt(a);
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        N = pi(br.readLine());
        String[] temp = br.readLine().split(" ");
        int[] a = new int[N+1];
        int[] dp = new int[N+1];

        for(int i=1; i<N+1; ++i) {
            a[i] = pi(temp[i-1]);
        }
        dp[1] = a[1];
        ans = a[1];
        for(int i=2; i<N+1; ++i) {
            dp[i] = Math.max(dp[i-1]+a[i], a[i]);
            ans = Math.max(ans, dp[i]);
        }

        System.out.println(ans);
    }

}