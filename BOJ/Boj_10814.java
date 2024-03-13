import java.io.*;
import java.util.*;

//Boj 10814 silver5
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
        String[][] peoples = new String[N][2];

        for(int i=0; i<N; ++i) {
            String[] a = br.readLine().split(" ");
            peoples[i][0] = a[0];
            peoples[i][1] = a[1];
        }

        Arrays.sort(peoples, new Comparator<String[]>() {
            @Override
            public int compare(String[] o1, String[] o2) {
                return pi(o1[0])-pi(o2[0]);
            }
        });

        for(int i=0; i<N; ++i) {
            System.out.println(peoples[i][0] + " " + peoples[i][1]);
        }
    }

}
