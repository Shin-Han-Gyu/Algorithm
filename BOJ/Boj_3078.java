import java.io.*;
import java.util.*;

//Boj 3078 gold4
public class Solution {
    static int N, M, K, ans;
    static int pi(String a) {
        return Integer.parseInt(a);
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] temp = br.readLine().split(" ");
        N = pi(temp[0]);
        K = pi(temp[1]);
        int[] stLen = new int[N];
        int[] malcom = new int[21];
        for(int i=0; i<N; ++i) {
            stLen[i] = br.readLine().length();
        }
        Queue<int[]> q = new LinkedList<>();
        long a = 0;
        for(int i=0; i<N; ++i) {
            q.add(new int[]{i, stLen[i]});
            ++malcom[stLen[i]];

            if(q.peek()[0]+K<i || q.peek()[0]>K+i) {
                --malcom[q.peek()[1]];
                q.poll();
            }

            a += malcom[stLen[i]]-1;
        }
        System.out.println(a);

    }

}