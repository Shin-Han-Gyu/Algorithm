import java.io.*;
import java.util.*;

//Boj 3896 silver1
public class Solution {
    static int N, M, K, ans;
    static int pi(String a) {
        return Integer.parseInt(a);
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        boolean[] isPrime = new boolean[1299709+1];
        Arrays.fill(isPrime, true);
        isPrime[0] = false;
        isPrime[1] = false;
        ArrayList<Integer> prime = new ArrayList<>();
        for(int i=2; i<Math.sqrt(1299709+1); ++i) {
            if(isPrime[i]) {
                for(int j=i+i; j<1299709+1; j+=i) {
                    isPrime[j] = false;
                }
            }
        }

        for(int i=0; i<1299709+1; ++i) {
            if(isPrime[i]) {
                prime.add(i);
            }
        }

        N = pi(br.readLine());

        for(int n=0; n<N; ++n) {
            M = pi(br.readLine());

            if(isPrime[M]) {
                System.out.println(0);
            }
            else {
                int a=0, b=0;
                for(Integer i : prime) {
                    if(i>M) {
                        b = i;
                        a = prime.get(prime.indexOf(i)-1);
                        break;
                    }
                }
                System.out.println(b-a);
            }

        }

    }

}