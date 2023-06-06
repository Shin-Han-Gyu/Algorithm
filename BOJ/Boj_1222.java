import java.io.*;
import java.util.*;

//Boj 1222 gold2
public class Solution {
    static int N, M, T, ans, limit = 2000001;
    static int[] student = new int[limit];
    static int pi(String a) {
        return Integer.parseInt(a);
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        N = pi(br.readLine());
        String[] temp = br.readLine().split(" ");
        long Ans = 0;
        for(int i=0; i<N; ++i) {
            ++student[pi(temp[i])];
        }

        for(int i=1; i<limit; ++i) {
            long cnt = 0;
            for(int j=i; j<limit; j+=i) {
                cnt += student[j];
            }
            if(cnt>1) {
                Ans = Math.max(Ans, cnt*i);
            }
        }
        System.out.println(Ans);
    }

}