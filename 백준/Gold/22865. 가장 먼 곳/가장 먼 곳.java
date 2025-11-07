import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int A,B,C;
    static int M;
    static ArrayList<Node>[] graph;
    static long[] ans;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N=Integer.parseInt(st.nextToken());
        graph=new ArrayList[N+1];
        ans=new long[N+1];
        Arrays.fill(ans,Long.MAX_VALUE);
        for(int i=0;i<=N;i++){
            graph[i]=new ArrayList<>();
        }
        st=new StringTokenizer(br.readLine()," ");
        A=Integer.parseInt(st.nextToken());
        B=Integer.parseInt(st.nextToken());
        C=Integer.parseInt(st.nextToken());
        st=new StringTokenizer(br.readLine()," ");
        M=Integer.parseInt(st.nextToken());
        for(int i=0;i<M;i++){
            st=new StringTokenizer(br.readLine()," ");
            int S=Integer.parseInt(st.nextToken());
            int E=Integer.parseInt(st.nextToken());
            long L=Integer.parseInt(st.nextToken());
            graph[S].add(new Node(E,L));
            graph[E].add(new Node(S,L));
        }

//        for(int i=0;i<=N;i++){
//            System.out.println(graph[i]);
//        }
        dijkstra(A);
        dijkstra(B);
        dijkstra(C);


//        System.out.println(Arrays.toString(ans));
        int land=0;
        long l=-1;
        for(int i=1;i<=N;i++){
            if(ans[i]>l){
                land=i;
                l=ans[i];
            }
        }
        System.out.println(land);

    }
    static void dijkstra(int s){
        long[] dist=new long[N+1];
        Arrays.fill(dist,Long.MAX_VALUE);

        PriorityQueue<Node> pq=new PriorityQueue<>();
        pq.add(new Node(s,0));
        dist[s]=0;

        while(!pq.isEmpty()){
//            System.out.println(pq);
            Node item=pq.poll();

            if(item.length>dist[item.v]) continue;
            for(Node next:graph[item.v]){
                if(next.length+item.length<dist[next.v]){
                    dist[next.v]=next.length+item.length;
                    pq.add(new Node(next.v, next.length+item.length));
                }
            }
        }
        for(int i=0;i<=N;i++){
            ans[i]=Math.min(ans[i],dist[i]);
        }
    }
    static class Node implements Comparable<Node>{
        int v;
        long length;
        Node(int v,long length){
            this.v=v;
            this.length=length;
        }
        public int compareTo(Node o){
            if(this.length<o.length) return -1;
            return 1;
        }
        public String toString(){
            return v+" "+length;
        }
    }
}