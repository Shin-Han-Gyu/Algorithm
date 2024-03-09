import java.io.*;
import java.util.*;

//Boj 10866 silver4
public class Main {
    static int N, M, K, T, Ans;
    static int pi(String a) {
        return Integer.parseInt(a);
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        N = pi(br.readLine());
        Deque<Integer> dq = new ArrayDeque<>();

        for(int i=0; i<N; ++i) {
            String[] a = br.readLine().split(" ");

            if(a[0].equals("push_back")) {
                dq.addLast(pi(a[1]));
            }
            else if(a[0].equals("push_front")) {
                dq.addFirst(pi(a[1]));
            }
            else if(a[0].equals("pop_front")) {
                if(dq.isEmpty()) {
                    System.out.println(-1);
                }
                else {
                    System.out.println(dq.pollFirst());
                }
            }
            else if(a[0].equals("pop_back")) {
                if(dq.isEmpty()) {
                    System.out.println(-1);
                }
                else {
                    System.out.println(dq.pollLast());
                }
            }
            else if(a[0].equals("size")) {
                System.out.println(dq.size());
            }
            else if(a[0].equals("empty")) {
                System.out.println(dq.isEmpty() ? 1 : 0);
            }
            else if(a[0].equals("front")) {
                if(dq.isEmpty()) {
                    System.out.println(-1);
                }
                else {
                    System.out.println(dq.peekFirst());
                }
            }
            else if(a[0].equals("back")) {
                if(dq.isEmpty()) {
                    System.out.println(-1);
                }
                else {
                    System.out.println(dq.peekLast());
                }
            }
        }
    }

}