import java.io.*;
import java.util.*;

//Boj 16888 gold5
public class Solution {
    static int K, N, M, ans;
    static long Ans;
    static int pi(String a) {
        return Integer .parseInt(a);
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        K = pi(br.readLine());
        boolean[] win = new boolean[1000001];
        win[1] = true;
        win[2] = false;
        win[3] = true;

        for(int i=0; i<Math.sqrt(1000001); ++i) {
            win[i*i] = true;
        }

        for(int i=2; i<1000001; ++i) {
            if (!win[i]) {
                for(int j=1; j*j + i<1000001; ++j) {
                    win[j*j + i] = true;
                }
            }
        }

        for(int k=0; k<K; ++k) {
            N = pi(br.readLine());
            System.out.println(win[N] ? "koosaga" : "cubelover");
        }


    }

}