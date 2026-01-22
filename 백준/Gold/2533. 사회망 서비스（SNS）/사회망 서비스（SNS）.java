import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static ArrayList<Integer>[] graph;
    static int[][] dp;
    static boolean[] visited;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));

        N=Integer.parseInt(st.nextToken());
        graph=new ArrayList[N+1];
        dp=new int[N+1][2];
        visited=new boolean[N+1];

        for(int i=0;i<=N;i++){
            graph[i]=new ArrayList<>();
        }

        for(int i=0;i<N-1;i++){
            st=new StringTokenizer(br.readLine()," ");
            int A,B;
            A=Integer.parseInt(st.nextToken());
            B=Integer.parseInt(st.nextToken());
            graph[A].add(B); graph[B].add(A);
        }

        visited[1]=true;
        dfs(1);
//        for(int i=0;i<=N;i++){
//            System.out.println(Arrays.toString(dp[i]));
//        }
        System.out.println(Math.min(dp[1][0],dp[1][1]));
    }
    static void dfs(int tar){
        dp[tar][1]+=1;
        for(int child:graph[tar]){
            if(!visited[child]){
                visited[child]=true;
                dfs(child);
                dp[tar][0]+=dp[child][1];
                dp[tar][1]+=Math.min(dp[child][0],dp[child][1]);
            }
        }
    }


}

