import java.io.*;
import java.util.*;

//Boj 2312 silver3
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
        K = pi(br.readLine());
        isPrime = new boolean[100001];
        Arrays.fill(isPrime, true);
        isPrime[0] = false;
        isPrime[1] = false;
        for(int i=2; i<100001; ++i) {
            if(isPrime[i]) {
                for(int j=i+i; j<100001; j+=i) {
                    isPrime[j] = false;
                }
            }
        }
        for(int k=0; k<K; ++k) {
            N = pi(br.readLine());
            if(isPrime[N]) {
                sb.append(N + " 1\n");
                continue;
            }
            
            for(int i=2; i<N; ++i) {
                if(isPrime[i] && N%i==0) {
                    int chk = N;
                    int cnt = 0;
                    while(chk%i==0) {
                        chk/=i;
                        ++cnt;
                    }
                    sb.append(i + " " + cnt + "\n");
                }
            }
        }
        System.out.print(sb);

    }

}