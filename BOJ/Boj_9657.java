import java.io.*;
import java.util.*;

//Boj 9657 silver3
public class Solution {
    static int K, N, M, ans;
    static int pi(String a) {
        return Integer .parseInt(a);
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        double c = Double.parseDouble(br.readLine());

        //7로 나눈 나머지가 0, 2인 경우만 상근이가 진다
        if(c%7==0 || c%7==2) {
            System.out.println("CY");
        }
        else {
            System.out.println("SK");
        }

    }

}