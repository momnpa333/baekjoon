import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class _23840 {
    static int N,M;
    static ArrayList<Node>[] graph;
    static int X,Z,P;
    static int[] vias;
    static long[][] length;
    static long[][] dp;
    static long answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N=readInt();M=readInt();
        graph=new ArrayList[N+1];
        for(int i=0;i<=N;i++){
            graph[i]=new ArrayList<>();
        }
        for(int i=0;i<M;i++){
            int u=readInt(); int v=readInt();
            int w=readInt();

            graph[u].add(new Node(v,w));    graph[v].add(new Node(u,w));
        }
        X=readInt(); Z=readInt();
        P=readInt();
        vias=new int[P+3];
        for(int i=2;i<=P+1;i++){
            vias[i]=readInt();
        }
        vias[1]=X;
        vias[P+2]=Z;
        length=new long[P+3][P+3];

        dp=new long[P+3][1<<P];

        for(int i=1;i<=P+2;i++){
            dijkstra(i);
        }
        answer=mst(P+2,(1<<P)-1);


        if(answer==Long.MAX_VALUE){
            System.out.println(-1);
        }
        else{
            System.out.println(answer);
        }

    }
    static long mst(int cur,int via) {
        long ret=Long.MAX_VALUE;

        if (dp[cur][via]!=0) {
            return dp[cur][via];
        }
        if(via==0){
            dp[cur][via]=length[cur][1];
            return dp[cur][via];
        }
        for(int i=2;i<=P+1;i++){
            if (i!=cur && length[cur][i]!=Long.MAX_VALUE && ((via >> (i - 2)) & 1) == 1){
                long tmp=mst(i,via-(1<<(i-2)));
                if(tmp==Long.MAX_VALUE) continue;
                ret=Math.min(ret,length[cur][i]+tmp);
            }
        }
        dp[cur][via]=ret;
        return ret;
    }

    static void dijkstra(int start){
        long[] dist=new long[N+1];
        Arrays.fill(dist,Long.MAX_VALUE);
        Node node=new Node(vias[start],0);
        PriorityQueue<Node> pq=new PriorityQueue<>();
        dist[vias[start]]=0;
        pq.add(node);

        while(!pq.isEmpty()){
            Node item=pq.poll();
            if(item.l>dist[item.end]){
                continue;
            }
            for(Node child:graph[item.end]){
                if(item.l+child.l<dist[child.end]){
                    dist[child.end]=item.l+child.l;
                    pq.add(new Node(child.end,item.l+child.l));
                }
            }
        }
        for(int i=0;i<=P+2;i++){
            length[start][i]=dist[vias[i]];
        }
    }


    static class Node implements Comparable<Node>{
        int end;
        long l;
        Node(int end,long l){
            this.end=end;
            this.l=l;
        }
        public int compareTo(Node o){
            return Long.compare(this.l, o.l);
        }
    }

    static int pos, len;
    static byte[] buf = new byte[8192];

    static byte read() throws IOException {
        if (pos == len) {
            len = System.in.read(buf);
            pos = 0;
        }
        return buf[pos++];
    }

    static int readInt() throws IOException {
        int c;
        while ((c = read()) <= 32)
            ;
        int n = c & 15;
        while ((c = read()) > 47)
            n = (n << 3) + (n << 1) + (c & 15);
        return n;
    }

}
