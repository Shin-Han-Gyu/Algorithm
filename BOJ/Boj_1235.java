import java.io.*;
import java.util.*;

//Boj
// https://www.acmicpc.net/problem/
public class Main {
    static int K, N, M, ans;
    static int pi(String a) {
        return Integer.parseInt(a);
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        N = pi(br.readLine());
        String[] stud = new String[N];
        HashSet<String> set = new HashSet<>();

        for(int n=0; n<N; ++n) {
            stud[n] = br.readLine();
        }

        for(int i=1; i<stud[0].length()+1; ++i) {
            boolean chk = true;
            for(int j=0; j<stud.length; ++j) {
                String temp = stud[j].substring(stud[j].length()-i);
                if(set.contains(temp)) {
                    chk = false;
                    break;
                }
                set.add(temp);
            }
            if(chk) {
                System.out.println(i);
                break;
            }
        }


    }

}