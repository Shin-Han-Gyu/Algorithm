import java.io.*;
import java.util.*;

//Boj 1240 Gold5
public class Solution {
    static int N, M, ans;
    static int[][] map;
    static int pi(String a) {
        return Integer.parseInt(a);
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] temp = br.readLine().split(" ");
        N = pi(temp[0]);
        M = pi(temp[1]);
        map = new int[N+1][N+1];
        for(int i=0; i<N-1; ++i) {
            temp = br.readLine().split(" ");

            map[pi(temp[0])][pi(temp[1])] = pi(temp[2]);
            map[pi(temp[1])][pi(temp[0])] = pi(temp[2]);
        }

        for(int i=0; i<M; ++i) {
            temp = br.readLine().split(" ");
            ans = Integer.MAX_VALUE;
            for(int j=1; j<N+1; ++j) {
                if(map[pi(temp[0])][j]>0) {
                    if(j == pi(temp[1])) {
                        ans = Math.min(ans, map[pi(temp[0])][j]);
                        continue;
                    }
                    boolean[] visit = new boolean[N+1];
                    visit[j] = true;
                    solve(j, pi(temp[1]), map[pi(temp[0])][j] ,visit);
                }
            }
            System.out.println(ans);

        }


    }

    static void solve(int x, int goal, int sum, boolean[] visit) {
        if(goal == x) {
            ans = Math.min(ans, sum);
            return;
        }

        for(int i=1; i<N+1; ++i) {
            if(!visit[i] && map[x][i]>0) {
                visit[i] = true;
                solve(i, goal, sum+map[x][i], visit);
                visit[i] = false;
            }
        }


    }


}