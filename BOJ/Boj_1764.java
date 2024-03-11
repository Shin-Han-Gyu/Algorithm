import java.io.*;
import java.util.*;

//Boj 1764 silver4
public class Solution {
    static int K, N, M, ans;
    static long Ans;
    static int pi(String a) {
        return Integer .parseInt(a);
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String[] a = br.readLine().split(" ");
        N = pi(a[0]);
        M = pi(a[1]);
        HashSet<String> set = new HashSet<>();
        ArrayList<String> Ans = new ArrayList<>();
        for(int i=0; i<N; ++i) {
            set.add(br.readLine());
        }

        for(int i=0; i<M; ++i) {
            String temp = br.readLine();
            if(set.contains(temp)) {
                Ans.add(temp);
            }
        }
        Collections.sort(Ans);
        sb.append(Ans.size()+"\n");
        for(String s : Ans) {
            sb.append(s+"\n");
        }
        System.out.println(sb);
    }

}