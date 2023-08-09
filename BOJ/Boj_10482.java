import java.io.*;
import java.util.*;

//Boj 10482 silver2
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
        K = pi(br.readLine());
        for(int k=0; k<K; ++k) {
            N = pi(br.readLine());
            ans = 0;
            String temp = "";
            for(Integer p : prime) {
                if(N-p<0 || N-p<p) {
                    break;
                }
                if(isPrime[p] && isPrime[N-p]) {
                    temp += (p) + "+" + (N-p) +"\n";
                    ++ans;
                }
            }
            sb.append(N + " has " + ans + " representation(s)\n");
            sb.append(temp+"\n");
        }

        System.out.print(sb);

    }

}