import java.io.*;
import java.util.*;

public class Main {
    static int N,K;

    static Node[] nodes;
    static int ans;
    static int[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N=Integer.parseInt(st.nextToken());
        K=Integer.parseInt(st.nextToken());

        visited=new int[N+2];
        nodes=new Node[N+2];
        nodes[0]=new Node(0,0);
        nodes[N+1]=new Node(10000,10000);
        for(int i=1;i<=N;i++){
            st=new StringTokenizer(br.readLine()," ");
            int x=Integer.parseInt(st.nextToken());
            int y=Integer.parseInt(st.nextToken());
            nodes[i]=new Node(x,y);
        }
        Arrays.fill(visited,Integer.MAX_VALUE);

        PriorityQueue<Item> pq=new PriorityQueue<>();
//        System.out.println(getOil(2,1,37,43));
        ans=Integer.MAX_VALUE;
        pq.add(new Item(0,0,0));
        while(!pq.isEmpty()){
            Item item=pq.poll();
            if(item.jump>K || item.oil>=ans) continue;
            for(int i=0;i<=N+1;i++){
                int cur=Math.max(item.oil,getOil(item.v,i));
                if(cur<visited[i]){
                    if(i==N+1){
                        visited[i]=cur;
                        ans=Math.min(cur,ans);
                    }
                    else{
                        visited[i]=cur;
                        pq.add(new Item(i,cur,item.jump+1));
                    }
                }
            }
        }
        System.out.println(ans);

    }
    static int getOil(int i1,int i2){
        int x1=nodes[i1].x;
        int y1=nodes[i1].y;
        int x2=nodes[i2].x;
        int y2=nodes[i2].y;
        double l=Math.sqrt(Math.pow(x2-x1,2)+Math.pow(y2-y1,2));
        return (int) Math.ceil(l/10);
    }

    static class Item implements Comparable<Item>{
        int v,oil,jump;
        Item(int v,int o,int j){
            this.v=v;
            this.oil=o;
            this.jump=j;
        }
        public int compareTo(Item o){
            return this.oil-o.oil;
        }
    }
    static class Node{
        int x,y;
        Node(int x,int y){
            this.x=x;
            this.y=y;
        }
    }

}
