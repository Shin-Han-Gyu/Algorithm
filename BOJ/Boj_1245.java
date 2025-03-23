import java.io.*;
import java.util.*;

//Boj 1245 gold5
public class Main {
    static int K, N, M, ans, chk;

    static int[] dx = {0, 0, -1, 1, -1, 1, -1, 1}; //상 하 좌 우
    static int[] dy = {1, -1, 0, 0, -1, 1, 1, -1}; //대각선
    static int[][] map;
    static boolean[][] visited;
    static boolean flag;
    static int pi(String a) {
        return Integer.parseInt(a);
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] temp = br.readLine().split(" ");

        N = pi(temp[0]);
        M = pi(temp[1]);
        map = new int[N][M];
        visited = new boolean[N][M];

        int val = 0;
        for(int i=0; i<N; ++i) {
            temp =  br.readLine().split(" ");
            for(int j=0; j<M; ++j) {
                map[i][j] = pi(temp[j]);
            }
        }

        for(int i=0; i<N; ++i) {
            for(int j=0; j<M; ++j) {
                if(!visited[i][j]) {
                    flag = true;
                    solve(i, j);
                    if(flag) ++ans;
                }
            }
        }
        System.out.println(ans);

    }

    static void solve(int x, int y) {
        visited[x][y] = true;

        for(int i=0; i<8; ++i) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(!oob(nx, ny)) {
                if(map[x][y] < map[nx][ny]) flag = false;
                if(!visited[nx][ny] && map[x][y] == map[nx][ny]) {
                    visited[nx][ny] = true;
                    solve(nx, ny);
                }
            }
        }
    }

    static boolean oob(int x, int y) {
        return (x<0 || y<0 || x>=N || y>=M);
    }
}