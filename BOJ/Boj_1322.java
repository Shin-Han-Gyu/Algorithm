import java.io.*;
import java.util.*;

//Boj 1322 Gold4
public class Solution {
    static int X, K, N, M, ans;
    static int[][] map;
    static int pi(String a) {
        return Integer.parseInt(a);
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] temp = br.readLine().split(" ");
        int X = pi(temp[0]);
        int K = pi(temp[1]);

        String X_bin = Integer.toBinaryString(X);
        String K_bin = Integer.toBinaryString(K);

        int idx = K_bin.length()-1;
        long ans = 0;

        for(int i=0; idx>-1; ++i) {
            char t;
            if(i>X_bin.length()-1 || X_bin.charAt(X_bin.length()-1-i) == '0') {
                if(K_bin.charAt(idx)=='1') {
                    ans += (long) Math.pow(2, i);
                }
                --idx;
            }
        }
        System.out.println(ans);

    }

}