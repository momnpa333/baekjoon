import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class _1389 {
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int N=Integer.parseInt(st.nextToken());
        int M=Integer.parseInt(st.nextToken());

        List<Integer>[] graph = new ArrayList[N+1];

        for(int i=0;i<N+1;i++){
            graph[i]=new ArrayList<>();
        }

        while(M-->0){
            st=new StringTokenizer(br.readLine()," ");
            int A=Integer.parseInt(st.nextToken());
            int B=Integer.parseInt(st.nextToken());

            graph[A].add(B); graph[B].add(A);
        }
        int ans=N+1; int bacon=Integer.MAX_VALUE;
        for(int i=1;i<N+1;i++){
            if(findBacon(graph,i)<bacon){
                ans=i; bacon=findBacon(graph,i);
            }
        }
        System.out.println(ans);





    }
    private static int findBacon(List<Integer>[] graph,int E){
        boolean[] check=new boolean[graph.length];
        Arrays.fill(check, true);
        check[E]=false;
        int ret=0;
        int e;
        int depth=1;
        ArrayDeque<Integer> dq=new ArrayDeque<>();

        dq.add(E);
        while(!dq.isEmpty()){
            int L=dq.size();
            for(int i=0;i<L;i++){
                e=dq.pollFirst();
                for(int v:graph[e]){
                    if(check[v]){
                        check[v]=false;
                        dq.add(v);
                        ret+=depth;
                    }
                }
            }
            depth+=1;
        }
        return ret;
    }
}
