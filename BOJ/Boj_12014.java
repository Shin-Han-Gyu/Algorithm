import java.io.*;
import java.util.*;

//Boj 12014 gold2
public class Solution {
    static int K, N, M, ans, m;
    static long Ans;
    static int pi(String a) {
        return Integer .parseInt(a);
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        M = pi(br.readLine());
        for(int m=0; m<M; ++m) {
            String[] temp = br.readLine().split(" ");
            N = pi(temp[0]);
            K = pi(temp[1]);
            int a[] = new int[N+1];
            temp = br.readLine().split(" ");
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
            if(K<ans+1) {
                sb.append("Case #" + (m+1) +"\n1\n");
            }
            else {
                sb.append("Case #" + (m+1) +"\n0\n");
            }
        }
        System.out.print(sb);

    }

}