import java.io.*;
import java.util.*;

//Boj 6068 gold5
public class Main {
    static int N, M, K, ans;
    static int pi(String a) {
        return Integer.parseInt(a);
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = pi(br.readLine());
        int[][] hw = new int[N][2];
        for(int i=0; i<N; ++i) {
            String[] temp = br.readLine().split(" ");
            hw[i][0] = pi(temp[0]);
            hw[i][1] = pi(temp[1]);
        }

        Arrays.sort(hw, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o2[1]-o1[1];
            }
        });

        ans = hw[0][1];

        for(int i=0; i<N-1; ++i) {
            if(ans - hw[i][0] > hw[i+1][1] ) {
                ans = hw[i+1][1];
            }
            else {
                ans -= hw[i][0];
            }
        }

        System.out.println(Math.max(-1, ans-hw[N-1][0]));


    }

}