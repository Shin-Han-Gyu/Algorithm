import java.io.*;
import java.util.*;

//Boj 1107 Gold5
public class Solution {
    static int D, N, M, ans;
    static boolean[] wrong;
    static int[][] map;
    static int[] parent;
    static int pi(String a) {
        return Integer.parseInt(a);
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = pi(br.readLine());
        M = pi(br.readLine());

        wrong = new boolean[10];
        if(M!=0) {
            String[] temp = br.readLine().split(" ");

            for(int i=0; i<M; ++i) {
                wrong[pi(temp[i])] = true;
            }
        }

        if(N==100) {
            System.out.println(0);
            System.exit(0);
        }
        int ans = Math.abs(N-100);

        for(int i=0; i<1000001; ++i) {
            String A = Integer.toString(i);

            boolean chk = true;
            for(int j=0; j<A.length(); ++j) {
                int r = A.charAt(j) - '0';
                if(wrong[r]) {
                    chk = false;
                    break;
                }
            }

            if(chk) {
                ans = Math.min(ans, A.length() + Math.abs(i-N));
            }
        }
        System.out.println(ans);
    }

}