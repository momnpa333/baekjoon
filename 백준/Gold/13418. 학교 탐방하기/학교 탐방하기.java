import java.io.*;
import java.util.*;

public class Main {
    static int N,M;
    static ArrayList<Node>[] graph;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N=Integer.parseInt(st.nextToken());
        M=Integer.parseInt(st.nextToken());
        graph=new ArrayList[N+1];
        for(int i=0;i<=N;i++){
            graph[i]=new ArrayList<>();
        }
        for(int i=0;i<=M;i++){
            st=new StringTokenizer(br.readLine()," ");
            int s=Integer.parseInt(st.nextToken());
            int e=Integer.parseInt(st.nextToken());
            int op=Integer.parseInt(st.nextToken());

            graph[s].add(new Node(s,e,op));
            graph[e].add(new Node(e,s,op));
        }
        System.out.println(findValue(1)-findValue(-1));

    }
    static int findValue(int version){
        int[] parents=new int[N+1];
        for(int i=0;i<=N;i++){
            parents[i]=i;
        }
        int ans=0;
        PriorityQueue<Node> pq=new PriorityQueue<>((o1, o2) -> version*(o1.op-o2.op));
        pq.add(new Node(-1,0,1));
        while(!pq.isEmpty()){
//            System.out.println(pq);
            Node item=pq.poll();
            if(item.s!=-1 && !isConnect(item.s,item.e,parents)) continue;
//            System.out.println(item.s+" "+item.e+" "+item.op);
            if(item.op==0){
                ans++;
            }
            for(Node next:graph[item.e]){
                pq.add(new Node(next.s,next.e,next.op));
            }
        }
        return ans*ans;
    }
    static boolean isConnect(int s,int e,int parents[]){
        int a=findParent(s,parents);
        int b=findParent(e,parents);
        if(a==b) {
            return false;
        }
        if(a<b){
            parents[b]=a;
        }
        else{
            parents[a]=b;
        }
        return true;
    }
    static int findParent(int v,int parents[]){
        if(v!=parents[v]){
            return parents[v]=findParent(parents[v],parents);
        }
        return v;
    }
    static class Node{
        int s;
        int e;
        int op;
        Node(int s,int e,int op){
            this.s=s;
            this.e=e;
            this.op=op;
        }
        public String toString(){
            return s+" "+e+" "+op;
        }
    }
}