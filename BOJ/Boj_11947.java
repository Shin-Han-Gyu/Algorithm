import java.io.*;
import java.util.*;

//Boj 11947 silver3
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

        T = pi(br.readLine());
        for(int t=0; t<T; ++t) {
            String temp = br.readLine();
            int length = temp.length();
            long N = Long.parseLong(temp);

            long half = (long) Math.pow(10, length) / 2;
            if(N >= half) {
                N = half;
            }

            long result = N * ((long) Math.pow(10, length) - 1 - N);
            System.out.println(result);

        }

    }

    static boolean oob(int x, int y) {
        return (x<0 || y<0 || x>=M || y>=N);
    }
}