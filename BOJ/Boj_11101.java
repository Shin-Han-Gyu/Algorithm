import java.io.*;
import java.util.*;

//Boj 11101 silver2
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
            String[] temp = br.readLine().split(",");
            HashMap<String, Integer> map = new HashMap<>();

            for(String string : temp) {
                String[] s = string.split(":");
                map.put(s[0], pi(s[1]));
            }
            ans = 1001;
            temp =  br.readLine().split("\\|");
            for(String string : temp) {
                int chk = -1;
                String[] s = string.split("&");
                for(String string2 : s) {
                    chk = Math.max(chk, map.get(string2));
                }
                ans = Math.min(ans, chk);
            }
            System.out.println(ans);

        }

    }

    static boolean oob(int x, int y) {
        return (x<0 || y<0 || x>=M || y>=N);
    }
}