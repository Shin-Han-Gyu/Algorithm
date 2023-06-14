import java.io.*;
import java.util.*;

//Boj 3986 silver
public class Solution {
    static int K, N, M, ans;
    static int pi(String a) {
        return Integer.parseInt(a);
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        N = pi(br.readLine());

        while(N-- > 0) {
            Stack<Character> stk = new Stack<>();
            String str = br.readLine();
            boolean isGood = true;

            int len = str.length();
            for(int i = 0; i < len; i++) {
                char ch = str.charAt(i);
                if(stk.isEmpty()) {
                    stk.push(ch);
                }else {
                    if(stk.peek() == ch) {
                        stk.pop();
                    }else {
                        stk.push(ch);
                    }
                }
            }
            if(stk.isEmpty()) ans += 1;
        }
        System.out.println(ans);
    }


}