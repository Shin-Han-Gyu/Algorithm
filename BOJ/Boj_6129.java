import java.io.*;
import java.util.*;

//Boj 6219 silver3
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
        isPrime = new boolean[4000001];
        Arrays.fill(isPrime, true);
        isPrime[0] = false;
        isPrime[1] = false;
        for(int i=2; i<4000001; ++i) {
            if(isPrime[i]) {
                for(int j=i+i; j<4000001; j+=i) {
                    isPrime[j] = false;
                }
            }
        }
        String[] temp = br.readLine().split(" ");
        for(int i=pi(temp[0]); i<pi(temp[1])+1; ++i) {
            if(isPrime[i] && Integer.toString(i).contains(temp[2])) {
                ++ans;
            }
        }
        System.out.println(ans);

    }

}