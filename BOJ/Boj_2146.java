import java.io.*;
import java.util.*;

//Boj 2146 gold3
public class Main {
    static int K, N, M, ans, chk;

    static int[] dx = {0, 0, -1, 1, -1, 1, -1, 1}; //상 하 좌 우
    static int[] dy = {1, -1, 0, 0, -1, 1, 1, -1}; //대각선
    static int[][] map, chked;
    static boolean[][] visited;
    static boolean flag;
    static int pi(String a) {
        return Integer.parseInt(a);
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = pi(br.readLine());
        map = new int[N][N];
        visited = new boolean[N][N];

        for(int i=0; i<N; ++i) {
            String[] temp = br.readLine().split(" ");
            for(int j=0; j<N; ++j) {
                map[i][j] = pi(temp[j]);
            }
        }
        ans = 1;
        for(int i=0; i<N; ++i) {
            for(int j=0; j<N; ++j) {
                if(map[i][j]!=0 && !visited[i][j]) {
                    map[i][j] = ans;
                    solve(i, j);
                    ++ans;
                }
            }
        }
        ans = 100001;

        for(int i=0; i<N; ++i) {
            for(int j=0; j<N; ++j) {
                if(map[i][j]>0) {
                    bridge(i, j, map[i][j]);
                }
            }
        }
        System.out.println(ans);

    }

    static void solve(int x, int y) {
        visited[x][y] = true;

        for(int i=0; i<4; ++i) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(!oob(nx, ny) && map[nx][ny]!=0 && !visited[nx][ny]) {
                map[nx][ny] = ans;
                solve(nx, ny);
            }
        }
    }

    static void bridge(int x, int y, int number) {
        Queue<Integer[]> queue=new LinkedList<>();
        visited = new boolean[N][N];
        visited[x][y] = true;
        queue.add(new Integer[] {x,y,0});

        while(!queue.isEmpty()) {
            Integer[] temp = queue.poll();
            int temp_x = temp[0];
            int temp_y = temp[1];
            int temp_cnt = temp[2];

            if(map[temp_x][temp_y] !=0 && map[temp_x][temp_y] != number) {
                ans = Math.min(ans, temp_cnt - 1);
            }
            if(temp_cnt>ans) return;

            for(int i=0;i<4;i++) {
                int nx = temp_x + dx[i];
                int ny = temp_y + dy[i];
                if(oob(nx, ny)) continue;
                if(map[nx][ny] == number) continue;
                if(visited[nx][ny]) continue;

                queue.add(new Integer[] {nx,ny,temp_cnt+1});
                visited[nx][ny]=true;
            }

        }
    }

    static boolean oob(int x, int y) {
        return (x<0 || y<0 || x>=N || y>=N);
    }
}