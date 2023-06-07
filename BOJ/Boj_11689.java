import java.io.*;
import java.util.*;

//Boj 11689 gold1
public class Solution {
    static int N, M, T, ans;
    static int pi(String a) {
        return Integer.parseInt(a);
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        long n = Long.parseLong(br.readLine());
        long Ans = n;
        for(long i=2; i*i<n+1; ++i) {
            if(n%i == 0) {
                Ans -= Ans / i;
                while(n%i == 0) {
                    n/=i;
                }
            }
        }

        if(n>1) {
            Ans -= Ans/n;
        }
        System.out.println(Ans);
    }

}