import java.io.*;
import java.util.*;

//Boj 11440 platinum5
public class Solution {
    static int K, N, M, ans;
    static long Ans;
    static HashMap<Long, Long> d = new HashMap<>();
    static final long mod = 1000000007;
    static int pi(String a) {
        return Integer .parseInt(a);
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String[] temp = br.readLine().split(" ");
        System.out.println(fibo(gcd(Long.parseLong(temp[0]), Long.parseLong(temp[1]))));
    }

    static long fibo(long n)
    {
        if(n <= 0) {
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
                d.put(n, (t1 * t1 + t2 * t2) % mod);
            }
            else {
                m = n / 2;
                long t1 = fibo(m - 1);
                long t2 = fibo(m);
                d.put(n, ((2 * t1 + t2) * t2) % mod);
            }
            return d.get(n);
        }
    }

    static long gcd(long A, long B){
        long max = Math.max(A, B);
        long min = Math.min(A, B);
        while(true) {
            if(max%min==0) {
                break;
            }
            long tmp = min;
            min = max%min;
            max = tmp;
        }
        return min;
    }
}