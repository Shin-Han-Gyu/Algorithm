import java.io.*;
import java.util.*;

//Boj 21773 gold5
public class Solution {
    static int N, M, K, ans;
    static int pi(String a) {
        return Integer.parseInt(a);
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] temp = br.readLine().split(" ");

        N = pi(temp[0]);
        M = pi(temp[1]);
        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[2]==o2[2]) {
                    return o1[0]-o2[0];
                }
                return o2[2]-o1[2];
            }
        });

        for(int i=0; i<M; ++i) {
            temp = br.readLine().split(" ");

            pq.add(new int[]{pi(temp[0]), pi(temp[1]), pi(temp[2])});
        }
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<N; ++i) {
            int[] chk = pq.poll();
            sb.append(chk[0] + "\n");
            --chk[1];
            --chk[2];
            if(chk[1]==0) {
                continue;
            }
            pq.add(chk);
        }
        System.out.print(sb);
    }

}