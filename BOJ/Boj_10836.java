import java.io.*;
import java.util.*;

//Boj 10836 gold4
public class Solution {
    static int N, M, K, ans;
    static int pi(String a) {
        return Integer.parseInt(a);
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String[] temp = br.readLine().split(" ");
        M = pi(temp[0]);
        N = pi(temp[1]);
        int[][] map = new int[M][M];

        for(int i=0; i<M; ++i) {
            Arrays.fill(map[i], 1);
        }

        for(int i=0; i<N; ++i) {
            temp = br.readLine().split(" ");
            int[] grow = new int[]{pi(temp[0]), pi(temp[1]), pi(temp[2])};
            for(int j=M-1; j>0; --j) {
                if(grow[0]!=0) {
                    --grow[0];
                }
                else if(grow[1]!=0) {
                    --grow[1];
                    ++map[j][0];
                }
                else if(grow[2]!=0) {
                    --grow[2];
                    map[j][0] +=2;
                }
            }

            for(int j=0; j<M; ++j) {
                if(grow[0]!=0) {
                    --grow[0];
                }
                else if(grow[1]!=0) {
                    --grow[1];
                    ++map[0][j];
                }
                else if(grow[2]!=0) {
                    --grow[2];
                    map[0][j] +=2;
                }
            }
        }
        for(int i=1; i<M; ++i) {
            for(int j=1; j<M; ++j)
                map[i][j] = Math.max(map[i-1][j], Math.max(map[i-1][j-1], map[i][j-1]));
        }

        for(int i=0; i<M; ++i) {
            for(int j=0; j<M; ++j) {
                sb.append(map[i][j] + " ");
            }
            sb.append("\n");
        }
        System.out.print(sb);

    }

}