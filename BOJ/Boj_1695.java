import java.io.*;
import java.util.*;

//Boj 1695 gold4
public class Solution {
    static int N, M, ans;
    static int[] arr;
    static int[][] dp;
    static boolean[] isPrime = new boolean[10000000+1];
    static HashSet<String> set;
    static int pi(String a) {
        return Integer.parseInt(a);
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = pi(br.readLine());
        String[] temp = br.readLine().split(" ");
        arr = new int[N];
        dp = new int[N][N];
        for(int i=0; i<N; ++i) {
            for(int j=0; j<N; ++j) {
                dp[i][j] = -1;
            }
        }
        for(int i=0; i<N; ++i) {
            arr[i] = pi(temp[i]);
        }
        System.out.println(solve(0,N-1));
    }

    static int solve(int x, int y) {
        if(x>=y) {
            return 0;
        }
        if(dp[x][y]!=-1) {
            return dp[x][y];
        }
        int min = 0;
        if(arr[x]==arr[y]) {
            min = solve(x+1, y-1);
        }
        else {
            min = Math.min(solve(x+1, y) + 1, solve(x, y-1) +1);
        }
        return dp[x][y] = min;

    }

}