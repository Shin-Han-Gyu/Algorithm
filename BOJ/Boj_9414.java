import java.io.*;
import java.util.*;

//Boj 9414 silver4
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
        System.out.println("\n\n");
        for(int t=0; t<T; ++t) {
            int money = 5*1000000;
            ans = 0;
            ArrayList<Integer> arr = new ArrayList<>();
            int temp = pi(br.readLine());
            while(temp!=0) {
                arr.add(temp);
                temp = pi(br.readLine());
            }

            Collections.sort(arr, Collections.reverseOrder());
            
            for(int i=0; i<arr.size(); ++i) {
                ans += 2*Math.pow(arr.get(i),i+1);
                System.out.println("----- " + ans);

                if(ans>money) {
                    System.out.println("Too expensive");
                    break;
                }
            }
            if(ans<=money) {
                System.out.println(ans);
            }
        }  
        

    }

    static boolean oob(int x, int y) {
        return (x<0 || y<0 || x>=M || y>=N);
    }
}