import java.io.*;
import java.util.*;

public class Main {
    static ArrayList<Integer>[] graph;
    static boolean[] visited;
    static int[] childDepth;
    static int N,S,D;
    static int answer;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
//        BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
        N=Integer.parseInt(st.nextToken());
        S=Integer.parseInt(st.nextToken());
        D=Integer.parseInt(st.nextToken());

        graph=new ArrayList[N+1];
        visited=new boolean[N+1];
        childDepth=new int[N+1];
        visited[S]=true;

        for(int i=0;i<=N;i++){
            graph[i]=new ArrayList<>();
        }

        for(int i=0;i<N-1;i++){
            st=new StringTokenizer(br.readLine()," ");
            int x=Integer.parseInt(st.nextToken());
            int y=Integer.parseInt(st.nextToken());
            graph[x].add(y);
            graph[y].add(x);
        }
        dfs(S);
        Arrays.fill(visited,false);
        visited[S]=true;
        solve(S);
        System.out.println(answer*2);

    }
    static void solve(int node){
        for(int next:graph[node]){
            if(!visited[next] && childDepth[next]>=D){
                visited[next]=true;
                answer++;
                solve(next);
            }
        }
    }
    static int dfs(int node){
//        System.out.println(node);
        int depth=0;
        for(int next:graph[node]){
            if(!visited[next]){
                visited[next]=true;
                depth=Math.max(dfs(next),depth);
            }
        }
        childDepth[node]=depth;
        return depth+1;
    }

}


