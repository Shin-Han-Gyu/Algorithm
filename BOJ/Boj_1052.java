import java.io.*;
import java.util.*;

//Boj 1052 silver1
public class Solution {
    static int K, N, M, ans;
    static int pi(String a) {
        return Integer.parseInt(a);
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String[] temp = br.readLine().split(" ");

        N = pi(temp[0]);
        K = pi(temp[1]);

        while(Integer.bitCount(N)>K) {
            ans += N&(-N);
            N += N&(-N);
        }

        System.out.println(ans);

    }


}