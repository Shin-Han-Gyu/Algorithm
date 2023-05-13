import java.io.*;
import java.math.*;
import java.util.*;

//Boj 15927 gold5
public class Solution {
    static int N, M, K, ans;
    static String S;
    static int pi(String a) {
        return Integer.parseInt(a);
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        S = br.readLine();
        StringBuilder sb = new StringBuilder(S);
        sb.reverse();
        if(S.equals(sb.toString())) {
            StringBuilder sb1 = sb.deleteCharAt(0);
            String temp = sb1.toString();
            sb1.reverse();
            if(temp.equals(sb1.toString())) {
                System.out.println(-1);
            }
            else {
                System.out.println(S.length() - 1);
            }
        }
        else {
            System.out.println(S.length());
        }
    }

}