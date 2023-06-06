import java.io.*;
import java.util.*;

//Boj 2629 gold3
public class Solution {
    static int N, M, T, ans;
    static int[] weight;
    static boolean[] isAble = new boolean[15001];
    static boolean[][] chk = new boolean[31][15001];
    static int pi(String a) {
        return Integer.parseInt(a);
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        N = pi(br.readLine());
        weight = new int[N];
        String[] temp = br.readLine().split(" ");
        for(int i=0; i<N; ++i) {
            weight[i] = pi(temp[i]);
        }

        T = pi(br.readLine());
        temp = br.readLine().split(" ");
        chk(0,0);
        for(int t=0; t<T; ++t) {
            if(pi(temp[t])<15001 && isAble[pi(temp[t])]) {
                sb.append("Y ");
            }
            else {
                sb.append("N ");
            }
        }

        System.out.println(sb);
    }

    static void chk(int idx, int w) {
        isAble[w] = true;
        if(idx>N-1) {
            return;
        }
        if(chk[idx][w]) {
            return;
        }
        chk[idx][w] = true;
        chk(idx+1, w);
        chk(idx+1, w+weight[idx]);
        chk(idx+1, Math.abs(w-weight[idx]));
    }

}