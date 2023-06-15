import java.io.*;
import java.util.*;

//Boj 9251 gold5
public class Solution {
    static int K, N, M, ans;
    static int pi(String a) {
        return Integer .parseInt(a);
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        char[] a = br.readLine().toCharArray();
        char[] b = br.readLine().toCharArray();
        int[][] dp = new int[a.length+1][b.length+1];
        String Ans = "";

        for(int i=1; i<a.length+1; ++i) {
            for(int j=1; j<b.length+1; ++j) {
                if(a[i-1] == b[j-1]) {
                    dp[i][j] = dp[i-1][j-1] + 1;
                }
                else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }

        int a_ = a.length;
        int b_ = b.length;

        while(a_!=0 && b_!=0) {
            if(dp[a_-1][b_] == dp[a_][b_]) {
                a_--;
            }
            else if(dp[a_][b_-1] == dp[a_][b_]) {
                b_--;
            }
            else {
                Ans += a[a_-1];
                a_--;
                b_--;
            }
        }
        System.out.println(dp[a.length][b.length]);
    }


}