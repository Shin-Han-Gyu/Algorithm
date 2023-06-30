import java.io.*;
import java.util.*;

//Boj 14864 gold2
public class Solution {
    static int K, N, M, ans;
    static int pi(String a) {
        return Integer .parseInt(a);
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String[] temp = br.readLine().split(" ");
        N = pi(temp[0]);
        M = pi(temp[1]);
        int[] arr = new int[N+1];
        boolean[] chk = new boolean[N+1];
        for(int i=1; i<N+1; ++i) {
            arr[i] = i;
        }

        for(int i=0; i<M; ++i) {
            temp = br.readLine().split(" ");
            ++arr[pi(temp[0])];
            --arr[pi(temp[1])];
        }

        for(int i=1; i<N+1; ++i) {
            chk[arr[i]] = true;
        }

        for(int i=1; i<N+1; ++i) {
            if(!chk[i]) {
                System.out.println(-1);
                return;
            }
        }

        for(int i=1; i<N+1; ++i) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();

    }


}