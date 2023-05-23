import java.io.*;
import java.util.*;

//Boj 6137 gold4
public class Solution {
    static int N, M, K, ans;
    static int pi(String a) {
        return Integer.parseInt(a);
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        N = pi(br.readLine());
        char[] S = new char[N];
        for(int i=0; i<N; ++i) {
            S[i] = br.readLine().charAt(0);
        }
        String s = "";
        int left = 0, right = N-1;

        while(left<=right) {
            if(S[left]<S[right]) {
                s += S[left++];
            }
            else if(S[left]>S[right]) {
                s += S[right--];
            }
            else {
                int left1 = left+1;
                int right1 = right-1;
                boolean chk = true;
                while(left1<=right1) {
                    if(S[left1]<S[right1]) {
                        chk = true;
                        break;
                    }
                    else if(S[left1]>S[right1]) {
                        chk = false;
                        break;
                    }
                    else {
                        ++left1;
                        --right1;
                    }
                }
                if(chk) {
                    s += S[left++];
                }
                else {
                    s += S[right--];
                }
            }
        }
        for(int i=0; i<N; ++i) {
            sb.append(s.charAt(i));
            if(i!=0 && (i+1)%80==0 && i!=N-1) {
                sb.append("\n");
            }
        }
        System.out.println(sb);

    }

}