import java.io.*;
import java.util.*;

//Boj 11055 silver2
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
        int[] arr = new int[N];
        String[] temp = br.readLine().split(" ");
        for(int i=0; i<N; ++i) {
            arr[i] = pi(temp[i]);
        }
        int[] dp = new int[N];
        dp[0] = arr[0];

        for(int i=1; i<N; ++i) {
            dp[i] = arr[i];
            for(int j=0; j<i; ++j) {
                if(arr[i]>arr[j]) {
                    dp[i] = Math.max(dp[j]+arr[i], dp[i]);
                }
            }
        }

        Arrays.sort(dp);
        System.out.println(dp[N-1]);

    }

}