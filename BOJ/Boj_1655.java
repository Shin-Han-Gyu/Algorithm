import java.io.*;
import java.util.*;

//Boj 1655 gold2
public class Solution {
    static int K, N, M, ans;
    static int pi(String a) {
        return Integer .parseInt(a);
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        N = pi(br.readLine());
        PriorityQueue<Integer> max_pq = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2-o1;
            }
        });
        PriorityQueue<Integer> min_pq = new PriorityQueue<>();
        for(int i=0; i<N; ++i) {
            K = pi(br.readLine());
            if((i+1)%2==0) {
                min_pq.add(K);
            }
            else {
                max_pq.add(K);
            }

            if(!min_pq.isEmpty() && min_pq.peek()<max_pq.peek()) {
                int chk = min_pq.poll();
                min_pq.add(max_pq.poll());
                max_pq.add(chk);
            }
            sb.append(max_pq.peek()+"\n");
        }

        System.out.print(sb);

    }

}