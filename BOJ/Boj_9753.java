import java.io.*;
import java.util.*;

//Boj 9753 silver2
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
        isPrime = new boolean[50001];
        Arrays.fill(isPrime, true);
        isPrime[0] = false;
        isPrime[1] = false;
        ArrayList<Integer> prime = new ArrayList<>();
        for(int i=2; i<50001; ++i) {
            if(isPrime[i]) {
                prime.add(i);
                for(int j=i+i; j<50001; j+=i) {
                    isPrime[j] = false;
                }
            }
        }
        TreeSet<Integer> s = new TreeSet<>();
        for(int i=0; i<prime.size()-1; ++i) {
            for(int j=i+1; j<prime.size(); ++j) {
                int temp = prime.get(i)*prime.get(j);
                if(temp>100001) {
                    continue;
                }
                s.add(temp);
            }
        }
        K = pi(br.readLine());
        for(int k=0; k<K; ++k) {
            System.out.println(s.ceiling(pi(br.readLine())));
        }

    }

}