import java.io.*;
import java.util.*;

//Boj 18311 silver5
public class Main {
    static int K, N, M, T, ans, chk;

    static int[] dx = {0, 0, -1, 1, -1, 1, -1, 1}; //상 하 좌 우 대각선
    static int[] dy = {1, -1, 0, 0, -1, 1, 1, -1};
    static int[][] map;
    static boolean[][] visited;
    static boolean flag;
    static int pi(String a) {
        return Integer.parseInt(a);
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] temp = br.readLine().split(" ");
        N = pi(temp[0]);
        long KK = Long.parseLong(temp[1]);

        temp = br.readLine().split(" ");
        long chk = 0;
        for(int i=0; i<N*2; ++i) {
            if(i>N-1) {
                chk += pi(temp[2*N-1-i]);
            }
            else {
                chk += pi(temp[i]);
            }
            if(chk>KK) {
                System.out.println(i>N-1 ? 2*N-i : i+1);
                break;
            }
        }
        

    }

    static boolean oob(int x, int y) {
        return (x<0 || y<0 || x>=M || y>=N);
    }
}