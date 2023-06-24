import java.io.*;
import java.util.*;

//Boj 4342 gold2
public class Solution {
    static int K, N, M, ans;
    static int pi(String a) {
        return Integer .parseInt(a);
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        while(true) {
            String[] temp = br.readLine().split(" ");
            int N = pi(temp[0]);
            int M = pi(temp[1]);

            if(N==0 && M==0) {
                break;
            }

            sb.append(GCD(N, M) ? "A wins\n" : "B wins\n");
        }
        System.out.print(sb);
    }

    static boolean GCD(int a, int b) {
        if(a>b) {
            int temp = a;
            a = b;
            b = temp;
        }

        if(b%a==0) {
            return true;
        }

        if (b-a<a) {
            return !GCD(b-a, a);
        }

        return true;
    }

}