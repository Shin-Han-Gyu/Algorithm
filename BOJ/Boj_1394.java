import java.io.*;

//Boj 1394 gold5
public class Solution {
    static int N, M, ans;

    static int pi(String a) {
        return Integer.parseInt(a);
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String a = br.readLine();
        int cnt = 0;
        int[] key = new int[128];
        for(int i=0; i<a.length(); ++i) {
            key[a.charAt(i)] = ++cnt;
        }
        a = br.readLine();
        int chk=1;

        for(int i = a.length()-1; i>-1; --i) {
            ans = (ans + chk*key[a.charAt(i)]) % 900528;
            chk = chk*cnt%900528;
        }
        System.out.println(ans);
    }

}