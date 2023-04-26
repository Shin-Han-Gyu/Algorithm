import java.io.*;
import java.util.Collections;

//Boj 1464 gold4
public class Solution {
    static int K, N, M, ans;
    static int[][] map;
    static boolean[][] bulbs;
    static int pi(String a) {
        return Integer.parseInt(a);
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String S = br.readLine();

        String temp = "" + S.charAt(0);
        for(int i=1; i<S.length(); ++i) {
            if(temp.charAt(i-1)<S.charAt(i)) {
                temp = S.charAt(i) + temp;
            }
            else {
                temp = temp + S.charAt(i);
            }
        }

        StringBuilder sb = new StringBuilder();
        sb.append(temp);
        System.out.println(sb.reverse());


    }


}