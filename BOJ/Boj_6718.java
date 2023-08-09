import java.io.*;
import java.util.*;

//Boj 6718 silver1
public class Solution {
    static int K, N, M, ans;
    static boolean[] isPrime;
    static ArrayList<Integer> prime = new ArrayList<>();
    static long Ans;
    static int pi(String a) {
        return Integer .parseInt(a);
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        isPrime = new boolean[32165];
        Arrays.fill(isPrime, true);
        isPrime[0] = false;
        isPrime[1] = false;
        for(int i=2; i<32165; ++i) {
            if(isPrime[i]) {
                prime.add(i);
                for(int j=i+i; j<32165; j+=i) {
                    isPrime[j] = false;
                }
            }
        }

        while(true) {
            N = pi(br.readLine());
            ans = 0;
            if(N==0) {
                break;
            }
            for(Integer p : prime) {
                if(N-p<0 || N-p<p) {
                    break;
                }
                if(isPrime[p] && isPrime[N-p]) {
                    ++ans;
                }
            }
            sb.append(ans + "\n");
        }
        System.out.print(sb);

    }

}