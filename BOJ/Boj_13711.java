import java.io.*;
import java.lang.reflect.Array;
import java.util.Arrays;

//Boj 13711 platinum5
public class Solution {
    static int K, N, M, ans;
    static long Ans;
    static int[] p;
    static int pi(String a) {
        return Integer .parseInt(a);
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        N = pi(br.readLine());
        int[] c = new int[N];
        int[] arr = new int[N];

        String[] temp = br.readLine().split(" ");
        for(int i=0; i<N; ++i) {
            c[i] = pi(temp[i]);
        }

        temp = br.readLine().split(" ");
        for(int i=0; i<N; ++i) {
            int num =  pi(temp[i]);
            arr[num-1] = i;
        }

        int[] res = new int[N];
        for(int i=0; i<N; ++i) {
            res[i] = arr[c[i]-1]+1;
        }

        p = new int[N+1];
        System.out.println(LIS(res));

    }

    static int LIS(int[] arr) {
        int len=0;
        int idx=0;
        for(int i=0; i<N; ++i) {
            if(arr[i] > p[len]) {
                len += 1;
                p[len] = arr[i];
            }
            else {
                idx = Arrays.binarySearch(p,0, len, arr[i]);
                if(idx<0) {
                    idx = (idx*-1) -1;
                }
                p[idx] = arr[i];
            }
        }
        return len;
    }
    
}