import java.io.*;
import java.util.*;

//Boj 5936 silver1
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

        while(true) {
            String temp = br.readLine();
            if(temp.equals("0")) {
                break;
            }
            ans = 0;
            for(int i=0; i<temp.length()-1; ++i) {
                for(int j=i+1; j<temp.length(); ++j) {
                    if(temp.substring(i,j).length()>6) {
                        continue;
                    }
                    M = pi(temp.substring(i,j));

                    if(M>100000) {
                        continue;
                    }
                    if(isPrime[M]) {
                        ans = Math.max(ans, M);
                    }
                }
            }
            System.out.println(ans);
        }

    }

}