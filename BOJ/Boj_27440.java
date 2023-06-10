import java.io.*;
import java.util.*;

//Boj 27440 Gold3
public class Solution {
    static int K, N, M, ans;
    static long X, Ans = Long.MAX_VALUE;
    static HashMap<Long, Long> map = new HashMap<>();
    static int pi(String a) {
        return Integer.parseInt(a);
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        X = Long.parseLong(br.readLine());
        solve(X, 0);
        System.out.println(Ans);
    }

    static void solve(long a, long cnt) {
        if(a==1) {
            Ans = Math.min(Ans, cnt);
            return;
        }
        if(Ans<=cnt) {
            return;
        }
        if(map.getOrDefault(a, Long.MAX_VALUE)>cnt) {
            map.put(a, cnt);
        }
        else {
            return;
        }

        if(a%3==0) {
            solve(a/3, cnt+1);
        }
        if(a%2==0) {
            solve(a/2, cnt+1);
        }
        solve(a-1, cnt+1);
    }

}