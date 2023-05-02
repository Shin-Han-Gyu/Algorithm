import java.io.*;
import java.util.*;

//Boj 1715 gold4
public class Solution {
    static int N, M, ans;
    static int pi(String a) {
        return Integer.parseInt(a);
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = pi(br.readLine());
        if(N==1) {
            System.out.println(0);
            return;
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i=0; i<N; ++i) {
            pq.add(pi(br.readLine()));
        }

        while(pq.size()>1) {
            int temp = pq.poll() + pq.poll();
            ans += temp;
            pq.add(temp);
        }
        System.out.println(ans);
    }
}