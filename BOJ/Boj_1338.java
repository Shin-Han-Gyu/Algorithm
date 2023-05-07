import java.io.*;

//Boj 1338 gold4
public class Solution {
    static int N, M, K, ans;
    static int pi(String a) {
        return Integer.parseInt(a);
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] temp = br.readLine().split(" ");
        long n,m,x,y;
        n = pi(temp[0]);
        m = pi(temp[1]);
        if(m < n) {
            long t = n;
            n = m;
            m = t;
        }
        temp = br.readLine().split(" ");
        x = pi(temp[0]);
        y = pi(temp[1]);
        x = Math.abs(x);
        if(x<=y || y<0) {
            System.out.println("Unknwon Number");
            return;
        }
        long chk = n + (y-n%x)%x;

        if((chk< n || chk> m) || (chk+Math.abs(x)<= m && chk+Math.abs(x)>= n) || (chk-Math.abs(x)<= m && chk-Math.abs(x)>= n)) {
            System.out.println("Unknwon Number");
        }
        else {
            System.out.println(chk);
        }

    }

}