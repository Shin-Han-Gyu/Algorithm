import java.io.*;
import java.util.*;

//Boj 1013 gold5
public class Solution {
    static int N, M, K, ans;
    static int pi(String a) {
        return Integer.parseInt(a);
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = pi(br.readLine());
        String pattern = "(100+1+|01)+";
        for(int i=0; i<N; ++i) {
            String a = br.readLine().trim();
            boolean regex = a.matches(pattern);
            if(regex) {
                System.out.println("YES");
            }
            else {
                System.out.println("NO");
            }
        }

    }

}