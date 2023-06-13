import java.io.*;
import java.util.*;

//Boj 1205 
public class Main {
    static int N, M, T, ans;
    static int pi(String a) {
        return Integer.parseInt(a);
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String[] temp = br.readLine().split(" ");
        N = pi(temp[0]);
        M = pi(temp[1]);
        T = pi(temp[2]);
        if(N==0) {
            System.out.println(1);
            return;
        }
        Integer[] map = new Integer[N];
        temp = br.readLine().split(" ");
        for(int i=0; i<N; ++i) {
            map[i] = pi(temp[i]);
        }
        
        for(int i=0; i<N; ++i) {
            if (map[i] <= M) {
                if(map[i] == M && N == T) {
                    boolean flag = true;
                    for(int j = i+1; j < N; ++j) {
                        if(map[i] > map[j]) {
                            flag = false;
                            break;
                        }
                    }
                    
                    if(flag) {
                        System.out.println("-1");
                        return;
                    }
                    
                }
                System.out.println(i+1);
                return;
            }
            
        }
        if(N < T) {
            System.out.println(N+1);
            return;
        }

        System.out.println("-1");
    }

}