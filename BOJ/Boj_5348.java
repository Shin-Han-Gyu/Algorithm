import java.io.*;
import java.util.*;

//Boj 5348 silver2
// https://www.acmicpc.net/problem/22943
public class Main {
    static int K, N, M, ans;
    static boolean[] prime = new boolean[100001];
    static int pi(String a) {
        return Integer.parseInt(a);
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = pi(br.readLine());

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
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<N; ++i) {
            M = pi(br.readLine());
            int chk = M;
//            sb.append(M + " : prime\n");
            sb.append(M + ": ");

            for(int j=2; j<100001; ++j) {
                if (prime[j] && M % j == 0) {
                    M /= j;
                    sb.append(j + " ");
                    --j;
                }
                if (M<100001 && prime[M]) {
                    if(chk==M) {
                        sb.append("prime\n");
                    }
                    else {
                        sb.append(M + "\n");
                    }
                    break;
                }
                if(j==100000 && M>100000) {
                    sb.append("prime\n");
                }
            }
        }
        System.out.println(sb);

    }

}