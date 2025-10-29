import java.io.*;
import java.util.*;

public class Main {
    static int P,W,C,V;
    static ArrayList<Node>[] graph;
    static int[] size;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        P=Integer.parseInt(st.nextToken());
        W=Integer.parseInt(st.nextToken());
        st=new StringTokenizer(br.readLine()," ");
        C=Integer.parseInt(st.nextToken());
        V=Integer.parseInt(st.nextToken());

        graph=new ArrayList[P];
        size=new int[P];
        for(int i=0;i<P;i++){
            graph[i]=new ArrayList<>();
        }
        for(int i=0;i<W;i++){
            st=new StringTokenizer(br.readLine()," ");
            int s=Integer.parseInt(st.nextToken());
            int e=Integer.parseInt(st.nextToken());
            int w=Integer.parseInt(st.nextToken());
            graph[s].add(new Node(e,w));
            graph[e].add(new Node(s,w));
        }
        PriorityQueue<Node> pq=new PriorityQueue<>();
        pq.add(new Node(C,987654321));
        while(!pq.isEmpty()){
            Node node=pq.poll();
            if(node.w<size[node.idx]) continue;
            for(Node next:graph[node.idx]){
                int cur=Math.min(node.w,next.w);
                if(cur>size[next.idx]){
                    size[next.idx]=cur;
                    pq.add(new Node(next.idx,cur));
                }
            }
        }
        System.out.println(size[V]);
    }
    static class Node implements Comparable<Node>{
        int idx,w;
        Node(int idx,int w){
            this.idx=idx;
            this.w=w;
        }

        @Override
        public int compareTo(Node i) {
            return this.w-i.w;
        }
    }
}