import java.io.*;
import java.util.*;

//Boj 4195 gold2
public class Solution {
    static int T, N, M, ans;
    static int[][] map;
    static int[] parents, sizes;
    static int pi(String a) {
        return Integer.parseInt(a);
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        T = pi(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int t=0; t<T; ++t) {
            N = pi(br.readLine());
            parents = new int[N*2];
            sizes = new int[N*2];
            for(int i=0; i<N*2; ++i) {
                parents[i] = i;
                sizes[i] = 1;
            }
            int idx = -1;
            HashMap<String, Integer> map = new HashMap<>();
            for(int i=0; i<N; ++i) {
                String[] temp = br.readLine().split(" ");
                int out = 0;
                if(!map.containsKey(temp[0])) {
                    map.put(temp[0], ++idx);
                }
                if(!map.containsKey(temp[1])) {
                    map.put(temp[1], ++idx);
                }
                int temp_1 = find(map.get(temp[0]));
                int temp_2 = find(map.get(temp[1]));

                sb.append(union(temp_1, temp_2)+"\n");

            }

        }
        System.out.println(sb);

    }

    static int union(int x, int y) {
        x = find(x);
        y = find(y);

        if (x!=y) {
            parents[y] = x;
            sizes[x] += sizes[y];
            sizes[y] = 1;
        }

        return sizes[x];
    }

    static int find(int x) {
        if(parents[x]==x) {
            return x;
        }
        return parents[x]=find(parents[x]);
    }

}