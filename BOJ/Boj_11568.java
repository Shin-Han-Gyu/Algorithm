import java.io.*;
import java.util.*;

//Boj 11568 silver2
public class Solution {
    static int K, N, M, ans;
    static long Ans;
    static int pi(String a) {
        return Integer .parseInt(a);
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        N = pi(br.readLine());
        int a[] = new int[N+1];
        String[] temp = br.readLine().split(" ");
        Arrays.fill(a, Integer.MAX_VALUE);
        a[0] = Integer.MIN_VALUE;
        int chk = 0;

        for(int i=0; i<N; ++i) {
            int t = pi(temp[i]);
            if(a[chk]<t) {
                a[++chk] = t;
            }
            else {
                int idx = Arrays.binarySearch(a, t);
                if(idx<0)
                    idx = (idx*-1) -1;
                a[idx] = t;
            }
        }
        ans = -1;
        for(int i : a) {
            if(i!=Integer.MAX_VALUE)
                ++ans;
            else {
                break;
            }
        }
        System.out.println(ans);

    }


}