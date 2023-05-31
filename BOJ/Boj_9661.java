import java.io.*;

//Boj 9661 gold4
public class Solution {
    static int N, M, K, ans;
    static int pi(String a) {
        return Integer.parseInt(a);
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        double c = Double.parseDouble(br.readLine());

        //
        if(c%5==0 || c%5==2) {
            System.out.println("CY");
        }
        else {
            System.out.println("SK");
        }
    }

}
