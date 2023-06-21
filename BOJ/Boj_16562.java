import java.io.*;
import java.util.*;

//Boj 16562 gold4
public class Solution {
    static int K, N, M, ans;
    static int[] parents = new int[10001];
    static int[] money = new int[10001];
    static int pi(String a) {
        return Integer .parseInt(a);
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String[] temp = br.readLine().split(" ");
        N = pi(temp[0]);
        M = pi(temp[1]);
        K = pi(temp[2]);

        for(int i=0; i<10001; ++i) {
            parents[i] = i;
        }

        temp = br.readLine().split(" ");
        for(int i=0; i<N; ++i) {
            money[i+1] = pi(temp[i]);
        }

        for(int i=0; i<M; ++i) {
            temp = br.readLine().split(" ");
            union(pi(temp[0]), pi(temp[1]));
        }

        ans += money[1];
        for(int i=2; i<N+1; ++i) {
            if(find(1)!=find(i)) {
                ans += money[i];
                union(1, i);
            }
        }
        if(ans>K) {
            System.out.println("Oh no");
        }
        else {
            System.out.println(ans);
        }
    }

    static void union(int x, int y) {
        int temp_x = find(x);
        int temp_mx = money[temp_x];
        int temp_y = find(y);
        int temp_my = money[temp_y];
        if(temp_x>temp_y) {
            parents[temp_x] = temp_y;
        }
        else {
            parents[temp_y] = temp_x;
        }
        if(temp_mx<temp_my) {
            money[temp_y] = temp_mx;
        }
        else {
            money[temp_x] = temp_my;
        }
    }
    static int find(int x) {
        if(parents[x]==x) {
            return x;
        }
        return parents[x] = find(parents[x]);
    }

}