import java.io.*;
import java.util.*;

//Boj 1092 gold5
public class Solution {
    static int T, N, M, ans;
    static int[][] map;

    static int pi(String a) {
        return Integer.parseInt(a);
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = pi(br.readLine());
        ArrayList<Integer> crane = new ArrayList<>();
        ArrayList<Integer> box = new ArrayList<>();

        String[] temp = br.readLine().split(" ");
        for(int i=0; i<N; ++i) {
            crane.add(pi(temp[i]));
        }
        M = pi(br.readLine());
        temp = br.readLine().split(" ");
        for(int i=0; i<M; ++i) {
            box.add(pi(temp[i]));
        }
        Collections.sort(crane, Collections.reverseOrder());
        Collections.sort(box, Collections.reverseOrder());
        if(crane.get(0)<box.get(0)) {
            System.out.println(-1);
            System.exit(0);
        }
        while(box.size()>0) {
            ++ans;
            int chk = 0;
            for(int i=0; i<crane.size();) {
                if(chk==box.size()) {
                    break;
                }
                if(crane.get(i)>=box.get(chk)) {
                    box.remove(chk);
                    ++i;
                }
                else {
                    ++chk;
                }
            }
        }
        System.out.println(ans);
    }

}
