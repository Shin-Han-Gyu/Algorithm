import java.io.*;
import java.util.*;

//Boj 11423 silver1
public class Main {
    static int K, N, M, ans;
    static boolean[] prime = new boolean[10000001];
    static int pi(String a) {
        return Integer.parseInt(a);
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] a;

        Arrays.fill(prime, true);
        prime[0] = false;
        prime[1] = false;

        for(int i=2; i<Math.sqrt(10000001); ++i) {
            if(prime[i]) {
                for(int j=i+i; j<10000001; j+=i) {
                    prime[j] = false;
                }
            }
        }

        while(true) {
            int ans = 0;
            try {
                a = br.readLine().split(" ");
            } catch (Exception e) {
                break;
            }
            if(a.length==1) {
                continue;
            }
            N = pi(a[0]);
            M = pi(a[1]);

            for(int i=N; i<M+1; ++i) {
                if(prime[i]) ++ans;
            }
            System.out.println(ans + "\n");

        }
    }

}