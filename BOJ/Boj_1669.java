import java.io.*;
import java.util.*;

//Boj 1669 gold5
public class Solution {
    static int N, M, K, ans;
    static int pi(String a) {
        return Integer.parseInt(a);
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] temp = br.readLine().split(" ");
        N = pi(temp[0]);
        M = pi(temp[1]);

        if(N==M) {
            System.out.println(0);
            return;
        }

        long chk = 1;
        long cha = M-N;
        while(true) {
            long sum = chk*chk+chk;
            if(sum>=cha) {
                if(chk*chk>=cha) {
                    System.out.println(chk*2-1);
                }
                else {
                    System.out.println(chk*2);
                }
                return;
            }

            ++chk;
        }

    }

}