import java.io.*;
import java.util.*;

//Boj 2583 silver1
public class Main {
    static int K, N, M, ans, chk;

    static int[] dx = {0, 0, -1, 1}; //상 하 좌 우
    static int[] dy = {1, -1, 0, 0};
    static int[][] map;
    static boolean[][] visited;
    static ArrayList<Integer> arr = new ArrayList<>();
    static int pi(String a) {
        return Integer.parseInt(a);
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] temp = br.readLine().split(" ");
        M = pi(temp[0]);
        N = pi(temp[1]);
        K = pi(temp[2]);

        map = new int[M][N];
        visited = new boolean[M][N];

        for(int k=0; k<K; ++k) {
            temp = br.readLine().split(" ");
            int x1 = pi(temp[0]);
            int y1 = pi(temp[1]);
            int x2 = pi(temp[2]);
            int y2 = pi(temp[3]);

            for(int i=y1; i<y2; ++i) {
                for(int j=x1; j<x2; ++j) {
                    map[i][j] = 1;
                }
            }
        }

        for(int i=0; i<M; ++i) {
            for(int j=0; j<N; ++j) {
                if(map[i][j] == 0 && !visited[i][j]) {
                    chk = 1;
                    solve(i, j);
                    arr.add(chk);
                }
            }
        }
        Collections.sort(arr);
        System.out.println(arr.size());
        for(int i : arr) {
            System.out.print(i + " ");
        }


    }

    static void solve(int x, int y) {
        visited[x][y] = true;

        for(int i=0; i<4; ++i) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(!oob(nx, ny) && map[nx][ny] == 0 && !visited[nx][ny]) {
                ++chk;
                solve(nx, ny);
            }
        }
    }

    static boolean oob(int x, int y) {
        return (x<0 || y<0 || x>=M || y>=N);
    }
}