import java.io.*;
import java.util.*;

//Boj 1766 gold2
public class Solution {
    static int N, M, T, ans;
    static int pi(String a) {
        return Integer.parseInt(a);
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String[] temp = br.readLine().split(" ");
        N = pi(temp[0]);
        M = pi(temp[1]);
        int[] degree = new int[N+1];
        ArrayList<ArrayList<Integer>> arr = new ArrayList<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i=0; i<N+1; ++i) {
            arr.add(new ArrayList<>());
        }

        for(int i=0; i<M; ++i) {
            temp = br.readLine().split(" ");
            arr.get(pi(temp[0])).add(pi(temp[1]));
            ++degree[pi(temp[1])];
        }

        for(int i=1; i<N+1; ++i) {
            if(degree[i]==0) {
                pq.add(i);
            }
        }

        while(!pq.isEmpty()) {
            int chk = pq.poll();

            sb.append(chk + " ");

            for(int i : arr.get(chk)) {
                --degree[i];

                if(degree[i]==0) {
                    pq.add(i);
                }
            }
        }
        System.out.println(sb);

    }

}