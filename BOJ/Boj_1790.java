import java.io.*;
import java.util.*;

//Boj 1790 gold5
public class Main {
    static int N, M, ans;
    static int[] parents;
    static int pi(String a) {
        return Integer.parseInt(a);
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] temp = br.readLine().split(" ");
        N = pi(temp[0]);
        M = pi(temp[1]);

        long chk = 0;
        long len = 10;
        long t = 1;
        long tmp = M == 1? 1 : -1;

        for(int i=1; i<N+2; ++i) {
            if(chk>=M) {
                tmp = i-1;
                break;
            }
            if(i == len) {
                ++t;
                len *= 10;
            }
            chk += t;
        }
        if(tmp!=-1) {
            String a = tmp + "";
            System.out.println(a.charAt((int)(a.length() - (chk - M) - 1)));
        }
        else {
            System.out.println(-1);
        }
    }

}