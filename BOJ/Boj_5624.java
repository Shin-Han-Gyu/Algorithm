import java.io.*;
import java.util.*;

//Boj 5624 gold3
public class Solution {
    static int K, N, M, ans;
    static int pi(String a) {
        return Integer .parseInt(a);
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        N = pi(br.readLine());

        String[] temp = br.readLine().split(" ");
        int[] a = new int[N];

        for(int i=0; i<N; ++i) {
            a[i] = pi(temp[i]);
        }
        int mid = 200000;
        boolean[] visited = new boolean[mid*2+1];

        int ans =0;
        for(int i=0; i<N; ++i) {
            for(int j=0; j<i; ++j) {
                if(visited[a[i] - a[j] + mid]) {
                    ++ans;
                    break;
                }
            }

            for(int j=0; j<=i; ++j) {
                visited[a[i] + a[j] + mid ] = true;
            }

        }

        System.out.println(ans);
    }

}