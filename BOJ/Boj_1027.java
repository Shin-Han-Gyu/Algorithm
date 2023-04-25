import java.io.*;

//Boj 1027 Gold4
public class Solution {
    static int P, N, M, ans;
    static boolean[][] chk;
    static int[][] map;
    static int[] price;
    static int pi(String a) {
        return Integer.parseInt(a);
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = pi(br.readLine());
        int[] buildings = new int[N];
        String[] temp = br.readLine().split(" ");
        for(int i=0; i<N; ++i) {
            buildings[i] = pi(temp[i]);
        }
        int ans = 0;
        chk = new boolean[N][N];
        for(int i=0; i<N; ++i) {
            ans = Math.max(ans, chk(i, buildings));
        }
        System.out.println(ans);

    }

    static int chk(int idx, int[] buildings) {
        long tx = 1;
        long ty = Long.MIN_VALUE;
        int cnt = 0;

        for(int j =idx+1; j<N; ++j){
            long dx = j - idx;
            long dy = buildings[j] - buildings[idx];

            if(ty * dx < dy * tx){
                tx = dx;
                ty = dy;
                chk[idx][j] = true;
                cnt++;
            }
        }

        for(int j=0; j<idx; ++j){
            if(chk[j][idx]) {++cnt;};
        }

        return cnt;
    }

}