import java.io.*;
import java.util.*;

//Boj 4134 silver4
public class Solution {
    static int K, N, M, ans;
    static boolean[] isPrime;
    static long Ans;
    static int pi(String a) {
        return Integer .parseInt(a);
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        K = pi(br.readLine());

        for(int k=0; k<K; ++k) {
            Ans = Long.parseLong(br.readLine());
            if(Ans==0 || Ans==1 || Ans==2) {
                sb.append(2 + "\n");
                continue;
            }
            while(true) {
                boolean flag = true;
                for(long j=2; j<Math.sqrt(Ans)+1; ++j) {
                    if(Ans%j==0) {
                        flag = false;
                        break;
                    }
                }
                if(flag) {
                    sb.append(Ans + "\n");
                    break;
                }
                ++Ans;
            }
        }
        System.out.print(sb);

    }

}