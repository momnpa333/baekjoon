import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class _2629 {
    static int N;
    static int[] stone;
    static int T;
    static int[] biz;
    static boolean[][] visited;
    static Set<Integer> answerSet;
    static int cnt;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine()," ");
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        answerSet=new HashSet<>();
        N=Integer.parseInt(st.nextToken());
        stone=new int[N];
        st=new StringTokenizer(br.readLine()," ");
        for(int i=0;i<N;i++){
            stone[i]=Integer.parseInt(st.nextToken());
        }
        st=new StringTokenizer(br.readLine()," ");
        T=Integer.parseInt(st.nextToken());
        biz=new int[T];
        st=new StringTokenizer(br.readLine()," ");
        for(int i=0;i<T;i++){
            biz[i]=Integer.parseInt(st.nextToken());
        }

        visited=new boolean[15001][51];
        dfs(0,0,0);

        for(int a:biz){
            if(answerSet.contains(a)){
                System.out.print("Y ");
            }
            else{
                System.out.print("N ");
            }
        }

    }
    static void dfs(int depth,int l,int r){
        cnt++;
        answerSet.add(Math.abs(l-r));
        if(depth==N){
            return;
        }
        if(!visited[Math.abs(l-r)][depth]){
            visited[Math.abs(l-r)][depth]=true;

            dfs(depth+1,l+stone[depth],r);
            dfs(depth+1,l,r+stone[depth]);
            dfs(depth+1,l,r);
        }

    }

}
