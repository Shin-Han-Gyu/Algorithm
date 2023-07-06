import java.io.*;
import java.util.*;

//Boj 11722 silver2
public class Solution {
    static int K, N, M, ans;
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
        ArrayList<int[]> path = new ArrayList<>();
        a[0] = 0;
        int chk = 0;
        int chk_ = 0;
        for(int i=0; i<N; ++i) {
            int temp_ = -1*pi(temp[i]);
            int idx;
            if(a[chk]<temp_) {
                a[++chk] = temp_;
                idx = chk;
            }
            else {
                idx = Arrays.binarySearch(a, temp_);
                if(idx<0) {
                    idx = (idx*-1) - 1;
                }
                a[idx] = temp_;
            }
            path.add(new int[]{idx, temp_});
            chk_ = Math.max(idx, chk_);
        }
        System.out.println(chk_+1);

    }


}