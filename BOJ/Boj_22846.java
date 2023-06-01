import java.io.*;

//Boj 22846 gold3
public class Solution {
    static int N, M, K, ans;
    static int pi(String a) {
        return Integer.parseInt(a);
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        K = pi(br.readLine());
        if(K==2 || K==6) {
            System.out.println("Kali");
        }
        else {
            System.out.println("Ringo");
        }

    }

}