import java.io.*;
import java.util.*;

//Boj 9020 silver2
public class Solution {
    static int K, N, M, ans;
    static long Ans;
    static boolean[] isPrime = new boolean[1000001];
    static int pi(String a) {
        return Integer .parseInt(a);
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        ArrayList<Integer> arr = new ArrayList<>();
        Arrays.fill(isPrime, true);
        isPrime[0] = false;
        isPrime[1] = false;
        for(int i=2; i<Math.sqrt(1000001)+1; ++i) {
            if(isPrime[i]) {
                for(int j=i+i; j<1000001; j+=i) {
                    isPrime[j] = false;
                }
            }
        }
        for(int i=2; i<1000001; ++i) {
            if(isPrime[i]) {
                arr.add(i);
            }
        }
        K = pi(br.readLine());
        for(int i=0; i<K; ++i) {
            N = pi(br.readLine());
            ans = 0;
            for(Integer integer : arr) {
                if(integer>N-integer) {
                    break;
                }
                if(isPrime[N-integer]) {
                    ++ans;
                }
            }
            sb.append(ans + "\n");
        }

        System.out.print(sb);

    }

}