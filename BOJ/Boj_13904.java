import java.io.*;
import java.util.*;

//Boj 13904 gold3
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
        int[][] hw = new int[N][2];
        int max = 0;
        for(int i=0; i<N; ++i) {
            String[] temp = br.readLine().split(" ");
            hw[i][0] = pi(temp[0]);
            hw[i][1] = pi(temp[1]);

            max = Math.max(max, pi(temp[0]));
        }

        Arrays.sort(hw, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[1]==o2[1]) {
                    return o1[0]-o2[0];
                }
                return o2[1]-o1[1];
            }
        });

        boolean[] chk = new boolean[N];

        for(int i=max; i>0; --i) {
            for(int j=0; j<N; ++j) {
                if(!chk[j] && hw[j][0] > i-1) {
                    ans += hw[j][1];
                    chk[j] = true;
                    break;
                }
            }
        }
        System.out.println(ans);

    }


}