import java.io.*;
import java.util.*;

//Boj 17352 gold5
public class Solution {
    static int K, N, M, ans;
    static int[] parents = new int[300001];
    static int pi(String a) {
        return Integer .parseInt(a);
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        N = pi(br.readLine());

        for(int i=1; i<N+1; ++i) {
            parents[i] = i;
        }

        for(int i=0; i<N-2; ++i) {
            String[] temp = br.readLine().split(" ");
            union(pi(temp[0]), pi(temp[1]));
        }

        for(int i=2; i<N+1; ++i) {
            if(find(i)!=find(1)) {
                    System.out.println(1 + " " + i);
                    return;
                }
//            for(int j=i+1; j<N+1; ++j) {
//                if(find(i)!=find(j)) {
//                    System.out.println(i + " " + j);
//                    return;
//                }
//            }
        }


    }

    static void union(int x, int y) {
        int temp_x = find(x);
        int temp_y = find(y);
        if(temp_x>temp_y) {
            parents[temp_x] = temp_y;
        }
        else {
            parents[temp_y] = temp_x;
        }
    }

    static int find(int x) {
        if(parents[x]==x) {
            return x;
        }
        return parents[x] = find(parents[x]);
    }

}