import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static ArrayList<Integer>[] graph;
    static boolean[] visited;
    static int answer=1;
    static int leafCnt;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N=Integer.parseInt(st.nextToken());

        graph=new ArrayList[N];
        visited=new boolean[N];

        for(int i=0;i<N;i++){
            graph[i]=new ArrayList<>();
        }

        for(int i=0;i<N-1;i++){
            st=new StringTokenizer(br.readLine()," ");
            int s,e;
            s=Integer.parseInt(st.nextToken());
            e=Integer.parseInt(st.nextToken());

            graph[s].add(e);
            graph[e].add(s);
        }

        for(int i=0;i<N;i++){
            if(graph[i].size()==1){
                leafCnt++;
            }
        }
        if(leafCnt%2==0){
            System.out.println(leafCnt/2);
        }
        else{
            System.out.println(leafCnt/2+1);
        }
    }
    static void solve(int node){
//        System.out.println(node+" "+answer);
        visited[node]=true;
        int cnt=0;
        for(int next:graph[node]){
            if(!visited[next]){
                solve(next);
                cnt++;
                if(cnt>1){
                    answer++;
                }
            }
        }
    }
    static int findLeaf(int node){
        visited[node]=true;
        for(int next:graph[node]){
            if(!visited[next]){
                return findLeaf(next);
            }
        }
        return node;
    }
}
