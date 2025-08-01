import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class _18352 {
    static int N,M,K,X;
    static ArrayList<Integer>[] graph;
    static int[] dist;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


        N=Integer.parseInt(st.nextToken());
        M=Integer.parseInt(st.nextToken());
        K=Integer.parseInt(st.nextToken());
        X=Integer.parseInt(st.nextToken());

        graph=new ArrayList[N+1];
        dist=new int[N+1];
        Arrays.fill(dist,Integer.MAX_VALUE);
        for(int i=0;i<=N;i++){
            graph[i]=new ArrayList<>();
        }
        for(int i=0;i<M;i++){
            st=new StringTokenizer(br.readLine()," ");
            int v1,v2;
            v1=Integer.parseInt(st.nextToken()); v2=Integer.parseInt(st.nextToken());
            graph[v1].add(v2);
        }
        dijkstra();
        int cnt=0;
        for(int i=1;i<=N;i++){
            if(dist[i]==K){
                System.out.println(i);
                cnt++;
            }
        }
        if(cnt==0){
            System.out.println(-1);
        }

    }
    static void dijkstra(){
        PriorityQueue<Item> pq=new PriorityQueue<>();
        Item start=new Item(X,0);
        dist[X]=0;
        pq.add(start);

        while(!pq.isEmpty()){
            Item item=pq.poll();
            if(item.dist>dist[item.v]){
                continue;
            }

            for(int v:graph[item.v]){
                if(item.dist+1<dist[v]){
                    dist[v]=item.dist+1;
                    pq.add(new Item(v,dist[v]));
                }
            }
        }

    }

    static class Item implements Comparable<Item>{
        int dist;
        int v;
        Item(int v,int dist){
            this.dist=dist;
            this.v=v;
        }
        public int compareTo(Item o) {
            return this.dist<o.dist?-1:1;
        }
    }

}
