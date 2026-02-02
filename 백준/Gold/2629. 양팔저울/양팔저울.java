import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int T;
    static int[] stone;
    static int[] biz;
    static boolean[][] visited;
    static Set<Integer> answerSet;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine()," ");
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N=Integer.parseInt(st.nextToken());
        stone=new int[N];
        answerSet=new HashSet<>();
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

        visited=new boolean[15001][N+1];
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
    static void dfs(int idx,int l,int r){
        if(idx==N){
            answerSet.add(Math.abs(l-r));
            return;
        }
        if(!visited[Math.abs(l-r)][idx]){
            visited[Math.abs(l-r)][idx]=true;
            answerSet.add(Math.abs(l-r));
            dfs(idx+1,l+stone[idx],r);
            dfs(idx+1,l,r+stone[idx]);
            dfs(idx+1,l,r);
        }


    }


}
