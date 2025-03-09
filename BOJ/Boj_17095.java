import java.io.*;
import java.util.*;

//Boj 17095 silver3
public class Main {
    static int K, N, M, ans;
    static int pi(String a) {
        return Integer.parseInt(a);
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = pi(br.readLine());
        int[] nums = new int[N];
        String[] temp = br.readLine().split(" ");
        for(int i=0; i<N; ++i) {
            nums[i] = pi(temp[i]);
        }
        ans = 100001;
        int[] maxV = new int[N];
        int[] maxP = new int[N];
        int[] minV = new int[N];
        int[] minP = new int[N];

        int maxValue = -1;
        int minValue = 100001;
        int maxIndex = -1;
        int minIndex = -1;

        for (int i=N-1; i>=0; --i) {
            if (maxValue <= nums[i]) {
                maxValue = nums[i];
                maxIndex = i;
            }
            if (minValue >= nums[i]) {
                minValue = nums[i];
                minIndex = i;
            }
            maxV[i] = maxValue;
            maxP[i] = maxIndex;
            minV[i] = minValue;
            minP[i] = minIndex;
        }

        int tmp = -1;
        for (int i=0; i<N; ++i) {
            int diff = maxV[i] - minV[i];
            if (diff >= tmp) {
                tmp = diff;
                ans = Math.min(ans, Math.abs(maxP[i] - minP[i]));
            }
        }
        System.out.println(ans + 1);

    }

}