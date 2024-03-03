import java.io.*;
import java.util.*;

//Boj 1630 gold4
public class Main {
    static int N, M, K, T;
    static long ans;
    static final int mod = 987654321;
    static int pi(String a) {
        return Integer.parseInt(a);
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        N = pi(br.readLine());
        if(N==1 || N==2) {
            System.out.println(N);
            return;
        }
        ans = 1;
        boolean[] isPrime = new boolean[N+1];
        Arrays.fill(isPrime, true);
        isPrime[0] = false;
        isPrime[1] = false;
        ArrayList<Integer> Prime = new ArrayList<>();
        for(int i=2; i<Math.sqrt(N+1); ++i) {
            if(isPrime[i]) {
                for(int j=i+i; j<N+1; j+=i) {
                    isPrime[j] = false;
                }
            }
        }
        for(int i=2; i<N+1; ++i) {
            if(isPrime[i]) Prime.add(i);
        }

        for(Integer i : Prime) {
            if(i>N) break;
            long temp = i;
            while(temp*i<N+1) {
                temp*=i;
            }
            ans = (ans*temp)%mod;
        }

        System.out.println(ans);


    }

}