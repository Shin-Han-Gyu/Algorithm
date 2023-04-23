import java.io.*;
import java.util.*;

//Boj 1939 Gold3
public class Solution {
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

        String[] temp = br.readLine().split(" ");
        N = pi(temp[0]);
        M = pi(temp[1]);
        arr = new ArrayList[N+1];
        for(int i=1; i<N+1; ++i) {
            arr[i] = new ArrayList<>();
        }
        int min = 0;
        int max = 0;
        for(int i=0; i<M; ++i) {
            temp = br.readLine().split(" ");
            arr[pi(temp[0])].add(new int[]{pi(temp[1]), pi(temp[2])});
            arr[pi(temp[1])].add(new int[]{pi(temp[0]), pi(temp[2])});

            max = Math.max(max, pi(temp[2]));
        }
        temp = br.readLine().split(" ");
        int x = pi(temp[0]);
        int y = pi(temp[1]);

        while(min<=max) {
            int mid = (min+max)/2;
            ans = -1;
            visit = new boolean[N+1];
            solve(x, y, mid);
            if(ans!=-1) {
                min = ++mid;
            }
            else {
                max = --mid;
            }
        }
        System.out.println(max);

    }

    static void solve(int x, int goal, int chk) {
        if(x==goal) {
            ans = Math.max(chk, ans);
            return;
        }
        visit[x] = true;
        for(int[] i : arr[x]) {
            if(!visit[i[0]] && chk < i[1]+1) {
                solve(i[0], goal, chk);
            }
        }

    }


}