import java.io.*;
import java.util.*;

//Boj 5859 gold2
public class Solution {
    static int T, N, M, ans;
    static int[] parents;
    static HashMap<Integer, String> map = new HashMap<>();
    static int pi(String a) {
        return Integer.parseInt(a);
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] temp = br.readLine().split(" ");

        N = pi(temp[0]);
        M = pi(temp[1]);
        parents = new int[N+1];
        for(int i=1; i<N+1; ++i) {
            parents[i] = i;
        }
        for(int i=0; i<M; ++i) {
            temp = br.readLine().split(" ");
            int x = pi(temp[0]);
            int y = pi(temp[1]);

            if (parents[x] == parents[y] || parents[x] == -parents[y]) {
                if ((parents[x] == parents[y]) && !(temp[2].equals("T"))) {
                    System.out.println(i);
                    System.exit(0);
                }
                else if((parents[x] != parents[y]) && (temp[2].equals("T"))) {
                    System.out.println(i);
                    System.exit(0);
                }
            }
            else {
                int x_ = temp[2].equals("T") ? parents[x] : -parents[x];
                int y_ = parents[y];
                for (int j=1; j<N+1; ++j) {
                    if (parents[j] == y_) {
                        parents[j] = x_;
                    }
                    else if (parents[j] == -y_) {
                        parents[j] = -x_;
                    }
                }
            }
        }
        System.out.println(M);
    }

}
