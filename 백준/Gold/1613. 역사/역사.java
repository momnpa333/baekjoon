import java.io.*;
import java.util.*;

public class Main {
    static int N,K;
    static boolean[][] graph;
    static boolean[][] path;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
        N=Integer.parseInt(st.nextToken());
        graph=new boolean[N+1][N+1];

        K=Integer.parseInt(st.nextToken());
        for(int i=0;i<K;i++){
            st=new StringTokenizer(br.readLine()," ");
            int s=Integer.parseInt(st.nextToken());
            int e=Integer.parseInt(st.nextToken());
            graph[s][e]=true;
        }
        makePath();
//        for(int i=1;i<=N;i++){
//            System.out.println(Arrays.toString(graph[i]));
//        }
        st=new StringTokenizer(br.readLine());
        int T=Integer.parseInt(st.nextToken());
        while(T-->0){
            st=new StringTokenizer(br.readLine()," ");
            int s=Integer.parseInt(st.nextToken());
            int e=Integer.parseInt(st.nextToken());
            System.out.println(solve(s,e));
        }

    }
    static int solve(int s,int e){
        if(graph[s][e]) return -1;
        if(graph[e][s]) return 1;
        return 0;
    }
    static void makePath(){
        for(int via=1;via<=N;via++){
            for(int s=1;s<=N;s++){
                for(int e=1;e<=N;e++){
                    if(graph[s][via] && graph[via][e]){
                        graph[s][e]=true;
                    }
                }
            }
        }
    }
}