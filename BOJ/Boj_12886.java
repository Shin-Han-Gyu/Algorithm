import java.io.*;
import java.util.*;

//Boj 12886 gold4
public class Solution {
    static int K, N, M, ans;
    static int pi(String a) {
        return Integer .parseInt(a);
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String[] temp = br.readLine().split(" ");
        int A = pi(temp[0]), B = pi(temp[1]), C = pi(temp[2]);
        boolean[][] visit = new boolean[1501][1501];
        int chk = A+B+C;
        if(chk%3!=0) {
            System.out.println(0);
            return;
        }

        Queue<int[]> q = new LinkedList<>();
        visit[A][B] = true;
        q.add(new int[]{A,B,C});

        while(!q.isEmpty()) {
            int[] t = q.poll();

            for(int i=0; i<3; ++i) {
                for(int j=0; j<3; ++j) {
                    if(t[i]<t[j] && !visit[t[i]*2][t[j]-t[i]]) {
                        int temp_x = t[i]*2;
                        int temp_y = t[j]-t[i];

                        visit[temp_x][temp_y] = true;
                        q.add(new int[]{temp_x, temp_y, chk-temp_x-temp_y});
                    }
                }
            }
        }

        if(visit[chk/3][chk/3]) {
            System.out.println(1);
        }
        else {
            System.out.println(0);
        }
    }

}