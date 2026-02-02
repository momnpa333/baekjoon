import java.io.*;
import java.util.*;

public class Main {
    static int N,M;
    static int S,E;
    static List<Integer>[] graph;
    static ArrayDeque<Item> pq;
    static int[] prev;
    static boolean[] visited;
    static int answer;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N=Integer.parseInt(st.nextToken());
        M=Integer.parseInt(st.nextToken());
        prev=new int[N+1];
        visited=new boolean[N+1];
        pq=new ArrayDeque<>();

        graph=new ArrayList[N+1];
        for(int i=0;i<=N;i++){
            graph[i]=new ArrayList<>();
        }
        for(int i=0;i<M;i++){
            st=new StringTokenizer(br.readLine()," ");
            int A,B;
            A=Integer.parseInt(st.nextToken());
            B=Integer.parseInt(st.nextToken());
            graph[A].add(B);
            graph[B].add(A);
        }
        for(int i=0;i<=N;i++){
            graph[i].sort(Integer::compareTo);
        }
        st=new StringTokenizer(br.readLine()," ");
        S=Integer.parseInt(st.nextToken());
        E=Integer.parseInt(st.nextToken());

        pq.add(new Item(S,0));
        prev[S]=-1;
        A:
        while(!pq.isEmpty()){
            Item item=pq.poll();
            for(int next:graph[item.node]){
                if(prev[next]==0){
                    prev[next]=item.node;
                    pq.add(new Item(next,item.length+1));
                }
                if(next==E){
                    answer=item.length+1;
                    break A;
                }
            }
        }
        checkVisit(E);
        pq=new ArrayDeque<>();
        pq.add(new Item(E,0));
        visited[S]=false;
        visited[E]=true;
        B:
        while(!pq.isEmpty()){
            Item item=pq.poll();
            for(int next:graph[item.node]){
                if(!visited[next]){
                    visited[next]=true;
                    pq.add(new Item(next,item.length+1));
                }
                if(next==S){
                    answer+=item.length+1;
                    break B;
                }
            }
        }
        System.out.println(answer);

    }
    static void checkVisit(int node){
        if(node==S) return;
        visited[node]=true;
        checkVisit(prev[node]);
    }
    static class Item implements Comparable<Item>{
        int node;
        int length;
        Item(int n,int l){
            node=n;
            length=l;
        }

        public int compareTo(Item o) {
            if(this.length==o.length){
                return this.node-o.node;
            }
            return this.length-o.length;
        }
    }
}

