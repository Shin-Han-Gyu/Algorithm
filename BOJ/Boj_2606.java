import java.io.*;
import java.util.*;

//Boj 2606 silver3
public class Main {
    static int K, N, M, ans, chk;

    static int[] dx = {0, 0, -1, 1, -1, 1, -1, 1}; //상 하 좌 우 대각선
    static int[] dy = {1, -1, 0, 0, -1, 1, 1, -1};
    static int[][] map;
    static boolean[] visited;
    static boolean flag;
    static int pi(String a) {
        return Integer.parseInt(a);
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = pi(br.readLine());
        map = new int[N][N];
        M = pi(br.readLine());
        visited = new boolean[N];

        for(int i=0; i<M; ++i) {
            String[] temp =  br.readLine().split(" ");
            map[pi(temp[0])-1][pi(temp[1])-1] = 1;
            map[pi(temp[1])-1][pi(temp[0])-1] = 1;
        }
        visited[0] = true;
        solve(0);
        System.out.println(ans);

    }

    static void solve(int x) {
        for(int i=0; i<N; ++i) {
            if(!visited[i] && map[x][i] == 1) {
                visited[i] = true;
                ++ans;
                solve(i);
            }
        }
    }

    static boolean oob(int x, int y) {
        return (x<0 || y<0 || x>=N || y>=N);
    }
}