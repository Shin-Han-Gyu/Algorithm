import java.io.*;
import java.util.*;

//Boj 11735 gold4
public class Solution {
    static int N, M, K, ans;
    static int pi(String a) {
        return Integer.parseInt(a);
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String[] temp = br.readLine().split(" ");

        N = pi(temp[0]);
        M = pi(temp[1]);
        long R_sum = N * (long) (N + 1) / 2;
        long C_sum = N * (long) (N + 1) / 2;
        long R_num = N;
        long C_num = N;

        boolean[][] visit = new boolean[2][N+1];
        for(int i=0; i<M; ++i) {
            temp = br.readLine().split(" ");
            int val = pi(temp[1]);
            if(temp[0].equals("R")) {
                if(visit[0][val]) {
                    sb.append(0 + "\n");
                    continue;
                }
                visit[0][val] = true;
                --R_num;
                R_sum -= val;
                sb.append((C_num*val + C_sum) + "\n");
            }
            else {
                if(visit[1][val]) {
                    sb.append(0 + "\n");
                    continue;
                }
                visit[1][val] = true;
                --C_num;
                C_sum -= val;
                sb.append((R_num*val + R_sum) + "\n");
            }
        }
        System.out.print(sb);

    }

}