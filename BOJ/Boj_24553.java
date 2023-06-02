import java.io.*;
import java.util.*;

//Boj 24553 gold4
public class Solution {
    static int N, M, K, ans;
    static int pi(String a) {
        return Integer.parseInt(a);
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        N = pi(br.readLine());

        for(int i=0; i<N; ++i) {
            long t = Long.parseLong(br.readLine());

            if(t%10==0) {
                System.out.println(1);
            }
            else {
                System.out.println(0);
            }
        }
    }

}