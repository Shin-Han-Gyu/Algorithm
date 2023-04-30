import java.io.*;
import java.util.*;

//Boj 3671 gold4
public class Solution {
    static int N, M, ans;
    static int[] parents;
    static boolean[] isPrime = new boolean[10000000];
    static HashSet<String> set;
    static int pi(String a) {
        return Integer.parseInt(a);
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = pi(br.readLine());

        Arrays.fill(isPrime, true);
        isPrime[0] = false;
        isPrime[1] = false;

        for(int i=2; i*i<10000000; ++i) {
            if(isPrime[i]) {
                for(int j=i*i; j<10000000; j+=i) {
                    isPrime[j] = false;
                }
            }
        }
        for(int n=0; n<N; ++n) {
            char[] temp = br.readLine().toCharArray();
            ans = 0;
            set = new HashSet<>();
            boolean[] chk = new boolean[temp.length];

            solve(temp, chk, "");
            System.out.println(ans);
        }

    }

    static void solve(char[] temp, boolean[] chk, String num) {
        if(num.length()!=0 && num.charAt(0)=='0') {
            return;
        }
        if(num.length()!=0 && !set.contains(num)) {
            set.add(num);
            if(isPrime[pi(num)]) {
                ++ans;
            }
        }
        for(int i=0; i<temp.length; ++i) {
            if(!chk[i]) {
                chk[i] = true;
                solve(temp, chk, num+temp[i]);
                chk[i] = false;
            }
        }

    }

}
