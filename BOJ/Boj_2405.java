import java.io.*;
import java.util.*;

//Boj 2405 gold4
public class Solution {
    static int N, M, K, ans;
    static int pi(String a) {
        return Integer.parseInt(a);
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = pi(br.readLine());
        int[] arr = new int[N];
        for(int i=0; i<N; ++i) {
            arr[i] = pi(br.readLine());
        }

        Arrays.sort(arr);
        ans = arr[0]+arr[N-1]-arr[1]*2;
        for(int i=1; i<N-2; ++i) {
            ans = Math.max(ans, arr[i]+arr[N-1]-arr[i+1]*2);
            ans = Math.max(ans, arr[i]*2-arr[0]-arr[i+1]);
        }
        ans = Math.max(ans, arr[N-2]*2-arr[0]-arr[N-1]);

        System.out.println(ans);

    }

}