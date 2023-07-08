import java.io.*;
import java.util.*;

//Boj 1202 gold2
public class Solution {
    static int K, N, M, ans;
    static long Ans;
    static int pi(String a) {
        return Integer .parseInt(a);
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String[] temp = br.readLine().split(" ");
        N = pi(temp[0]);
        K = pi(temp[1]);
        int[][] jewel = new int[N][2];
        int[] bag = new int[K];
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int i=0; i<N; ++i) {
            temp = br.readLine().split(" ");
            jewel[i][0] = pi(temp[0]);
            jewel[i][1] = pi(temp[1]);
        }

        Arrays.sort(jewel, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[0]==o2[0]) {
                    return o2[1]-o1[1];
                }
                return o1[0]-o2[0];
            }
        });

        for(int i=0; i<K; ++i) {
            bag[i] = pi(br.readLine());
        }
        Arrays.sort(bag);

        for(int i=0; i<K; ++i) {
            while (ans < N && jewel[ans][0] < bag[i]+1) {
                pq.offer(jewel[ans++][1]);
            }

            if (!pq.isEmpty()) {
                Ans += pq.poll();
            }
        }
        System.out.println(Ans);

    }

}