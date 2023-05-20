import java.io.*;
import java.util.*;

//Boj 27210 gold5
public class Solution {
    static int N, M, K, ans;
    static int pi(String a) {
        return Integer.parseInt(a);
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = pi(br.readLine());
        String[] temp = br.readLine().split(" ");
        int[] statue = new int[N];

        for(int i=0; i<N; ++i) {
            statue[i] = pi(temp[i])==1 ? 1 : -1;
        }
        int sum = 0;
        for(int i=0; i<N; ++i) {
            sum += statue[i];
            if(Math.abs(sum) > ans) {
                ans = Math.abs(sum);
            }
            if(sum < 0) {
                sum = 0;
            }
        }
        sum = 0;
        for(int i=0; i<N; ++i) {
            sum += statue[i];
            if(Math.abs(sum) > ans) {
                ans = Math.abs(sum);
            }
            if(sum > 0) {
                sum = 0;
            }
        }

        System.out.println(ans);

    }

}