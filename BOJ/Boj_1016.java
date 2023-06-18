import java.io.*;
import java.util.*;

//Boj 1016 gold1
public class Solution {
    static int K, N, M, ans;
    static int pi(String a) {
        return Integer .parseInt(a);
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String[] temp = br.readLine().split(" ");
        long min = Long.parseLong(temp[0]), max = Long.parseLong(temp[1]);
        boolean[] isPrime = new boolean[1000001];
        boolean[] chk = new boolean[(int)(max-min)+1];
        Arrays.fill(isPrime, true);
        isPrime[0] = false;
        isPrime[1] = false;

        for(int i=2; i<1000001; ++i) {
            if(isPrime[i]) {
                for(int j=i+i; j<1000001; j+=i) {
                    isPrime[j] = false;
                }
            }
        }

        for(int i=2; (long)i*i<max+1; ++i) {
            if(!isPrime[i]) {
                continue;
            }
            long t = (long)i*i;
            for (long j=min/t + (min%t != 0 ? 1 : 0); j*t<max+1; ++j) {
                if (!chk[(int) (j*t-min)]) {
                    chk[(int) (j*t-min)] = true;
                }
            }
        }

        for(int i=0; i<(int)(max-min)+1; ++i) {
            if(!chk[i]) {
                ++ans;
            }
        }
        System.out.println(ans);
    }

}