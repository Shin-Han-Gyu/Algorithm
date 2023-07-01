import java.io.*;
import java.util.*;

//Boj 10464 gold4
public class Solution {
    static int K, N, M, ans;
    static int pi(String a) {
        return Integer .parseInt(a);
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        K = pi(br.readLine());

        for(int k=0; k<K; ++k) {
            String[] temp = br.readLine().split(" ");
            sb.append((find(pi(temp[0])-1)^find(pi(temp[1])))+"\n");
        }
        System.out.print(sb);

    }

    static int find(int a)
    {
        int mod = a % 4;
        if (mod == 0) {
            return a;
        }
        else if (mod == 1) {
            return 1;
        }
        else if (mod == 2) {
            return a + 1;
        }
        else {
            return 0;
        }
    }

}