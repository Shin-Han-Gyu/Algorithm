import java.io.*;
import java.math.BigInteger;
import java.util.*;

//Boj 1788 silver3
public class Solution {
    static int K, N, M, ans;
    static long Ans;
    static HashMap<Long, Long> d = new HashMap<>();
    static long mod = 1000000000;
    static int pi(String a) {
        return Integer .parseInt(a);
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        Ans = Long.parseLong(br.readLine());
        if(Ans<0) {
            System.out.println(Ans%2==0 ? -1 : 1);
        }
        else if(Ans>0) {
            System.out.println(1);
        }
        else {
            System.out.println(0);
        }
        System.out.println(fibo(Math.abs(Ans))%mod);

    }

    static long fibo(long n) {
        if(n == 0) {
            return 0;
        }
        else if(n == 1 || n == 2) {
            return 1;
        }
        else if(d.containsKey(n)) {
            return d.get(n);
        }
        else {
            long m;
            if(n % 2 == 1) {
                m = (n + 1) / 2;
                long t1 = fibo(m);
                long t2 = fibo(m - 1);
                d.put(n, (t1 * t1 + t2 * t2)%mod);
            }
            else {
                m = n / 2;
                long t1 = fibo(m - 1);
                long t2 = fibo(m);
                d.put(n, ((2 * t1 + t2) * t2)%mod);
            }
            return d.get(n);
        }
    }


}