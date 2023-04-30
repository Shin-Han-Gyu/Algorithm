import java.io.*;
import java.util.*;

//Boj 1351 gold5
public class Solution {
    static int N, M, ans;
    static int[] parents;
    static HashMap<Long, Long> map = new HashMap<>();
    static int pi(String a) {
        return Integer.parseInt(a);
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] temp = br.readLine().split(" ");
        long n, p, q;
        n = Long.parseLong(temp[0]);
        p = Long.parseLong(temp[1]);
        q = Long.parseLong(temp[2]);

        System.out.println(solve(n, p, q));
    }

    static long solve(long n, long p, long q) {
        if(n==0) {
            return 1;
        }
        if(map.containsKey(n)) {
            return map.get(n);
        }

        map.put(n, solve((long)Math.floor(n/p), p, q) + solve((long)Math.floor(n/q), p, q));
        return map.get(n);
    }
}
