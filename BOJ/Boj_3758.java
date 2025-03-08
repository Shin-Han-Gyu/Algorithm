import java.io.*;
import java.util.*;

//Boj 3758 silver2
public class Main {
    static int K, N, M, ans;
    static int pi(String a) {
        return Integer.parseInt(a);
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = pi(br.readLine());

        for(int t = 0; t<T; t++) {
            String[] temp = br.readLine().split(" ");
            K = Integer.parseInt(temp[0]);
            N = Integer.parseInt(temp[1]);
            int myTeam = Integer.parseInt(temp[2]);
            M = Integer.parseInt(temp[3]);
            int[][] score = new int[K+1][N];

            Map<String, Integer> checks = new HashMap<>();


            for(int m=0; m<M; ++m) {
                temp =  br.readLine().split(" ");
                score[pi(temp[0])][pi(temp[1])-1] = Math.max(pi(temp[2]), score[pi(temp[0])][pi(temp[1])-1]);
                checks.put("T"+temp[0], checks.getOrDefault("T"+temp[0], 0) + 1);
                checks.put("L"+temp[0], m);
            }

            int[][] calc =  new int[K+1][4];

            for(int i=1; i<K+1; ++i) {
                int totalScore = 0;
                for(int j=0; j<N; ++j) {
                    totalScore += score[i][j];
                }
                calc[i][0] = totalScore;
                calc[i][1] = checks.get(String.format("T"+(i)));
                calc[i][2] = checks.get(String.format("L"+(i)));
                calc[i][3] = i;
            }

            Arrays.sort(calc, new Comparator<int[]>() {
                @Override
                public int compare(int[] o1, int[] o2) {
                    if (o1[0] != o2[0]) {
                        return o2[0] - o1[0];
                    }
                    if (o1[1] != o2[1]) {
                        return o1[1] - o2[1];
                    }
                    return o1[2] - o2[2];

                }
            });
            for(int i=0; i<K; ++i) {
                if(calc[i][3]==myTeam) {
                    System.out.println(i+1);
                    break;
                }
            }
        }

    }

}