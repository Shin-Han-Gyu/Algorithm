import java.io.*;

//Boj 1407 gold4
public class Solution {
    static int N, M, K, ans;
    static int pi(String a) {
        return Integer.parseInt(a);
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] temp = br.readLine().split(" ");
        long A = Long.parseLong(temp[0]), B = Long.parseLong(temp[1]);

        System.out.println(func(B) - func(A-1));

    }

    static long func(long x) {
        long ret = x;
        for(long i=2; i<x+1; i*=2) {
            ret += (x/i)*(i/2);
        }
        return ret;
    }

}