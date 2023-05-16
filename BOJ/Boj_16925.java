import java.io.*;
import java.util.*;

//Boj 16925 gold5
public class Solution {
    static int N, M, K, ans;
    static int pi(String a) {
        return Integer.parseInt(a);
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = pi(br.readLine());
        ArrayList<String> arr = new ArrayList<>();
        ArrayList<String> head = new ArrayList<>();
        ArrayList<String> tail = new ArrayList<>();
        ArrayList<String> head1 = new ArrayList<>();
        ArrayList<String> tail1 = new ArrayList<>();
        String[] chk = new String[2];
        int idx = -1;
        String sen ="", sen1="";
        for(int i=0; i<N*2-2; ++i) {
            String temp = br.readLine();
            arr.add(temp);

            if(temp.length()==N-1) {
                chk[++idx] = temp;
            }

        }
        String a = chk[0];
        String b = chk[1];
        if(N==2) {
            System.out.println(a+b);
            System.out.print("PS");
            return;
        }
        sen = b.charAt(0) + a;

        sen1 = a.charAt(0) + b;

        for(int i=1; i<sen.length(); ++i) {
            head.add(sen.substring(0, i));
            head1.add(sen1.substring(0, i));
        }

        for(int i=sen.length()-1; i>0; --i) {
            tail.add(sen.substring(i, sen.length()));
            tail1.add(sen1.substring(i, sen1.length()));
        }
        int s_=0,p_=0;
        StringBuilder sb = new StringBuilder();
        sb.append(sen + "\n");
        Set<String> set = new HashSet<>();
        for(String s : arr) {
            if(head.contains(s)) {
                if(set.contains(s)){
                    ++s_;
                    sb.append("S");
                    continue;
                }
                set.add(s);
                sb.append("P");
                ++p_;
            }
            else if(tail.contains(s)){
                sb.append("S");
                ++s_;
            }
        }
        if(s_!=p_ || s_+p_!=2*N-2) {
            sb = new StringBuilder();
            sb.append(sen1 + "\n");
            set = new HashSet<>();

            for(String s : arr) {
                if(head1.contains(s)) {
                    if(set.contains(s)){
                        sb.append("S");
                        continue;
                    }
                    set.add(s);
                    sb.append("P");
                }
                else if(tail1.contains(s)){
                    sb.append("S");
                }
            }
        }
        System.out.println(sb);

    }

}