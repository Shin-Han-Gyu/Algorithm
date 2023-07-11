import java.io.*;
import java.util.*;

//Boj 3066 gold2
public class Main {
    static int K, N, M, ans, m;
    static long Ans;
    static int[][] pole;
    static int[] preIndex;
    static ArrayList<Integer> list;
    static int pi(String a) {
        return Integer .parseInt(a);
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        K = pi(br.readLine());
        for(int k=0; k<K; ++k) {
            N = pi(br.readLine());
            int arr[] = new int[N], lis[] = new int[N];
            ans = 0;
            for(int i=0; i<N; ++i) {
                arr[i] = pi(br.readLine());
            }
            for(int i=0; i<N; ++i) {
                int temp = Arrays.binarySearch(lis, 0, ans, arr[i]);

                if(temp < 0)
                    temp = Math.abs(temp) - 1;

                lis[temp] = arr[i];

                if(temp == ans)
                    ++ans;
            }
            System.out.println(ans);
        }
    }
}