import java.io.*;
import java.util.*;

//Boj 4948 silver2
public class Solution {
    static int K, N, M, ans;
    static boolean[] isPrime;
    static long Ans;
    static int pi(String a) {
        return Integer .parseInt(a);
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        isPrime = new boolean[280000];
        Arrays.fill(isPrime, true);
        isPrime[0] = false;
        isPrime[1] = false;
        for(int i=2; i<Math.sqrt(280000); ++i) {
            if(isPrime[i]) {
                for(int j=i+i; j<280000; j+=i) {
                    isPrime[j] = false;
                }
            }
        }

        while(true) {
            N = pi(br.readLine());
            if(N==0) {
                break;
            }
            ans = 0;
            for(int i=N+1; i<2*N+1; ++i) {
                if(isPrime[i]) {
                    ++ans;
                }
            }
            sb.append(ans+"\n");
        }

        System.out.print(sb);

    }

}