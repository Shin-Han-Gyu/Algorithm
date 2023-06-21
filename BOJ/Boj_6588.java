import java.io.*;
import java.util.*;

//Boj 6588 silver1
public class Solution {
    static int K, N, M, ans;
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
        for(int i=3; i<1000001; ++i) {
            if(isPrime[i]) {
                arr.add(i);
            }
        }

        while(true) {
            N = pi(br.readLine());
            if(N==0) {
                break;
            }

            for(Integer i : arr) {
                if(isPrime[N-i]) {
                    sb.append(N + " = " + i + " + " + (N-i)+"\n");
                    break;
                }
            }

        }
        System.out.print(sb);

    }

}