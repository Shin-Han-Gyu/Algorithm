import java.io.*;
import java.util.*;

//Boj 1112 gold2
public class Solution {
    static int T, N, M;
    static int[][] map;

    static int pi(String a) {
        return Integer.parseInt(a);
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] temp = br.readLine().split(" ");
        N = pi(temp[0]);
        M = pi(temp[1]);
        if(N==0) {
            System.out.println(0);
            System.exit(0);
        }
        if(M>0) {
            System.out.println(Integer.toString(N, M));
            System.exit(0);
        }

        String ans = "";
        while(N!=0) {
            int temp_ = N%-M;
            if(temp_<0) {
                temp_ -= M;
            }
            N = (N-temp_)/M;
            ans = temp_ + ans;
        }
        System.out.println(ans);

    }

}