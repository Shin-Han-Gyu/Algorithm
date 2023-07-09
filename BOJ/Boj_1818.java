import java.io.*;
import java.util.*;

//Boj 1818 gold2
public class Solution {
    static int K, N, M, ans, m;
    static long Ans;
    static int pi(String a) {
        return Integer .parseInt(a);
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        N = pi(br.readLine());
        int arr[] = new int[N], lis[] = new int[N], ans = 0;
        String[] A = br.readLine().split(" ");
        for(int i=0; i<N; ++i) {
            arr[i] = pi(A[i]);
        }

        for(int i=0; i<N; ++i) {
            int temp = Arrays.binarySearch(lis, 0, ans, arr[i]);

            if(temp < 0)
                temp = Math.abs(temp) - 1;

            lis[temp] = arr[i];

            if(temp == ans)
                ++ans;
        }
        System.out.println(N - ans);
    }



}