import java.io.*;

//Boj 9012 silver4
public class Main {
    static int K, N, M, ans;
    static int pi(String a) {
        return Integer.parseInt(a);
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = pi(br.readLine());

        for(int i=0; i<N; ++i) {
            String a = br.readLine();
            int chk = 0;
            boolean flag = false;
            for(int j=0; j<a.length(); ++j) {
                if(a.charAt(j)=='(') {
                    ++chk;
                }
                else {
                    --chk;
                }
                if(chk<0) {
                    break;
                }
            }
            if(chk!=0) {
                System.out.println("NO");
            }
            else {
                System.out.println("YES");
            }
        }

    }

}