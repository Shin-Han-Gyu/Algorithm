import java.io.*;
import java.math.*;
import java.util.*;

//Boj 11509 gold5
public class Solution {
    static int N, M, K, ans;
    static int pi(String a) {
        return Integer.parseInt(a);
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = pi(br.readLine());
        int[] arrows = new int[N];
        String[] temp = br.readLine().split(" ");
        for(int i=0; i<N; ++i) {
            arrows[i] = pi(temp[i]);
        }
        for(int i=0; i<N; ++i) {
            int chk = arrows[i];
            if(chk==-1) {
                continue;
            }
            ++ans;
            --chk;
            int idx = i+1;
            arrows[i] = -1;
            while(idx!=N) {
                if(arrows[idx]==chk) {
                    arrows[idx] = -1;
                    --chk;
                }
                ++idx;
            }
        }
        System.out.println(ans);

    }

}