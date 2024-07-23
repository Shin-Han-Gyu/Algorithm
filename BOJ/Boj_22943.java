import java.io.*;
import java.util.*;

//Boj 22943 gold5
// https://www.acmicpc.net/problem/22943
public class Main {
    static int K, N, M, ans;
    static boolean[] sum, mux;
    static ArrayList<Integer> num = new ArrayList<>();
    static boolean[] prime = new boolean[100001];
    static int pi(String a) {
        return Integer.parseInt(a);
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] a = br.readLine().split(" ");
        K = pi(a[0]);
        M = pi(a[1]);

        sum = new boolean[100001];
        mux = new boolean[100001];

        Arrays.fill(prime, true);
        prime[0] = false;
        prime[1] = false;

        for(int i=2; i<Math.sqrt(100001); ++i) {
            if(prime[i]) {
                for(int j=i+i; j<100001; j+=i) {
                    prime[j] = false;
                }
            }
        }
        for(int i=2; i<100001; ++i) {
            if(prime[i]) {
                for(int j=i+1; j<100001; ++j) {
                    if(prime[j] && i+j<100000) {
                        sum[i+j] = true;
                    }
                }
                for(int j=i; j<100001; ++j) {
                    if(prime[j] && (long)i*j<100000) {
                        mux[i*j] = true;
                    }
                }
            }
        }

        nums("", new boolean[10], 0);

        for(int i: num) {
            if(sum[i]) {
                if(mux[dd(i)]) ++ans;
            }
        }
        System.out.println(ans);
    }

    static void nums(String str, boolean[] isUse, int cnt) {
        if(cnt==K) {
            num.add(pi(str));
            return;
        }

        for(int i=0; i<10; ++i) {
            if(cnt==0 && i==0) continue;

            if(!isUse[i]) {
                isUse[i] = true;
                nums(str+i, isUse, cnt+1);
                isUse[i] = false;
            }
        }
    }

    static int dd (int a) {
        while(a%M==0) {
            a /=M;
        }
        return a;
    }

}