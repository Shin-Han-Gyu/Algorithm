import java.io.*;
import java.util.*;

//Boj 14002 gold4
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
            int temp_ = pi(temp[i]);
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
        ans = -1;
        for(int i : a) {
            if(i!=Integer.MAX_VALUE)
                ++ans;
            else {
                break;
            }
        }
        System.out.println(ans);
        for(int i=path.size()-1; i>-1; --i) {
            if(path.get(i)[0] == chk_) {
                sb.insert(0, path.get(i)[1] + " ");
                --chk_;
            }
        }
        System.out.println(sb);

    }

}