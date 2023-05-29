import java.io.*;
import java.util.*;

//Boj 17425 gold4
public class Solution {
    static int N, M, K, ans;
    static int pi(String a) {
        return Integer.parseInt(a);
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        long[] g = new long[1000001];

        for(int i=1; i<1001; ++i) {
            for(int j=1; i*j<1000001; ++j) {
                if(i<=j) {
                    g[i*j] += i;
                }
                if(i<j) {
                    g[i*j]+=j;
                }
            }
        }
        for(int i=2; i<1000001; ++i) {
            g[i] += g[i-1];
        }
        K = pi(br.readLine());
        for(int t=0; t<K; ++t) {
            N = pi(br.readLine());
            sb.append(g[N] +"\n");
        }

        System.out.print(sb);
    }

}