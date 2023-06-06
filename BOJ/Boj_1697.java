import java.io.*;
import java.util.*;

//Boj 1697 silver1
public class Main {
    static int min = Integer.MAX_VALUE, cnt=1;
    static int pi(String a) {
        return Integer.parseInt(a);
    }

    static void bfs(int N, int K) {
        Queue<int[]> q = new LinkedList<>();
        int d = 0;
        boolean[] visited = new boolean[100001];
        q.add(new int[]{N, d});
        while(!q.isEmpty()) {
            int temp[] = q.poll();
            visited[temp[0]] = true;
            if(temp[0] == K) {
                if(min > temp[1])
                    min = temp[1];
                else if(min == temp[1])
                    cnt++;

                continue;
            }

            int[] a = new int[]{temp[0]-1, temp[0]+1, temp[0]*2};

            for(int i=0; i<3; ++i) {
                if(a[i]>-1 && a[i]<100001 && !visited[a[i]])
                    q.add(new int[]{a[i], temp[1]+1});
            }
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] a = br.readLine().split(" ");
        int N = pi(a[0]), K = pi(a[1]), path[] = new int[100001], ans;
        if(N>K) {
            System.out.println(N - K);
        }
        else {
            Arrays.fill(path, -1);
            Queue<Integer> q = new LinkedList<>();
            q.offer(N);
            bfs(N, K);
            System.out.println(min);
        }

    }
}