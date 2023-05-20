import java.io.*;
import java.util.*;

//Boj 2285 gold4
public class Solution {
    static int N, M, K, ans;
    static int pi(String a) {
        return Integer.parseInt(a);
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = pi(br.readLine());
        long[][] town = new long[N][2];
        long population = 0;
        long Ans = 0;
        for(int i=0; i<N; ++i) {
            String[] temp = br.readLine().split(" ");
            town[i][0] = pi(temp[0]);
            town[i][1] = pi(temp[1]);
            population += town[i][1];
        }
        Arrays.sort(town, new Comparator<long[]>() {
            @Override
            public int compare(long[] o1, long[] o2) {
                return (int)(o1[0]-o2[0]);
            }
        });
        for(int i=0; i<N; ++i) {
            Ans += town[i][1];
            if(Ans >= (population+1)/2) {
                System.out.println(town[i][0]);
                return;
            }
        }

    }

}