import java.io.*;
import java.util.*;

//Boj 23048 gold5
// https://www.acmicpc.net/problem/23048
public class Main {
    static int K, N, M, ans;
    static int[] colors;
    static boolean[] prime = new boolean[10000001];
    static int pi(String a) {
        return Integer.parseInt(a);
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = pi(br.readLine());
        colors = new int[N+1];

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
        colors[1] = 1;
        int chk = 2;
        for(int i=2; i<N+1; ++i) {
            if(prime[i]) {
                colors[i] = chk;
                for(int j=i+i; j<N+1; j+=i) {
                    colors[j] = chk;
                }
                ++chk;
            }
        }
        StringBuilder sb = new StringBuilder();

        for(int i=1; i<N+1; ++i) {
            sb.append(colors[i] + " ");
        }
        System.out.println(chk-1+"\n"+sb.toString());
    }

}