import java.io.*;
import java.util.*;

//Boj 20040 Gold4
public class Solution {
    static int D, N, M, ans;
    static int[][] map;
    static int[] parent;
    static int pi(String a) {
        return Integer.parseInt(a);
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] temp = br.readLine().split(" ");

        int N = pi(temp[0]);
        int M = pi(temp[1]);
        parent = new int[N];
        for(int i=0; i<N; ++i) {
            parent[i] = i;
        }
        int ans = 0;
        for(int i=0; i<M; ++i) {
            temp = br.readLine().split(" ");
            if(union(pi(temp[0]), pi(temp[1]))) {
                ans = i+1;
                break;
            }
        }
        System.out.println(ans);
    }

    static boolean union(int x, int y) {
        int temp_x = find(x);
        int temp_y = find(y);
        if(temp_x == temp_y) {
            return true;
        }
        if(temp_x<temp_y) {
            parent[temp_y] = temp_x;
        }
        else {
            parent[temp_x] = temp_y;
        }
        return false;
    }

    static int find(int x) {
        if(parent[x] == x) {
            return x;
        }
        return find(parent[x]);
    }

}