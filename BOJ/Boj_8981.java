import java.io.*;
import java.math.*;
import java.util.*;

//Boj 8981 gold5
public class Solution {
    static int N, M, K, ans;
    static int pi(String a) {
        return Integer.parseInt(a);
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = pi(br.readLine());
        int[] a = new int[N];
        int[] b = new int[N];
        String[] temp = br.readLine().split(" ");
        for(int i=0; i<N; ++i) {
            a[i] = pi(temp[i]);
        }

        int chk = 0;
        b[0] = a[0];
        for(int i=1; i<N; ++i){
            int t = b[chk];
            chk = (chk+t)%N;
            while(b[chk]!=0) {
                chk = (chk+1)%N;
            }
            b[chk]=a[i];
        }
        System.out.println(N);
        for(int i : b) {
            System.out.print(i + " ");
        }
        System.out.println();

    }

}