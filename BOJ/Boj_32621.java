import java.io.*;
import java.util.*;

//Boj 32621 bronze2
public class Main {
    static int K, N, M, ans;
    static int pi(String a) {
        return Integer.parseInt(a);
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String a = br.readLine();
        if(!a.contains("+") || a.length()%2==0 || a.length()==1) {
            System.out.println("No Money");
            return;
        }
        String[] temp = a.split("\\+");
        if(temp[0].charAt(0)=='0' || temp[1].charAt(0)=='0') {
            System.out.println("No Money");
            return;
        }
        try{
            K = Integer.parseInt(temp[0]);
            N = Integer.parseInt(temp[1]);
        }
        catch(Exception e){
            System.out.println("No Money");
            return;
        }
        if(K==N) {
            System.out.println("CUTE");
        }
        else {
            System.out.println("No Money");
        }

    }
}