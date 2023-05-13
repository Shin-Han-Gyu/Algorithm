import java.io.*;
import java.math.*;
import java.util.*;

//Boj 12919 gold5
public class Solution {
    static int N, M, K, ans;
    static String S;
    static int pi(String a) {
        return Integer.parseInt(a);
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        S = br.readLine();
        String T = br.readLine();

        StringBuilder sb = new StringBuilder();
        sb.append(T);
        solve(sb, T.length());
        System.out.println(0);
    }

    static void solve(StringBuilder sb, int cnt) {
        if(cnt==S.length()) {
            if(sb.toString().equals(S)) {
                System.out.println(1);
                System.exit(0);
            }
            return;
        }
        --cnt;
        if(sb.charAt(0)=='B') {
            solve(new StringBuilder(sb.substring(1,sb.length())).reverse(), cnt);
        }
        if(sb.charAt(sb.length()-1)=='A') {
            sb.deleteCharAt(sb.length()-1);
            solve(sb, cnt);
        }

    }

}
