import java.io.*;
import java.util.*;

//Boj 9421 silver1
public class Solution {
    static int N, M, K, ans;
    static int pi(String a) {
        return Integer.parseInt(a);
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        N = pi(br.readLine());

        boolean[] isPrime = new boolean[N+1];
        Arrays.fill(isPrime, true);
        isPrime[0] = false;
        isPrime[1] = false;

        for(int i=2; i<Math.sqrt(N+1); ++i) {
            if(isPrime[i]) {
                for(int j=i+i; j<N+1; j+=i) {
                    isPrime[j] = false;
                }
            }
        }

        for(int i=7; i<N+1; ++i) {
            if(!isPrime[i]) {
                continue;
            }
            Set<Integer> chk = new HashSet<>();
            int temp = i;
            boolean flag = false;
            while(true) {
                int sum = 0;
                while(temp!=0) {
                    sum += (temp%10)*(temp%10);
                    temp/=10;
                }
                if(sum==1) {
                    flag = true;
                    break;
                }

                if(!chk.contains(sum)) {
                    chk.add(sum);
                }
                else {
                    break;
                }

                temp = sum;

            }
            if(flag) {
                System.out.println(i);
            }

        }

    }

}