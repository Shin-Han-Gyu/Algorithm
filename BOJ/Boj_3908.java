import java.io.*;
import java.util.*;

//Boj 3908 gold3
public class Solution {
    static int K, N, M, ans;
    static boolean[] isPrime = new boolean[1121];
    static ArrayList<Integer> prime = new ArrayList<>();
    static int pi(String a) {
        return Integer.parseInt(a);
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        Arrays.fill(isPrime, true);
        isPrime[0] = false;
        isPrime[1] = false;
        int[][] dp = new int[1121][15];
        dp[0][0] = 1;
        for(int i=2; i<Math.sqrt(1120)+1; ++i) {
            if(isPrime[i]) {
                for(int j=i+i; j<1121; j+=i) {
                    isPrime[j] = false;
                }
            }
        }
        for(int i=0; i<1121; ++i) {
            if(isPrime[i]) {
                prime.add(i);
            }
        }

        for(int i=0; i<prime.size(); ++i) {
            for(int j=1120; j>=prime.get(i); --j) {
                for(int k=1; k<15; ++k) {
                    dp[j][k] += dp[j-prime.get(i)][k-1];
                }
            }
        }


        N = pi(br.readLine());

        for(int i=0; i<N; ++i) {
            String[] temp = br.readLine().split(" ");
            sb.append(dp[pi(temp[0])][pi(temp[1])]+"\n");
        }
        System.out.print(sb);

    }

}