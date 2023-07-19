import java.io.*;
import java.util.*;

//Boj 9656 silver3
public class Solution {
    static int K, N, M, ans;
    static long Ans;
    static int pi(String a) {
        return Integer .parseInt(a);
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        Ans = Long.parseLong(br.readLine());



        System.out.println(Ans%2==1 ? "SK" : "CY");
    }

}