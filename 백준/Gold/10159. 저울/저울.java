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
        st=new StringTokenizer(br.readLine()," ");
        M=Integer.parseInt(st.nextToken());

        graph=new ArrayList[N+1];
        cnt=new int[N+1];
        for(int i=0;i<=N;i++){
            graph[i]=new ArrayList<>();
        }

        for(int i=0;i<M;i++){
            st=new StringTokenizer(br.readLine()," ");
            int A=Integer.parseInt(st.nextToken());
            int B=Integer.parseInt(st.nextToken());
            graph[B].add(A);
        }

        for(int i=1;i<=N;i++){
            visited=new boolean[N+1];
            dfs(i,i);
        }
//        System.out.println(Arrays.toString(cnt));
        for(int i=1;i<=N;i++){
            System.out.println(N-cnt[i]-1);
        }
    }
    static void dfs(int origin,int start){
        for(int child:graph[start]){
            if(visited[child]) continue;
            visited[child]=true;
            cnt[child]+=1;
            cnt[origin]+=1;
            dfs(origin,child);
        }
    }


}
