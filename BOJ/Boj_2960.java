import java.io.*;
import java.util.*;

//Boj 2960 silver4
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
        String[] temp = br.readLine().split(" ");
        N = pi(temp[0]);
        K = pi(temp[1]);
        isPrime = new boolean[N+1];
        Arrays.fill(isPrime, true);
        isPrime[0] = false;
        isPrime[1] = false;
        for(int i=2; i<N+1; ++i) {
            if(isPrime[i]) {
                ++ans;
                if(ans==K) {
                    System.out.println(i);
                    return;
                }
                for(int j=i+i; j<N+1; j+=i) {
                    if(isPrime[j]) {
                        isPrime[j] = false;
                        ++ans;
                        if(ans == K) {
                            System.out.println(j);
                            return;
                        }
                    }
                }
            }
        }

    }

}