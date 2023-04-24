import java.io.*;
import java.util.*;

//Boj 1374 Gold5
public class Main {
    static int K, N, M, ans;
    static int[][] map;
    static int[] parent;
    static int pi(String a) {
        return Integer.parseInt(a);
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = pi(br.readLine());
        ArrayList<int[]> a = new ArrayList<>();
        for(int i=0; i<N; ++i) {
            String[] temp = br.readLine().split(" ");
            a.add(new int[]{pi(temp[1]), pi(temp[2])});
        }

        Collections.sort(a, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[0]==o2[0]) {
                    return o1[1]-o2[1];
                }
                return o1[0]-o2[0];
            }
        });
        int idx = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.add(0);
        while(idx<N) {
            int temp = pq.poll();
            int[] chk = a.get(idx);

            if(chk[0]>=temp) {
                pq.add(chk[1]);
            }
            else {
                pq.add(temp);
                pq.add(chk[1]);
            }
            ++idx;
        }
        System.out.println(pq.size());

    }