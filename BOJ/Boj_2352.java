import java.io.*;
import java.lang.reflect.Array;
import java.util.*;

//Boj 1939 Gold3
public class Main {
    static int K, N, M, ans;
    static ArrayList<int[]>[] arr;
    static boolean[] visit;
    static int[][] map;
    static int[] parent;
    static int pi(String a) {
        return Integer.parseInt(a);
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = pi(br.readLine());
        int arr[] = new int[N];
        int lis[] = new int[N];
        ans = 0;
        String[] temp = br.readLine().split(" ");
        for(int i=0; i<N; ++i) {
            arr[i] = pi(temp[i]);
        }

        for(int i=0; i<N; ++i) {
            int bs = Arrays.binarySearch(lis, 0, ans, arr[i]);

            if(bs < 0) {
                bs = Math.abs(bs) - 1;
            }

            lis[bs] = arr[i];

            if(bs == ans) {
                ++ans;
            }
        }
        System.out.println(ans);


    }


}