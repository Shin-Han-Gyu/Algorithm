import java.io.*;
import java.util.*;

//Boj 2437 gold2
public class Solution {
    static int K, N, M, ans;
    static int[] statue;
    static int pi(String a) {
        return Integer .parseInt(a);
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        N = pi(br.readLine());

        statue = new int[N];
        String[] temp = br.readLine().split(" ");

        for(int i=0; i<N; ++i) {
            statue[i] = pi(temp[i]);
        }
        Arrays.sort(statue);

        long cnt = 0;
        long Ans = 0;

        for(int i=0; i<N-1; ++i) {
            cnt += statue[i];

            if((cnt+1) < statue[i+1]) {
                Ans = cnt+1;
                break;
            }
        }

        if(statue[0]>1) {
            Ans = 1;
        }
        else if(Ans==0) {
            Ans = cnt + statue[N-1] + 1;
        }

        System.out.println(Ans);

    }

}