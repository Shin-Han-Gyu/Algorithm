 import java.io.*;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

//Boj 10026 gold5
public class Main {
    static int N, M, K, ans;
    static boolean[][] visit;
    static int[] dx = {0,1,0,-1};
    static int[] dy = {1,0,-1,0};
    static char[][] map;
    static int pi(String a) {
        return Integer.parseInt(a);
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = pi(br.readLine());
        StringBuilder sb = new StringBuilder();
        map = new char[N][N];
        for(int i=0; i<N; ++i) {
            String temp = br.readLine();
            for(int j=0; j<N; ++j) {
                map[i][j] = temp.charAt(j);
            }
        }
        visit = new boolean[N][N];
        for(int i=0; i<N; ++i) {
            for(int j=0; j<N; ++j) {
                if(!visit[i][j]) {
                    solve(i, j, map[i][j]);
                }
            }
        }
        sb.append(ans + " ");
        ans = 0;
        visit = new boolean[N][N];
        for(int i=0; i<N; ++i) {
            for(int j=0; j<N; ++j) {
                if(!visit[i][j]) {
                    solve1(i, j, map[i][j]);
                }
            }
        }
        sb.append(ans);
        System.out.println(sb);
    }
    static void solve(int x, int y, char chk) {
        ++ans;
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{x,y});
        visit[x][y] = true;
        while(!q.isEmpty()) {
            int[] temp = q.poll();

            for(int i=0; i<4; ++i) {
                int temp_x = temp[0] + dx[i];
                int temp_y = temp[1] + dy[i];
                if(!oob(temp_x, temp_y) && !visit[temp_x][temp_y] && map[temp_x][temp_y]==chk) {
                    q.add(new int[]{temp_x, temp_y});
                    visit[temp_x][temp_y] = true;
                }
            }
        }
    }
    static void solve1(int x, int y, char chk) {
        ++ans;
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{x,y});
        visit[x][y] = true;
        while(!q.isEmpty()) {
            int[] temp = q.poll();

            for(int i=0; i<4; ++i) {
                int temp_x = temp[0] + dx[i];
                int temp_y = temp[1] + dy[i];
                if(!oob(temp_x, temp_y) && !visit[temp_x][temp_y]) {
                    if(((chk == 'R' || chk == 'G') && (map[temp_x][temp_y] == 'R' || map[temp_x][temp_y] == 'G')) ||
                            map[temp_x][temp_y]==chk) {
                        q.add(new int[]{temp_x, temp_y});
                        visit[temp_x][temp_y] = true;
                    }

                }
            }
        }
    }

    static boolean oob(int x, int y) {
        return (x<0 || y<0 || x>N-1 || y>N-1);
    }

}