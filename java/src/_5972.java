import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class _5972 {
    static int N,M;
    static ArrayList<Item>[] graph;
    static int[] dist;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N=Integer.parseInt(st.nextToken()); M=Integer.parseInt(st.nextToken());

        graph=new ArrayList[N+1];
        dist=new int[N+1];
        Arrays.fill(dist,Integer.MAX_VALUE);

        for(int i=0;i<=N;i++){
            graph[i]=new ArrayList<>();
        }
        for(int i=0;i<M;i++){
            st=new StringTokenizer(br.readLine()," ");
            int v1,v2,value;
            v1=Integer.parseInt(st.nextToken());    v2=Integer.parseInt(st.nextToken());    value=Integer.parseInt(st.nextToken());
            graph[v1].add(new Item(v2,value));  graph[v2].add(new Item(v1,value));
        }
        dijkstra();
        System.out.println(dist[N]);

    }
    static void dijkstra(){
        PriorityQueue<Item> pq=new PriorityQueue<>();
        Item first=new Item(1,0);
        dist[1]=0;
        pq.add(first);

        while(!pq.isEmpty()){
            Item item=pq.poll();
            if(item.dist>dist[item.v]){
                continue;
            }
            for(Item child:graph[item.v]){
                if(item.dist+child.dist<dist[child.v]){
                    dist[child.v]=item.dist+child.dist;
                    pq.add(new Item(child.v,item.dist+child.dist));
                }
            }
        }

    }
    static class Item implements Comparable<Item>{
        int v;
        int dist;
        Item(int v,int dist){
            this.v=v;
            this.dist=dist;
        }

        public int compareTo(Item o){
            return this.dist<o.dist?-1:1;
        }
    }
}
