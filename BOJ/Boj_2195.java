import java.io.*;
import java.util.*;

//Boj 2195 gold5
public class Solution {
    static int N, M, K, ans;
    static int pi(String a) {
        return Integer.parseInt(a);
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String S = br.readLine();
        String P = br.readLine();
        Set<String> s = new HashSet<>();
        for(int i=0; i<S.length(); ++i) {
            for(int j=i+1; j<S.length()+1; ++j) {
                s.add(S.substring(i,j));
            }
        }
        int idx = 0;
        for(int i=0; i<P.length(); ++i) {
            if(s.contains(P.substring(idx,i+1))) {
                continue;
            }
            else {
                ++ans;
                idx = i;
            }
        }

        System.out.println(++ans);
    }

}