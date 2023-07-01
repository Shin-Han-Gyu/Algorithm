import java.io.*;
import java.util.*;

//Boj 1495 silver1
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
        K = pi(temp[1]);
        M = pi(temp[2]);

        int[] diff = new int[N+1];
        temp = br.readLine().split(" ");
        for(int i=1; i<N+1; ++i) {
            diff[i] = pi(temp[i-1]);
        }

        int[] volume = new int[M + 1];
        for(int i=0; i<M+1; ++i){
            volume[i] = -1;
        }
        volume[K] = 0;
        ArrayList<Integer> arr = new ArrayList<>();

        for(int i=1; i<N+1; ++i) {
            arr.clear();

            for(int j=0; j<M+1; ++j) {
                if(volume[j] == i-1) {
                    if (-1< j-diff[i] && j-diff[i] <M+1) {
                        arr.add(j - diff[i]);
                    }
                    if (-1< j+diff[i] && j+diff[i] <M+1) {
                        arr.add(j + diff[i]);
                    }
                }
            }
            for (int v : arr) {
                volume[v] = i;
            }
        }

        for(int i=M; i>-1; --i){
            if(volume[i] == N){
                System.out.println(i);
                return;
            }
        }
        System.out.println(-1);

    }

}