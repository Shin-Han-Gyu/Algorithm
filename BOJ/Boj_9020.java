import java.io.*;
import java.util.*;

//Boj 9020 silver2
public class Solution {
    static int K, N, M, ans;
    static long Ans;
    static boolean[] isPrime = new boolean[10001];
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
        for(int i=2; i<Math.sqrt(10001)+1; ++i) {
            if(isPrime[i]) {
                for(int j=i+i; j<10001; j+=i) {
                    isPrime[j] = false;
                }
            }
        }
        for(int i=2; i<10001; ++i) {
            if(isPrime[i]) {
                arr.add(i);
            }
        }
        K = pi(br.readLine());
        for(int i=0; i<K; ++i) {
            N = pi(br.readLine());
            if(N==4) {
                sb.append("2 2\n");
                continue;
            }
            int min = Integer.MAX_VALUE;
            String a = "";
            for(Integer integer : arr) {
                if(integer>N-integer) {
                    break;
                }
                if(isPrime[N-integer]) {
                    if(min>Math.abs(N-integer)) {
                        min = N-integer;
                        a = integer + " " + (N-integer) + "\n";
                    }
                }
            }
            sb.append(a);
        }

        System.out.print(sb);

    }

}