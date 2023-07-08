import java.io.*;
import java.util.*;

//Boj 11651 silver5
public class Main {
    static int K, N, M, ans;
    static boolean[] isPrime = new boolean[1001];
    static int pi(String a) {
        return Integer .parseInt(a);
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        N = pi(br.readLine());
        int[][] coor = new int[N][2];
        for(int i=0; i<N; ++i) {
            String[] temp = br.readLine().split(" ");

            coor[i][0] = pi(temp[0]);
            coor[i][1] = pi(temp[1]);
        }

        Arrays.sort(coor, new Comparator<int[]>() {
           @Override
			public int compare(int[] o1, int[] o2) {
				if(o1[1]==o2[1]) {
                    return o1[0]-o2[0];
                }
                return o1[1]-o2[1];
			} 
        });

        for(int i=0; i<N; ++i) {
            System.out.println(coor[i][0] + " " + coor[i][1]);
        }

    }

}