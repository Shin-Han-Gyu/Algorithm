import java.io.*;
import java.util.*;

//Boj 2664 silver2
public class Main {
    static int K, N, M, ans, chk;

    static int[] dx = {0, 0, -1, 1, -1, 1, -1, 1}; //상 하 좌 우 대각선
    static int[] dy = {1, -1, 0, 0, -1, 1, 1, -1};
    static int[][] map;
    static int[] chon;
    static boolean[] visited;
    static boolean flag;
    static int pi(String a) {
        return Integer.parseInt(a);
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = pi(br.readLine());
        map = new int[N][N];
        visited = new boolean[N];
        String[] temp = br.readLine().split(" ");
        chon = new int[2];
        chon[0] = pi(temp[0])-1;
        chon[1] = pi(temp[1])-1;

        M = pi(br.readLine());

        for(int i=0; i<M; ++i) {
            temp =  br.readLine().split(" ");
            map[pi(temp[0])-1][pi(temp[1])-1] = 1;
            map[pi(temp[1])-1][pi(temp[0])-1] = 1;
        }
        ans = -1;
        for(int i=0; i<N; ++i) {
            if(map[chon[0]][i] == 1) {
                visited[chon[0]] = true;
                visited[i] = true;
                solve(i, 1);
            }
        }
        System.out.println(ans);

    }

    static void solve(int y, int chk) {
        if(chon[1] == y) {
            ans = chk;
            return;
        }

        for(int i=0; i<N; ++i) {
            if(map[y][i] == 1 && !visited[i]) {
                visited[i] = true;
                solve(i, chk+1);
                visited[i] = false;
            }
        }
    }

    static boolean oob(int x, int y) {
        return (x<0 || y<0 || x>=N || y>=N);
    }
}