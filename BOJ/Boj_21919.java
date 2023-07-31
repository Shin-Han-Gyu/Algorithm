import java.io.*;
import java.util.*;

//Boj 21919 silver3
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
        N = pi(br.readLine());
        isPrime = new boolean[1000001];
        Arrays.fill(isPrime, true);
        isPrime[0] = false;
        isPrime[1] = false;
        for(int i=2; i<1000001; ++i) {
            if(isPrime[i]) {
                for(int j=i+i; j<1000001; j+=i) {
                    isPrime[j] = false;
                }
            }
        }
        String[] temp = br.readLine().split(" ");
        Ans = 1;
        boolean[] chk = new boolean[1000001];
        for(int i=0; i<N; ++i) {
            if(isPrime[pi(temp[i])] && !chk[pi(temp[i])]) {
                Ans *= pi(temp[i]);
                chk[pi(temp[i])] = true;
            }
        }
        if(Ans==1) {
            Ans*=-1;
        }
        System.out.println(Ans);

    }

}