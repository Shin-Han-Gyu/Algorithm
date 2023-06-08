import java.io.*;
import java.util.*;

//Boj 14505 gold3
public class Solution {
    static int N, M, T, ans;
    static String a;
    static int[][] dp = new int[1001][1001];
    static int pi(String a) {
        return Integer.parseInt(a);
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        a = br.readLine();

        for(int i=0; i<1001; ++i) {
            Arrays.fill(dp[i], -1);
        }
        System.out.println(sol(0,a.length()-1));
    }

    static int sol(int x, int y) {
        if(x>y) {
            return 0;
        }
        if(x==y) {
            return 1;
        }
        if(dp[x][y]!=-1) {
            return dp[x][y];
        }

        int temp = (sol(x,y-1) + sol(x+1,y) - sol(x+1,y-1));

        if(a.charAt(x) == a.charAt(y)) {
            temp = (temp + sol(x+1, y-1) + 1);
        }

        dp[x][y] = temp;
        return temp;
    }

}