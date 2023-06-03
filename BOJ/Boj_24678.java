import java.io.*;
import java.util.*;

//Boj 24678 gold3
public class Solution {
    static int N, M, K, ans;
    static int pi(String a) {
        return Integer.parseInt(a);
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        N = pi(br.readLine());
        for(int i=0; i<N; ++i) {
            String[] temp = br.readLine().split(" ");
            int chk=0;
            if(pi(temp[0])%2==1) {
                ++chk;
            }
            if(pi(temp[1])%2==1) {
                ++chk;
            }
            if(pi(temp[2])%2==1) {
                ++chk;
            }
            if(chk<2) {
                sb.append("R\n");
            }
            else {
                sb.append("B\n");
            }
        }
        System.out.print(sb);

    }

}