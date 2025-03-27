import java.io.*;
import java.util.*;

//Boj 4963 silver2
public class Main {
    static int K, N, M, ans, chk;

    static int[] dx = {0, 0, -1, 1, -1, 1, -1, 1}; //상 하 좌 우 대각선
    static int[] dy = {1, -1, 0, 0, -1, 1, 1, -1};
    static int[][] map;
    static boolean[][] visited;
    static boolean flag;
    static int pi(String a) {
        return Integer.parseInt(a);
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            String[] temp =  br.readLine().split(" ");
            N = pi(temp[0]);
            M = pi(temp[1]);
            if(N == 0 || M == 0){
                return;
            }
            map = new int[M][N];
            visited = new boolean[M][N];
            ans = 0;
            for(int i=0; i<M; ++i) {
                temp =  br.readLine().split(" ");

                for(int j=0; j<N; ++j) {
                    map[i][j] = pi(temp[j]);
                }
            }
            for(int i=0; i<M; ++i) {
                for(int j=0; j<N; ++j) {
                    if(!visited[i][j] && map[i][j] == 1) {
                        ++ans;
                        visited[i][j] = true;
                        solve(i, j);
                    }
                }
            }
            System.out.println(ans);

        }

    }

    static void solve(int x, int y) {
        for(int i=0; i<8; ++i) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(!oob(nx, ny) && map[nx][ny] == 1 && !visited[nx][ny]) {
                visited[nx][ny] = true;
                solve(nx, ny);
            }
        }
    }

    static boolean oob(int x, int y) {
        return (x<0 || y<0 || x>=M || y>=N);
    }
}