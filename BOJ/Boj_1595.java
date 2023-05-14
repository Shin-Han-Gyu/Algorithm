import java.io.*;
import java.math.*;
import java.util.*;

//Boj 1595 gold4
public class Solution {
    static int N, M, K, ans;
    static ArrayList<int[]>[] map = new ArrayList[10001];
    static boolean[] visit = new boolean[10001];
    static int pi(String a) {
        return Integer.parseInt(a);
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] temp;
        for(int i=0; i<10001; ++i) {
            map[i] = new ArrayList<>();
        }
        while(true) {
            try {
                temp = br.readLine().split(" ");
                map[pi(temp[0])].add(new int[]{pi(temp[1]), pi(temp[2])});
                map[pi(temp[1])].add(new int[]{pi(temp[0]), pi(temp[2])});
            }
            catch (Exception e) {
                break;
            }

        }

        for(int i=1; i<10001; ++i) {
            solve(i, 0);
        }
        System.out.println(ans);

    }

    static void solve(int from, int len) {
        visit[from] = true;

        for(int i=0; i<map[from].size(); ++i) {
            if(!visit[map[from].get(i)[0]]) {
                solve(map[from].get(i)[0], len+map[from].get(i)[1]);
            }
            else {
                ans = Math.max(ans, len);
            }
        }
        visit[from] = false;
    }

}