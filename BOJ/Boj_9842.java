import java.io.*;
import java.util.*;

//Boj 9842 silver4
public class Solution {
    static int K, N, M, ans;
    static long Ans;
    static int pi(String a) {
        return Integer .parseInt(a);
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        N = pi(br.readLine());
        boolean[] isPrime = new boolean[1000001];
        Arrays.fill(isPrime, true);
        isPrime[0] = false;
        isPrime[1] = false;
        ArrayList<Integer> prime = new ArrayList<>();
        for(int i=2; i<10000+1; ++i) {
            if(isPrime[i]) {
                for(int j=i+i; j<1000001; j+=i) {
                    isPrime[j] = false;
                }
            }
        }
        for(int i=0; i<1000001; ++i) {
            if(isPrime[i]) {
                prime.add(i);
            }
        }
        System.out.println(prime.get(N-1));

    }

}