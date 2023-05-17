import java.io.*;
import java.util.*;

//Boj 13164 gold5
public class Solution {
    static int N, M, K, ans;
    static int pi(String a) {
        return Integer.parseInt(a);
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] temp = br.readLine().split(" ");
        N = pi(temp[0]);
        K = pi(temp[1]);

        int[] diff = new int[N-1];
        temp = br.readLine().split(" ");
        for(int i=0; i<N-1; ++i) {
            diff[i] = pi(temp[i+1]) - pi(temp[i]);
        }

        Arrays.sort(diff);

        for(int i=0; i<N-K; ++i) {
            ans += diff[i];
        }
        System.out.println(ans);
    }

}