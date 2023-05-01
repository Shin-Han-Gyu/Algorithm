import java.io.*;
import java.util.*;

//Boj 1456 gold5
public class Solution {
    static int N, M, ans;
    static int[] parents;
    static boolean[] isPrime = new boolean[10000000+1];
    static HashSet<String> set;
    static int pi(String a) {
        return Integer.parseInt(a);
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] temp = br.readLine().split(" ");
        long A = Long.parseLong(temp[0]);
        long B = Long.parseLong(temp[1]);

        Arrays.fill(isPrime, true);
        isPrime[0] = false;
        isPrime[1] = false;
        long Ans = 0;
        for(int i=2; i<10000000+1; ++i) {
            if(isPrime[i]) {
                for(int j=2*i; j<10000000+1; j+=i) {
                    isPrime[j] = false;
                }
            }
        }
        for(long i=2; i<10000000+1; ++i) {
            if(isPrime[(int)i]) {
                long chk = i;
                while((double)i<=(double)B/chk) {
                    if((double)i>=(double)A/chk) {
                        ++Ans;
                    }
                    chk *= i;

                }
            }
        }

        System.out.println(Ans);
    }

}