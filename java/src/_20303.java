import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class _20303 {
    static int N,M,K;
    static int[] parent;
    static int[] candi;
    static boolean[] visited;
    static Map<Integer, Item> items;
    static long[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N=Integer.parseInt(st.nextToken()); M=Integer.parseInt(st.nextToken()); K=Integer.parseInt(st.nextToken());

        items=new HashMap<>();  visited=new boolean[N+1];
        parent=new int[N+1];
        for(int i=0;i<=N;i++){
            parent[i]=i;
        }
        candi=new int[N+1];
        st=new StringTokenizer(br.readLine()," ");
        for(int i=1;i<=N;i++){
            candi[i]=Integer.parseInt(st.nextToken());
        }
        for(int i=0;i<M;i++){
            st=new StringTokenizer(br.readLine()," ");
            int v1=Integer.parseInt(st.nextToken()); int v2=Integer.parseInt(st.nextToken());
            if(findParent(v1)!=findParent(v2))
                union(v1,v2);
        }
        for(int i=1;i<=N;i++){
            if(!visited[findParent(i)]){
                Item item=new Item(1,candi[i]);
                items.put(findParent(i),item);
                visited[findParent(i)]=true;
            }
            else{
                items.get(findParent(i)).value+=candi[i];
                items.get(findParent(i)).cnt+=1;
            }
        }
        dp=new long[items.size()+1][3001];

        int idx=1;
        for(Item item: items.values()){
            for(int i=0;i<K;i++){
                if(i<item.cnt){
                    dp[idx][i]=dp[idx-1][i];
                }
                else{
                    dp[idx][i]=Math.max(dp[idx-1][i],dp[idx-1][i-item.cnt]+item.value);
                }
            }
            idx++;
        }

        System.out.println(dp[items.size()][K-1]);


    }
    static void union(int a,int b){
        int parentA=findParent(a);  int parentB=findParent(b);

        if(parentA<parentB){
            parent[parentB]=parentA;
        }
        else{
            parent[parentA]=parentB;
        }
    }
    static int findParent(int child){
        if(parent[child]!=child){
            return parent[child]=findParent(parent[child]);
        }
        return child;
    }
    static class Item{
        int cnt;
        int value;
        Item(int cnt,int value){
            this.cnt=cnt;
            this.value=value;
        }
        public String toString(){
            return cnt+" "+value;
        }
    }

}
