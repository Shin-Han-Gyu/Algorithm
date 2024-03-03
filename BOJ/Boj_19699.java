import java.io.*;
import java.util.*;

//Boj 19699 silver2
public class Main {
    static int N, M, K, T;
    static boolean[] isPrime;
    static int[] cows;
    static Set<Integer> s = new TreeSet<>();
    static int pi(String a) {
        return Integer.parseInt(a);
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String[] a = br.readLine().split(" ");
        N = pi(a[0]);
        M = pi(a[1]);
        isPrime = new boolean[9001];
        Arrays.fill(isPrime, true);
        isPrime[0] = false;
        isPrime[1] = false;

        for(int i=2; i<Math.sqrt(9001); ++i) {
            if(isPrime[i]) {
                for(int j=i+i; j<9001; j+=i) {
                    isPrime[j] = false;
                }
            }
        }

        cows = new int[N];
        a = br.readLine().split(" ");
        for(int i=0; i<N; ++i) {
            cows[i] = pi(a[i]);
        }
        pm(0,0, new boolean[N]);

        for(Integer i : s) {
            if(isPrime[i]) {
                ++K;
                System.out.print(i + " ");
            }
        }
        if(K==0) {
            System.out.println(-1);
        }

    }

    public static void pm(int sum, int cnt, boolean[] visit) {
        if(cnt==M) {
            s.add(sum);
            return;
        }

        for(int i=0; i<N; ++i) {
            if(!visit[i]) {
                visit[i] = true;
                pm(sum+cows[i], cnt+1, visit);
                visit[i] = false;
            }
        }

    }

}