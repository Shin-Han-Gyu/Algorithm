import java.io.*;
import java.util.*;

//Boj 1300 Gold2
public class Solution {
    static int K, N, M, ans;
    static int[][] map;
    static int[] parent;
    static int pi(String a) {
        return Integer.parseInt(a);
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = pi(br.readLine());
        K = pi(br.readLine());

        int min = 1;
        int max = K;

        while(min < max) {
            int mid = (min+max)/2;

            M = 0;
            for(int i=1; i<N+1; ++i) {
                M += Math.min(mid/i, N);
            }

            if(M>K-1) {
                max = mid;
            }
            else {
                min = mid+1;
            }
        }
        System.out.println(min);

    }

}