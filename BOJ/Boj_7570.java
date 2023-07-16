import java.io.*;
import java.util.*;

//Boj 7570 gold3
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
        int[] dp = new int[N+1];
        String[] temp = br.readLine().split(" ");

        for(int i=0; i<N; ++i) {
            dp[pi(temp[i])] = dp[pi(temp[i])-1] + 1;
        }

        Arrays.sort(dp);

        System.out.println(N-dp[N]);
    }

}