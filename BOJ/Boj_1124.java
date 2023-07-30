import java.io.*;
import java.util.*;

//Boj 1124 silver1
public class Solution {
    static int K, N, M, ans;
    static boolean[] isPrime;
    static long Ans;
    static int pi(String a) {
        return Integer .parseInt(a);
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String[] temp = br.readLine().split(" ");
        int[] count = new int[100001];
        N = pi(temp[0]);
        K = pi(temp[1]);
        isPrime = new boolean[100001];
        Arrays.fill(isPrime, true);
        isPrime[0] = false;
        isPrime[1] = false;
        for(int i=2; i<100001; ++i) {
            if(isPrime[i]) {
                for(int j=i+i; j<100001; j+=i) {
                    int chk = j;
                    isPrime[j] = false;
                    while(chk%i==0) {
                        chk/=i;
                        ++count[j];
                    }
                }
            }
        }

        for(int i=pi(temp[0]); i<pi(temp[1])+1; ++i) {
            if(isPrime[count[i]]) {
                ++ans;
            }
        }
        System.out.println(ans);

    }

}