import java.io.*;
import java.util.*;

//Boj 2696 gold2
public class Solution {
    static int K, N, M, ans;
    static int pi(String a) {
        return Integer .parseInt(a);
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        M = pi(br.readLine());
        for(int m=0; m<M; ++m) {
            N = pi(br.readLine());
            PriorityQueue<Integer> max_pq = new PriorityQueue<>(new Comparator<Integer>() {
                @Override
                public int compare(Integer o1, Integer o2) {
                    return o2-o1;
                }
            });
            PriorityQueue<Integer> min_pq = new PriorityQueue<>();
            String[] temp = br.readLine().split(" ");
            ans = 0;
            String temp_str = "";
            for(int i=0; i<N; ++i) {
                if(i!=0 && i%10==0) {
                    temp = br.readLine().split(" ");
                }
                K = pi(temp[i%10]);
                if((i+1)%2==0) {
                    min_pq.add(K);
                }
                else {
                    ++ans;
                    max_pq.add(K);
                }

                if(!min_pq.isEmpty() && min_pq.peek()<max_pq.peek()) {
                    int chk = min_pq.poll();
                    min_pq.add(max_pq.poll());
                    max_pq.add(chk);
                }
                if(i%2==0) {
                    temp_str += max_pq.peek() + " ";
                }
                if(ans%10==0 && i%2==0) {
                    temp_str += "\n";
                }
            }
            sb.append(ans+"\n");
            sb.append(temp_str+"\n");

        }
        System.out.print(sb);

    }

}