import java.io.*;
import java.util.*;

//Boj 1540 gold3
public class Solution {
    static int N, M, K, ans;
    static int pi(String a) {
        return Integer.parseInt(a);
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        N = pi(br.readLine());

        for(int i=1; i<(int)(Math.sqrt(N)); ++i) {
            ans += i*i;
        }

        for(int i=N-(int)Math.sqrt(N)*(int)Math.sqrt(N), chk=0; i>0; --i) {
            ans += chk;
            chk = (chk+1)%(int)Math.sqrt(N);
        }
        System.out.println(ans);
    }

}