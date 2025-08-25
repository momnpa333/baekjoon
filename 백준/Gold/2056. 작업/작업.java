import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static ArrayList<Integer>[] graph;
    static int[] costs;
    static boolean[] visited;
    static int[] dp;
    static int answer;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N=Integer.parseInt(st.nextToken());

        graph=new ArrayList[N+1];
        costs=new int[N+1];
        visited=new boolean[N+1];
        dp=new int[N+1];
        for(int i=0;i<=N;i++){
            graph[i]=new ArrayList<>();
        }

        for(int i=1;i<=N;i++){
            st=new StringTokenizer(br.readLine()," ");
            costs[i]=Integer.parseInt(st.nextToken());
            int M=Integer.parseInt(st.nextToken());
            for(int j=0;j<M;j++){
                graph[i].add(Integer.parseInt(st.nextToken()));
            }
        }
        for(int i=N;i>=1;i--){
//            System.out.println(i);
            if(!visited[i]){
                answer=Math.max(answer,getTime(i));
            }
        }
        System.out.println(answer);
    }

    static int getTime(int num){
        if(dp[num]!=0){
            return dp[num];
        }
        int last=0;
        for(int task:graph[num]){
            last=Math.max(last,getTime(task));
        }
        dp[num]=last+costs[num];
        visited[num]=true;
        return dp[num];
    }
}
