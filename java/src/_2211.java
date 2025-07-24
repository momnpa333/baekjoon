import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.StringTokenizer;

public class _2211 {
    static int N,M;
    static ArrayList<Item>[] graph;
    static int[] dist;
    static String[] hist;
    static Set<String> answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


        N=Integer.parseInt(st.nextToken()); M=Integer.parseInt(st.nextToken());
        dist=new int[N+1]; hist=new String[N+1];
        Arrays.fill(dist,Integer.MAX_VALUE);
        hist[1]="1";
        graph=new ArrayList[N+1];
        answer=new HashSet<>();

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
//        System.out.println(Arrays.toString(hist));
        for(int i=2;i<=N;i++){
            String[] tmp=hist[i].split(" ");
//            System.out.println(Arrays.toString(tmp));
            for(int j=0;j<tmp.length-1;j++){
                answer.add(tmp[j]+" "+tmp[j+1]);
            }
        }
        System.out.println(answer.size());
        for(String s:answer){
            System.out.println(s);
        }

    }
    static void dijkstra(){
        PriorityQueue<Item> pq= new PriorityQueue<>();
        Item first=new Item(1,0);
        dist[1]=0;
        pq.add(first);

        while(!pq.isEmpty()){
            Item item=pq.poll();
            if(item.dist>dist[item.v]){
                continue;
            }
            for(Item child:graph[item.v]){
                if(child.dist+item.dist<dist[child.v]){
                    dist[child.v]=child.dist+item.dist;
                    pq.add(new Item(child.v,child.dist+item.dist));
                    hist[child.v]=hist[item.v]+" "+child.v;
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
            return this.dist-o.dist;
        }

    }
}
