import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.*;

//Boj 12738 gold2
public class Solution {
    static int K, N, M, ans;
    static int pi(String a) {
        return Integer .parseInt(a);
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String s;
        while((s = br.readLine())!=null) {
            String[] temp = s.split(" ");

            N = pi(temp[0]);
            K = pi(temp[1]);

            int[][] fact = new int[50][2];
            int tmp =0;
            for (int i=2; i*i<K+1; ++i) {
                int cnt = 0;
                while (true){
                    if(K%i==0) {
                        ++cnt;
                        K/=i;
                    }
                    else {
                        break;
                    }
                }
                if(cnt!=0) {
                    fact[tmp][0]=i;
                    fact[tmp][1]=cnt;
                    ++tmp;
                }
            }
            if(K!=1) {
                fact[tmp][0] = K;
                fact[tmp][1] = 1;
            }
            ans = 1;
            for (int i=0; i<50; ++i) {
                tmp = N;
                int cnt = 0;
                if(fact[i][0]==0) {
                    break;
                }
                while (true){
                    if(tmp/fact[i][0]!=0) {
                        cnt+=tmp/fact[i][0];
                        tmp/=fact[i][0];
                    }
                    else {
                        break;
                    }
                }
                if(cnt!=0) {
                    ans*=Math.pow(fact[i][0], Math.min(fact[i][1], cnt));
                }
            }
            System.out.println(ans);
        }

    }

}