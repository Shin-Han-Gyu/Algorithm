import java.io.*;
import java.util.*;

//Boj 1717 gold5
public class Main {
    static int N, M, ans;
    static int[] parents;
    static int pi(String a) {
        return Integer.parseInt(a);
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] temp = br.readLine().split(" ");
        N = pi(temp[0]);
        M = pi(temp[1]);
        StringBuilder sb = new StringBuilder();
        parents = new int[N+1];

        for(int i=0; i<N+1; ++i) {
            parents[i] = i;
        }

        for(int i=0; i<M; ++i) {
            temp = br.readLine().split(" ");

            if(temp[0].equals("1")) {
                if(find(pi(temp[1]))==find(pi(temp[2]))) {
                    sb.append("YES\n");
                }
                else {
                    sb.append("NO\n");
                }
            }
            else {
                union(pi(temp[1]), pi(temp[2]));
            }
        }
        System.out.print(sb);
    }

    static void union(int x, int y) {
        int temp_x = find(x);
        int temp_y = find(y);
        if(temp_x==temp_y) {
            return;
        }

        if(temp_y<temp_x) {
            parents[temp_x] = temp_y;
        }
        else {
            parents[temp_y] = temp_x;
        }
    }
    static int find(int x) {
        if(parents[x] == x) {
            return x;
        }
        return parents[x]=find(parents[x]);
    }
}import java.io.*;
import java.util.*;

//Boj 1717 gold5
public class Main {
    static int N, M, ans;
    static int[] parents;
    static int pi(String a) {
        return Integer.parseInt(a);
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] temp = br.readLine().split(" ");
        N = pi(temp[0]);
        M = pi(temp[1]);
        StringBuilder sb = new StringBuilder();
        parents = new int[N+1];

        for(int i=0; i<N+1; ++i) {
            parents[i] = i;
        }

        for(int i=0; i<M; ++i) {
            temp = br.readLine().split(" ");

            if(temp[0].equals("1")) {
                if(find(pi(temp[1]))==find(pi(temp[2]))) {
                    sb.append("YES\n");
                }
                else {
                    sb.append("NO\n");
                }
            }
            else {
                union(pi(temp[1]), pi(temp[2]));
            }
        }
        System.out.print(sb);
    }

    static void union(int x, int y) {
        int temp_x = find(x);
        int temp_y = find(y);
        if(temp_x==temp_y) {
            return;
        }

        if(temp_y<temp_x) {
            parents[temp_x] = temp_y;
        }
        else {
            parents[temp_y] = temp_x;
        }
    }
    static int find(int x) {
        if(parents[x] == x) {
            return x;
        }
        return parents[x]=find(parents[x]);
    }
}