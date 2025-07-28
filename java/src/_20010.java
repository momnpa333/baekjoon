
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class _20010 {
    static int N,K;
    static ArrayList<Bridge> bridges;
    static int[] parent;
    static ArrayList<Item>[] graph;
    static long[] length;
    static int target;
    static long answer1;
    static long answer2;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N=Integer.parseInt(st.nextToken())-1;
        K=Integer.parseInt(st.nextToken());

        length=new long[N+1];
        parent=new int[N+1];
        for(int i=0;i<=N;i++){
            parent[i]=i;
        }
        graph=new ArrayList[N+1];
        for(int i=0;i<=N;i++){
            graph[i]=new ArrayList<>();
        }
        bridges=new ArrayList<>();

        for(int i=0;i<K;i++){
            st=new StringTokenizer(br.readLine()," ");
            int v1=Integer.parseInt(st.nextToken());    int v2=Integer.parseInt(st.nextToken()); int value=Integer.parseInt(st.nextToken());
            bridges.add(new Bridge(v1,v2,value));
        }

        bridges.sort(Bridge::compareTo);

//        System.out.println(bridges);

        mst();
        dijkstra(0);
//        System.out.println(target);
//        System.out.println(Arrays.toString(length));
        dijkstra(target);
//        System.out.println(Arrays.toString(length));

        for(int i=0;i<=N;i++){
            answer2=Math.max(answer2,length[i]);
        }
        System.out.println(answer1);
        System.out.println(answer2);

    }
    static void dijkstra(int start){
        Arrays.fill(length,Long.MAX_VALUE);
        length[start]=0;
        PriorityQueue<Item> pq = new PriorityQueue<>();
        Item first=new Item(start,0);
        pq.add(first);

        while (!pq.isEmpty()){
            Item item=pq.poll();
            if(item.length>length[item.v]){
                continue;
            }
            for(Item child:graph[item.v]){
                if(item.length+ child.length<length[child.v]){
                    length[child.v]=item.length+child.length;
                    pq.add(new Item(child.v,item.length+child.length ));
                }
            }
        }
        long tmp=Long.MIN_VALUE;
        for(int i=0;i<=N;i++){
            if(length[i]>tmp){
                target=i;
                tmp=length[i];
            }
        }

    }
    static void mst(){
        for(Bridge b:bridges){
//            System.out.printf("%d: %d -- %d: %d\n",b.v1,findParent(b.v1),b.v2,findParent(b.v2));
            if(findParent(b.v1)!=findParent(b.v2)){
                union(b.v1,b.v2);
                graph[b.v1].add(new Item(b.v2,b.value));
                graph[b.v2].add(new Item(b.v1,b.value));
                answer1+=b.value;
            }
        }
    }
    static void union(int A,int B){
        int parentA=findParent(A);
        int parentB=findParent(B);
        if(parentA<parentB){
            parent[parentB]=parentA;
        }
        else{
            parent[parentA]=parentB;
        }
    }
    static int findParent(int node){
        if(parent[node]!=node){
            return parent[node]=findParent(parent[node]);
        }
        return node;
    }

    static class Bridge implements Comparable<Bridge>{
        int v1;
        int v2;
        int value;
        Bridge(int v1,int v2,int value){
            this.v1=v1;
            this.v2=v2;
            this.value=value;
        }
        public int compareTo(Bridge o){
            return this.value-o.value;
        }
        public String toString(){
            return v1+" "+v2+" "+value;
        }
    }
    static class Item implements Comparable<Item>{
        int v;
        int length;
        Item(int v,int length){
            this.v=v;
            this.length=length;
        }
        public String toString(){
            return v+" "+length;
        }
        public int compareTo(Item o){
            return this.length-o.length;
        }
    }
}
