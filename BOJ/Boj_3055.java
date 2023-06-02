import java.io.*;
import java.util.*;
import java.util.Arrays;

//Boj 3055 gold4
public class Solution {
    static int N, M, K, ans;
    static int[] dx = {0,1,0,-1};
    static int[] dy = {1,0,-1,0};
    static char[][] map;
    static boolean[][] visit;
    static Queue<int[]> water = new LinkedList<>();
    static Queue<int[]> hed = new LinkedList<>();
    static int pi(String a) {
        return Integer.parseInt(a);
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String[] temp = br.readLine().split(" ");
        N = pi(temp[0]);
        M = pi(temp[1]);
        map = new char[N][M];
        visit = new boolean[N][M];

        for(int i=0; i<N; ++i) {
            String t = br.readLine();
            for(int j=0; j<M; ++j) {
                map[i][j] = t.charAt(j);
                if(map[i][j]=='*') {
                    water.add(new int[]{i, j});
                    visit[i][j] = true;
                }
                if(map[i][j]=='S') {
                    hed.add(new int[]{i, j});
                    visit[i][j] = true;
                }
            }
        }
        solve();

        if(ans==-1) {
            System.out.println("KAKTUS");
        }
        else {
            System.out.println(ans);
        }
    }

    static boolean oob(int x, int y) {
        return (x<0 || y<0 || x>N-1 || y>M-1);
    }

    static void solve() {
        int chk = 1;
        while(true) {
            int w_len = water.size();
            for(int w=0; w<w_len; ++w) {
                int[] temp = water.poll();

                for(int i=0; i<4; ++i) {
                    int temp_x = temp[0] + dx[i];
                    int temp_y = temp[1] + dy[i];

                    if(oob(temp_x, temp_y)) {
                        continue;
                    }

                    if(map[temp_x][temp_y]=='.') {
                        map[temp_x][temp_y] = '*';
                        water.add(new int[]{temp_x, temp_y});
                    }
                }
            }
            int h_len = hed.size();
            if(h_len==0) {
                ans = -1;
                return;
            }
            for(int h=0; h<h_len; ++h) {
                int[] temp = hed.poll();

                for(int i=0; i<4; ++i) {
                    int temp_x = temp[0] + dx[i];
                    int temp_y = temp[1] + dy[i];

                    if(oob(temp_x, temp_y)) {
                        continue;
                    }

                    if(map[temp_x][temp_y]=='D') {
                        ans = chk;
                        return;
                    }
                    if(map[temp_x][temp_y]=='.' && !visit[temp_x][temp_y]) {
                        visit[temp_x][temp_y] = true;
                        hed.add(new int[]{temp_x, temp_y});
                    }
                }
            }
            ++chk;
        }
    }
}
