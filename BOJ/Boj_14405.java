import java.io.*;
import java.util.*;

//Boj 14405 silver5
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

        String[] can = {"pi", "ka", "chu"};
        
        String temp = br.readLine();
        for(int i=0; i<3; ++i) {
            temp = temp.replace(can[i], "#");
        }
        temp = temp.replace("#", "");
        String ret;
        ret = temp.length()==0 ? "YES" : "NO";
        
        System.out.println(ret);
      
    }

    static boolean oob(int x, int y) {
        return (x<0 || y<0 || x>=M || y>=N);
    }
}