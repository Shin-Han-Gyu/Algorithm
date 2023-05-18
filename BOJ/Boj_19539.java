import java.io.*;
import java.util.*;

//Boj 19539 gold5
public class Solution {
    static int N, M, K, ans;
    static int pi(String a) {
        return Integer.parseInt(a);
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = pi(br.readLine());
        String[] temp = br.readLine().split(" ");
        int[] tree = new int[N];
        int chk = 0;
        for(int i=0; i<N; ++i) {
            tree[i] = pi(temp[i]);
            ans += tree[i];
            chk += tree[i]%2==1 ? 1 : 0;
        }

        if(ans%3==0 && chk <= ans/3) {
            System.out.println("YES");
        }
        else {
            System.out.println("NO");
        }
    }
}