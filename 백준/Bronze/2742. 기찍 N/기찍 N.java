import java.io.*;
import java.sql.Array;
import java.util.*;

public class Main {
    static int N,M;
    static ArrayList<Integer>[] graph;
    static int[] cnt;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N=Integer.parseInt(st.nextToken());
        for(int i=N;i>0;i--){
            System.out.println(i);
        }
    }


}
