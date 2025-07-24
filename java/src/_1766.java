import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class _1766 {
    static int N,M;
    static ArrayList<Integer>[] graph;
    static ArrayList<Integer>[] parent;
    static boolean[] isChild;
    static boolean[] isDone;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        BufferedWriter bw= new BufferedWriter(new OutputStreamWriter(System.out));

        N=Integer.parseInt(st.nextToken()); M=Integer.parseInt(st.nextToken());
        graph=new ArrayList[N+1]; parent=new ArrayList[N+1];
        for(int i=0;i<=N;i++){
            graph[i]=new ArrayList<>();
            parent[i]=new ArrayList<>();
        }
        isChild=new boolean[N+1];
        isDone=new boolean[N+1];

        for(int i=0;i<M;i++){
            st=new StringTokenizer(br.readLine()," ");
            int v1,v2;
            v1=Integer.parseInt(st.nextToken());    v2=Integer.parseInt(st.nextToken());
            graph[v1].add(v2);
            parent[v2].add(v1);
            isChild[v2]=true;
        }

        PriorityQueue<Integer> pq=new PriorityQueue<>();
        for(int i=1;i<=N;i++){
            if(!isChild[i]){
                pq.add(i);
            }
        }
        while(!pq.isEmpty()){
            int item = pq.poll();
            if(noParent(item) && !isDone[item]){
                bw.write(item+" ");
                isDone[item]=true;
                for(int c:graph[item]){
                    if(!isDone[c]){
                        pq.add(c);
                    }
                }
            }

        }
        bw.flush();

    }
    static boolean noParent(int v){
        for(int p:parent[v]){
            if(!isDone[p]){
                return false;
            }
        }
        return true;
    }


}
