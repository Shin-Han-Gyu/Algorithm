import java.io.*;
import java.util.*;

//Boj 1946 silver1
public class Main {
    static int N, M, T, ans;
    static int pi(String a) {
        return Integer.parseInt(a);
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        T = pi(br.readLine());

        for(int t=0; t<T; ++t) {
            N = pi(br.readLine());
            int[][] score = new int[N][2];
            
            for(int i=0; i<N; ++i) {
                String[] temp = br.readLine().split(" ");
                score[i][0] = pi(temp[0]);
                score[i][1] = pi(temp[1]);
            }

            Arrays.sort(score, new Comparator<int[]>() {
                @Override
                public int compare(int o1[], int o2[]) {
                    return o1[0] - o2[0];
                }
            });
            ans = 1;
            int chk = score[0][1];
            for(int i=1; i<N; ++i) {
                if(chk>score[i][1]) {
                    chk = score[i][1];
                    ++ans;
                }
            }
            System.out.println(ans);

        }

    }

}