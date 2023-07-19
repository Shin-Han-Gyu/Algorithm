import java.io.*;
import java.util.*;

//Boj 11690 gold3
public class Main {
    static int K, N, M, ans;
    static long Ans;
    static int pi(String a) {
        return Integer .parseInt(a);
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        N = pi(br.readLine());
        boolean[] isPrime = new boolean[N+1];
        ArrayList<Integer> a = new ArrayList<>();
        a.add(2);
        Ans = 1;
        Arrays.fill(isPrime, true);
        isPrime[0] = false;
        isPrime[1] = false;

        for(int i=2; i<Math.sqrt(N+1); ++i) {
            if(isPrime[i]) {
                for(int j=i*i; j<N+1; j+=i) {
                    isPrime[j] = false;
                }
            }
        }
        long mod = (long)1<<32;
        for(int i=3; i<N+1; i+=2) {
            if(isPrime[i]) {
                a.add(i);
            }
        }

        for(Integer i : a) {
            long temp = i;
            while(temp*i<N+1) {
                temp *= i;
            }
            Ans = (Ans*temp)%mod;
        }
        System.out.println(Ans);
    }

}