import java.io.*;
import java.util.*;

//Boj 25955 silver 4
// https://www.acmicpc.net/problem/25955
public class Main {
    static int K, N, M, ans;
    static int pi(String a) {
        return Integer.parseInt(a);
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        N = pi(br.readLine());
        String[] A = br.readLine().split(" ");
        String[] A_ = A.clone();
        HashMap<Character, Integer> map = new HashMap<>();
        map.put('B', 1);
        map.put('S', 2);
        map.put('G', 3);
        map.put('P', 4);
        map.put('D', 5);
        // B S G P D

        Arrays.sort(A_, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if(map.get(o1.charAt(0)) == map.get(o2.charAt(0))) {
                    return pi(o2.substring(1)) - pi(o1.substring(1));
                }
                return map.get(o1.charAt(0)) - map.get(o2.charAt(0));
            }
        });

        boolean chk = true;
        for(int i=0; i<N; ++i) {
            if(!A_[i].equals(A[i])) {
                chk = false;
                sb.append(A_[i] + " " + A[i]);
                break;
            }
        }
        if(chk) {
            System.out.println("OK");
        }
        else {
            System.out.println("KO");
            System.out.println(sb);
        }

    }

}