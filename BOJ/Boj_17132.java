import java.io.*;
import java.util.*;

//Boj 17132 platinum5
public class Solution {
    static int T, N, M;
    static int[][] map;
    static int[] parent , rank_sizes, group_sizes;

    static ArrayList<AbstractMap.SimpleEntry<Integer, AbstractMap.SimpleEntry<Integer, Integer>>> edge = new ArrayList<>();
    static long result = 0;

    static int pi(String a) {
        return Integer.parseInt(a);
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = pi(br.readLine());
        parent = new int[100001];
        rank_sizes = new int[100001];
        group_sizes = new int[100001];
        for (int i=0; i<100001; ++i) {
            parent[i] = i;
            rank_sizes[i] = 1;
            group_sizes[i] = 1;
        }

        for (int i=0; i<N-1; ++i) {
            String[] temp = br.readLine().split(" ");
            edge.add(new AbstractMap.SimpleEntry<>(pi(temp[2]), new AbstractMap.SimpleEntry<>(pi(temp[0]), pi(temp[1]))));
        }
        Collections.sort(edge, new Comparator<AbstractMap.SimpleEntry<Integer, AbstractMap.SimpleEntry<Integer, Integer>>>() {
            @Override
            public int compare(AbstractMap.SimpleEntry<Integer, AbstractMap.SimpleEntry<Integer, Integer>> o1, AbstractMap.SimpleEntry<Integer, AbstractMap.SimpleEntry<Integer, Integer>> o2) {
                int temp_1 = o1.getKey();
                int temp_2 = o2.getKey();
                return temp_2 - temp_1;
            }
        });

        for (int i=0; i<edge.size(); ++i) {
            int cost = edge.get(i).getKey();
            int x = edge.get(i).getValue().getKey();
            int y = edge.get(i).getValue().getValue();

            x = find(x);
            y = find(y);

            result += ((long) group_sizes[x] * (long) group_sizes[y] * (long) cost);
            merge(x, y);
        }

        System.out.println(result);

    }

    static int find(int x) {
        if (parent[x] == x) {
            return x;
        }
        return parent[x] = find(parent[x]);
    }

    static void merge(int x, int y) {
        x = find(x);
        y = find(y);

        if (x == y) { return; }

        if (rank_sizes[x]<rank_sizes[y]) {
            parent[x] = y;
            group_sizes[y] += group_sizes[x];
        }
        else {
            parent[y] = x;
            group_sizes[x] += group_sizes[y];

            if (rank_sizes[x]==rank_sizes[y]) {
                ++rank_sizes[x];
            }
        }
    }

}




