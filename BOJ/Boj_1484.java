import java.io.*;
import java.util.*;

//Boj 1484 gold5
public class Solution {
    static int K, N, M, ans;
    static int pi(String a) {
        return Integer .parseInt(a);
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        N = pi(br.readLine());
        boolean flag = true;
        for(int i=1; i<50001; ++i) {
            long temp = N+(long)i*i;
            long chk = (long) Math.sqrt(temp);
            if(chk*chk==temp) {
                sb.append(chk+"\n");
                flag = false;
            }
        }
        if(flag) {
            System.out.println(-1);
            return;
        }
        System.out.print(sb);

    }

}