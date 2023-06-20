import java.io.*;
import java.util.*;

//Boj 9519 gold5
public class Solution {
    static int K, N, M, ans;
    static int pi(String a) {
        return Integer .parseInt(a);
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        N = pi(br.readLine());
        String tt = br.readLine();
        char[] S = tt.toCharArray();
        ArrayList<Character> a = new ArrayList<>();
        ArrayList<Character> b = new ArrayList<>();
        char[] T = S.clone();
        int len = S.length;
        for(int i=0; i<len; ++i) {
            a.add(S[i]);
            b.add(S[i]);
        }
        int c = 0;
        while(true) {
            Stack<Character> s = new Stack<>();
            ArrayList<Character> a_ = new ArrayList<>();
            ++c;
            for(int i=0; i<len; ++i) {
                if(i%2==1) {
                    s.add(b.get(i));
                }
                else {
                    a_.add(b.get(i));
                }
            }
            while(!s.isEmpty()) {
                a_.add(s.pop());
            }
            b = new ArrayList<>(a_);
            String chk = "";
            for(Character temp : b) {
                chk +=temp;
            }
            if(chk.equals(tt)) {
                break;
            }

        }
        N %=c;

        while(N>0) {
            Stack<Character> s = new Stack<>();
            ArrayList<Character> a_ = new ArrayList<>();
            for(int i=0; i<len; ++i) {
                if(i%2==1) {
                    s.add(a.get(i));
                }
                else {
                    a_.add(a.get(i));
                }
            }
            while(!s.isEmpty()) {
                a_.add(s.pop());
            }
            a = new ArrayList<>(a_);
            --N;
        }
        for(Character t : a) {
            System.out.print(t);
        }


    }

}