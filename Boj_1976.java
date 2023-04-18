import java.io.*;
import java.util.*;

//Boj 1976 Gold4
public class Solution {
    static int[] parent;
    static int N, M;

    static int pi(String a) {
        return Integer.parseInt(a);
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = pi(br.readLine());
        M = pi(br.readLine());

        parent = new int[N+1];

        for(int i=1; i<N+1; ++i) {
            parent[i] = i;
        }
        String[] temp;
        for(int i=0; i<N; ++i) {
            temp = br.readLine().split(" ");
            for(int j=0; j<N; ++j) {
                if(pi(temp[j])==1) {
                    union(i+1, j+1);
                }
            }
        }

        temp = br.readLine().split(" ");
        String ans = "YES";
        for(int i=1; i<M; ++i) {
            if(find(pi(temp[i-1])) != find(pi(temp[i]))) {
                ans = "NO";
                break;
            }
        }
        System.out.println(ans);


    }

    static void union(int x, int y) {
        int temp_x = find(x);
        int temp_y = find(y);
        if(temp_x<temp_y) {
            parent[temp_y] = temp_x;
        }
        else {
            parent[temp_x] = temp_y;
        }
    }

    static int find(int x) {
        if(parent[x]==x) {return x;}
        return find(parent[x]);
    }


}
