import java.io.*;
import java.util.*;

//Boj 7662 Gold4
public class Solution {
    static int D, N, M, ans;
    static boolean[] wrong;
    static int[][] map;
    static int[] parent;
    static int pi(String a) {
        return Integer.parseInt(a);
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = pi(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int n=0; n<N; ++n) {
            int k = pi(br.readLine());
            TreeMap<Integer, Integer> map = new TreeMap<>();

            for(int i=0; i<k; ++i) {
                String[] temp = br.readLine().split(" ");
                if(temp[0].equals("I")) {
                    map.put(pi(temp[1]), map.getOrDefault(pi(temp[1]), 0 )+1);
                }
                else {
                    if(map.size()==0) {
                        continue;
                    }
                    if(temp[1].equals("-1")) {
                        if(map.get(map.firstKey())==1) {
                            map.remove(map.firstKey());
                        }
                        else {
                            map.put(map.firstKey(), map.get(map.firstKey())-1);
                        }
                    }
                    else {
                        if(map.get(map.lastKey())==1) {
                            map.remove(map.lastKey());
                        }
                        else {
                            map.put(map.lastKey(), map.get(map.lastKey())-1);
                        }
                    }
                }
            }
            if(map.size()==0) {
                sb.append("EMPTY\n");
            }
            else {
                sb.append(map.lastKey() + " " + map.firstKey() + "\n");
            }
        }
        System.out.print(sb);
    }

}