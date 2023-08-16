import java.io.*;
import java.util.*;

//Boj 4097 silver2
public class Solution {
    static int K, N, M, ans;
    static long Ans;
    static int pi(String a) {
        return Integer .parseInt(a);
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        while(true) {
            N = pi(br.readLine());
            if(N==0) {
                break;
            }
            ans = 0;
            int max = Integer.MIN_VALUE;

            for(int i=0; i<N; ++i) {
                int chk = pi(br.readLine());
                ans += chk;
                max = Math.max(ans, max);

                if(ans<0) {
                    ans = 0;
                }
            }
            sb.append(max + "\n");
        }
        System.out.print(sb);
    }

}