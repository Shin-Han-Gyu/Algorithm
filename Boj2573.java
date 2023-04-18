import java.io.*;
import java.util.*;

//Boj 2573 Gold4
public class Solution {
    static int[][] map;
    static int[] dx = {0,1,0,-1};
    static int[] dy = {1,0,-1,0};
    static boolean[][] visit;
    static int N, M;
    static ArrayList<int[]> a;
    static int pi(String a) {
        return Integer.parseInt(a);
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] temp = br.readLine().split(" ");

        N = pi(temp[0]);
        M = pi(temp[1]);
        map = new int[N][M];
        visit = new boolean[N][M];
        for(int i=0; i<N; ++i) {
            temp = br.readLine().split(" ");
            for(int j=0; j<M; ++j) {
                map[i][j] = pi(temp[j]);
            }
        }
        boolean flag = true;
        int ans = 0;
        while(flag) {
            a = new ArrayList<>();
            visit = new boolean[N][M];

            int t = 0;
            boolean chk = true;
            for(int i=0; i<N; ++i) {
                for(int j=0; j<M; ++j) {
                    if(!visit[i][j] && map[i][j]!=0) {
                        ++t;
                        chk = false;
                        visit[i][j] = true;
                        a.add(new int[]{i, j, melt(i,j)});
                        solve(i,j);
                    }
                }
            }
            if(t>1) {
                break;
            }
            if(chk) {
                ans = 0;
                break;
            }
            for(int[] i : a) {
                if(map[i[0]][i[1]]<i[2]) {
                    map[i[0]][i[1]] = 0;
                }
                else {
                    map[i[0]][i[1]] -= i[2];
                }
            }
            ++ans;
        }

        System.out.println(ans);

    }

    static void solve(int x, int y) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{x, y});

        while(!q.isEmpty()) {
            int[] temp = q.poll();

            for(int i=0; i<4; ++i) {
                int temp_x = temp[0] + dx[i];
                int temp_y = temp[1] + dy[i];

                if(!oob(temp_x, temp_y) && map[temp_x][temp_y]!=0 && !visit[temp_x][temp_y]) {
                    visit[temp_x][temp_y] = true;
                    a.add(new int[]{temp_x, temp_y, melt(temp_x, temp_y)});
                    q.add(new int[]{temp_x, temp_y});
                }
            }

        }

    }

    static boolean oob(int x, int y) {
        return (x<0 || y<0 || x>N-1 || y>M-1);
    }

    static int melt(int x, int y) {
        int ret = 0;

        for(int i=0; i<4; ++i) {
            int temp_x = x + dx[i];
            int temp_y = y + dy[i];

            if(!oob(temp_x, temp_y) && map[temp_x][temp_y]==0) {
                ++ret;
            }
        }

        return ret;
    }

}
