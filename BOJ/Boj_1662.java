import java.io.*;
import java.util.*;

//Boj 1662 gold5
public class Solution {
    static int N, M, ans;
    static int pi(String a) {
        return Integer.parseInt(a);
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String a = br.readLine();
        Stack<Integer> chk = new Stack<>();
        Stack<Integer> times = new Stack<>();

        for(int i=0;i<a.length();++i){
            char c = a.charAt(i);
            if(c=='('){
                ans-=1;
                int num = a.charAt(i-1)-'0';
                chk.add(ans);
                times.add(num);
                ans=0;
            }
            else if(c==')'){
                int temp = !times.isEmpty() ? times.pop() : 0;
                temp*=ans;
                int plus = !chk.isEmpty() ? chk.pop() : 0;
                ans = plus + temp;
            }
            else {
                ++ans;
            }
        }
        System.out.print(ans);
    }

}