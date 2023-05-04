import java.io.*;
import java.util.*;

//Boj 2877 gold5
public class Solution {
    static int N, M, ans;
    static int[] parents;
    static int pi(String a) {
        return Integer.parseInt(a);
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long K = Long.parseLong(br.readLine());

        System.out.println(Long.toBinaryString(K+1).substring(1).replaceAll("0","4").replaceAll("1","7"));

    }

}