import java.io.*;
import java.util.*;

//Boj 1012 silver2
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
        int T = pi(br.readLine());

        for(int t=0; t<T; ++t) {
            String[] temp = br.readLine().split(" ");

            M = pi(temp[0]);
            N = pi(temp[1]);
            K = pi(temp[2]);
            ans = 0;
            map = new int[M][N];
            visited = new boolean[M][N];
            for(int k=0; k<K; ++k) {
                temp =  br.readLine().split(" ");
                map[pi(temp[0])][pi(temp[1])] = 1;
            }

            for(int i=0; i<M; ++i) {
                for(int j=0; j<N; ++j) {
                    if(map[i][j] == 1 &&  !visited[i][j]) {
                        dfs(i, j);
                        ++ans;
                    }
                }
            }

            System.out.println(ans);
        }
    }

    static void dfs(int x, int y) {
        visited[x][y] = true;

        for(int i=0; i<4; ++i) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if(nx >= 0 && ny >= 0 && nx < M && ny < N) {
                if(map[nx][ny]==1 && !visited[nx][ny]) {
                    visited[nx][ny] = true;
                    dfs(nx, ny);
                }
            }
        }
    }

}