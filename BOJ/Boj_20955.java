import java.io.*;
import java.util.*;

//Boj 20955 Gold4
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

        parent = new int[N+1];

        for(int i=1; i<N+1; ++i) {
            parent[i] = i;
        }
        int chk = 0;
        for(int i=0; i<M; ++i) {
            temp = br.readLine().split(" ");
            if(!union(pi(temp[0]), pi(temp[1]))) {
                ++chk;
            }
        }
        HashSet<Integer> set = new HashSet<>();
        for(int i=1; i<N+1; ++i) {
            set.add(find(i));
        }
        System.out.println(chk + set.size()-1);


    }

    static boolean union(int x, int y) {
        int temp_x = find(x);
        int temp_y = find(y);

        if(temp_x == temp_y) {
            return false;
        }
        if(temp_x<temp_y) {
            parent[temp_y] = temp_x;
        }
        else {
            parent[temp_x] = temp_y;
        }
        return true;
     }

    static int find(int x) {
        if(parent[x]==x) {
            return x;
        }
        return find(parent[x]);
    }
}