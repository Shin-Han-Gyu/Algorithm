import java.io.*;
import java.util.*;

//Boj 2468 silver1
public class Main {
    static int K, N, M, ans;

    static int[] dx = {0, 0, -1, 1}; //상 하 좌 우
    static int[] dy = {1, -1, 0, 0};
    static int[][] map;
    static boolean[][] visited;
    static int pi(String a) {
        return Integer.parseInt(a);
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = pi(br.readLine());
        map = new int[N][N];
        ans = 1;
        for(int i=0; i<N; ++i) {
            String[] temp = br.readLine().split(" ");
            for(int j=0; j<N; ++j) {
                map[i][j] = pi(temp[j]);
                K = Math.max(K, pi(temp[j]));
            }
        }
        for(int k=1; k<K; ++k) {
            visited = new boolean[N][N];
            int chk = 0;
            for(int i=0; i<N; ++i) {
                for(int j=0; j<N; ++j) {
                    if(map[i][j]>k && !visited[i][j]) {
                        visited[i][j] = true;
                        solve(i, j, k);
                        ++chk;
                    }
                }
            }
            ans = Math.max(ans, chk);
        }
        System.out.println(ans);
    }

    static void solve(int x, int y, int k) {
        visited[x][y] = true;

        for(int i=0; i<4; ++i) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(!oob(nx, ny) && map[nx][ny] > k && !visited[nx][ny]) {
                solve(nx, ny, k);
            }
        }
    }

    static boolean oob(int x, int y) {
        return (x<0 || y<0 || x>=N || y>=N);
    }
}