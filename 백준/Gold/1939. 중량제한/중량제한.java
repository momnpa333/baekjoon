import java.io.*;
import java.util.*;

public class Main {
    static int N,M;
    static final int INF=1_000_000_001;
    static ArrayList<Item>[] graph;
    static int start,end;
    static PriorityQueue<Item> pq;
    static int[] visited;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N=Integer.parseInt(st.nextToken());
        M=Integer.parseInt(st.nextToken());

        graph=new ArrayList[N+1];
        visited=new int[N+1];

        for(int i=0;i<=N;i++){
            graph[i]=new ArrayList<>();
        }

        for(int i=0;i<M;i++){
            st=new StringTokenizer(br.readLine()," ");
            int A=Integer.parseInt(st.nextToken());
            int B=Integer.parseInt(st.nextToken());
            int C=Integer.parseInt(st.nextToken());
            graph[A].add(new Item(B,C));
            graph[B].add(new Item(A,C));
        }
        st=new StringTokenizer(br.readLine()," ");
        start=Integer.parseInt(st.nextToken());
        end=Integer.parseInt(st.nextToken());
        visited[start]=INF;
        pq=new PriorityQueue<>();

        pq.add(new Item(start,INF));

        while(!pq.isEmpty()){
//            System.out.println(pq);
            Item item=pq.poll();
            if(item.cap<visited[item.node]) continue;
            for(Item next:graph[item.node]){
                int nextCap=Math.min(item.cap,next.cap);
                if(nextCap>visited[next.node]){
                    pq.add(new Item(next.node,nextCap));
                    visited[next.node]=nextCap;
                }
            }
        }
        System.out.println(visited[end]);

    }
    static class Item implements Comparable<Item>{
        int node;
        int cap;
        Item(int node,int cap){
            this.node=node;
            this.cap=cap;
        }
        public int compareTo(Item o){
            return o.cap-this.cap;
        }
        public String toString(){
            return this.node+" "+this.cap;
        }
    }
}
