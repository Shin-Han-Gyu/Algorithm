import java.io.*;
import java.util.*;

//Boj 10816 silver4
public class Solution {
    static int K, N, M, ans;
    static long Ans;
    static int pi(String a) {
        return Integer .parseInt(a);
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        N = pi(br.readLine());
        Map<String, Integer> map = new HashMap<>();

        String[] a = br.readLine().split(" ");
        for(int i=0; i<N; ++i) {
            map.put(a[i],map.getOrDefault(a[i],0)+1);
        }
        M = pi(br.readLine());
        a = br.readLine().split(" ");

        for(int i=0; i<M; ++i) {
            sb.append(map.getOrDefault(a[i],0) + " ");
        }

        System.out.println(sb);
    }

}