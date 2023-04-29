import java.io.*;
import java.util.*;

//Boj 2230 gold5
public class Solution {
    static int T, N, M, ans;
    static int[] parents;
    static int pi(String a) {
        return Integer.parseInt(a);
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] temp = br.readLine().split(" ");

        N = pi(temp[0]);
        M = pi(temp[1]);
        int[] num = new int[N];

        for(int i=0; i<N; ++i) {
            num[i] = pi(br.readLine());
        }
        ans = Integer.MAX_VALUE;
        Arrays.sort(num);
        int idx_left = 0;
        int idx_right = 1;
        while(idx_right<N) {
            if(num[idx_right]-num[idx_left]==M) {
                ans = M;
                break;
            }
            if(num[idx_right]-num[idx_left]<M) {
                ++idx_right;
                continue;
            }

            ans = Math.min(ans, num[idx_right]-num[idx_left]);
            ++idx_left;

        }
        System.out.println(ans);
    }


}
