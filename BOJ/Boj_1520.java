import java.io.*;

//Boj 1520 gold3
public class Solution {
    static int N, M, K, ans;
    static int[] dx = {0,1,0,-1};
    static int[] dy = {1,0,-1,0};
    static int[][] map, way;
    static int pi(String a) {
        return Integer.parseInt(a);
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String[] temp = br.readLine().split(" ");
        N = pi(temp[0]);
        M = pi(temp[1]);
        way = new int[N][M];
        map = new int[N][M];
        for(int i=0; i<N; ++i) {
            temp = br.readLine().split(" ");
            for(int j=0; j<M; ++j) {
                map[i][j] = pi(temp[j]);
                way[i][j] = -1;
            }
        }
        System.out.println(solve(0,0));

    }

    static boolean oob(int x, int y) {
        return (x<0 || y<0 || x>N-1 || y>M-1);
    }

    static int solve(int x, int y) {
        if(x==N-1 && y==M-1) {
            return 1;
        }
        if(way[x][y]!=-1) {
            return way[x][y];
        }

        way[x][y] = 0;
        for(int i=0; i<4; ++i) {
            int temp_x = x+dx[i];
            int temp_y = y+dy[i];

            if(oob(temp_x, temp_y)) {
                continue;
            }

            if(map[temp_x][temp_y]<map[x][y]) {
                way[x][y] += solve(temp_x, temp_y);
            }
        }

        return way[x][y];

    }

}
