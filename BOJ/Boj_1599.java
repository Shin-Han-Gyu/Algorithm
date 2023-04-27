import java.io.*;
import java.util.*;

//Boj 1599 gold5
public class Solution {
    static int T, N, M, ans;
    static int[][] map;
    static int[] parents, sizes;
    static int pi(String a) {
        return Integer.parseInt(a);
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = pi(br.readLine());

        String[] minsik = "a b k d e g h i l m n z o p r s t u w y".split(" ");
        HashMap<Character, Integer> map = new HashMap<>();
        for(int i=0; i<20; ++i) {
            map.put(minsik[i].charAt(0), i);
        }
        PriorityQueue<String> pq = new PriorityQueue<>(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                int temp_1 = o1.length();
                int temp_2 = o2.length();
                int len = Math.min(temp_1, temp_2);
                for(int i=0; i<len; ++i) {
                    if(map.get(o1.charAt(i))<map.get(o2.charAt(i))) {
                        return -1;
                    }
                    else if(map.get(o1.charAt(i))>map.get(o2.charAt(i))) {
                        return 1;
                    }
                }
                return temp_1 - temp_2;
            }
        });
        for(int i=0; i<N; ++i) {
            String temp = br.readLine();
            temp = temp.replaceAll("ng", "z");
            pq.add(temp);
        }

        while(!pq.isEmpty()) {
            System.out.println(pq.poll().replaceAll("z", "ng"));
        }
    }


}