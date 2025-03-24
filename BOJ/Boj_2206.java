import java.io.*;
import java.util.*;

//Boj 2206 gold3
public class Main {
    static int K, N, M, ans, chk;

    static int[] dx = {0, 0, -1, 1, -1, 1, -1, 1}; //상 하 좌 우 대각선
    static int[] dy = {1, -1, 0, 0, -1, 1, 1, -1};
    static int[][] map, len;
    static boolean[][][] visited;
    static boolean flag;
    static int pi(String a) {
        return Integer.parseInt(a);
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] temp =  br.readLine().split(" ");
        N = pi(temp[0]);
        M = pi(temp[1]);
        if(N==1 && M==1){
            System.out.println(1);
            return;
        }

        map = new int[N][M];
        len = new int[N][M];
        visited = new boolean[2][N][M];
        Queue<int[]> q = new LinkedList<>();
        for(int i=0; i<N; ++i) {
            String temp_ = br.readLine();
            for(int j=0; j<M; ++j) {
                map[i][j] = temp_.charAt(j)-48;
            }
        }

        q.add(new int[] {0, 0, 0});

        while(!q.isEmpty()) {
            int[] cur = q.poll();

            for(int i=0; i<4; ++i) {
                int nx = cur[0] + dx[i];
                int ny = cur[1] + dy[i];
                if(oob(nx, ny)) continue;

                if(map[nx][ny]==1) {
                    if(cur[2] == 0 && !visited[1][nx][ny]) {
                        visited[0][nx][ny] = true;
                        len[nx][ny] = len[cur[0]][cur[1]] + 1;
                        q.add(new int[] {nx, ny, 1});
                    }
                }
                else {
                    if(!visited[cur[2]][nx][ny]) {
                        visited[cur[2]][nx][ny] = true;
                        len[nx][ny] = len[cur[0]][cur[1]] + 1;
                        q.add(new int[] {nx, ny, cur[2]});
                    }
                }

                if(nx == N-1 && ny == M-1) {
                    System.out.println(len[nx][ny]+1);
                    return;
                }
            }
        }
        System.out.println(-1);



    }

    static boolean oob(int x, int y) {
        return (x<0 || y<0 || x>=N || y>=M);
    }
}