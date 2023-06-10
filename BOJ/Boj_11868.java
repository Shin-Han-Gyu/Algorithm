import java.io.*;
import java.util.*;

//Boj 11868 Platinum4
public class Solution {
    static int K, N, M, ans;
    static int pi(String a) {
        return Integer.parseInt(a);
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        N = pi(br.readLine());
        String[] temp = br.readLine().split(" ");
        for(int i=0; i<N; ++i) {
            ans ^= pi(temp[i]);
        }
        if(ans!=0) {
            System.out.println("koosaga");
        }
        else {
            System.out.println("cubelover");
        }

    }
    
}