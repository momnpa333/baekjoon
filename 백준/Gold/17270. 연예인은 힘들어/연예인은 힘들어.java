import java.io.*;
import java.util.*;

public class Main {
    static int V,M;
    static long[][] board;
    static int G;
    static int S;
    static final long INF=9876543210000L;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        V=Integer.parseInt(st.nextToken());
        M=Integer.parseInt(st.nextToken());

        board=new long[V+1][V+1];

        for(int i=0;i<=V;i++){
            Arrays.fill(board[i],INF);
        }
        for(int i=0;i<M;i++){
            st=new StringTokenizer(br.readLine()," ");
            int s,e,v;
            s=Integer.parseInt(st.nextToken());
            e=Integer.parseInt(st.nextToken());
            v=Integer.parseInt(st.nextToken());
            board[s][e]=Math.min(board[s][e],v);
            board[e][s]=Math.min(board[e][s],v);
        }
        st=new StringTokenizer(br.readLine()," ");
        G=Integer.parseInt(st.nextToken());
        S=Integer.parseInt(st.nextToken());


        floyd();
//        for(int i=1;i<=V;i++){
//            System.out.println(Arrays.toString(board[i]));
//        }
        long minL=INF;
        for(int i=1;i<=V;i++){
            minL=Math.min(minL,getLength(i));
        }
        if(minL==INF){
            System.out.println(-1);
            return;
        }
        int answer=0;
        for(int i=V;i>=1;i--){
            if(isPossible(i,minL)){
                if(board[G][i]<=board[G][answer])
                    answer=i;
            }
        }
        if(answer==0){
            System.out.println(-1);
            return;
        }
        System.out.println(answer);

    }
    static long getLength(int node){
        if(node==G || node==S) return INF;
        return board[G][node]+board[S][node];
    }
    static boolean isPossible(int node,long minL){
        if(board[G][node]+board[S][node]!=minL) return false;
        if(node==G || node==S) return false;
        if(board[G][node]>board[S][node]) return false;
        return true;
    }
    static void floyd(){
        for(int via=1;via<=V;via++){
            for(int s=1;s<=V;s++){
                for(int e=1;e<=V;e++){
                    if(board[s][via]+board[via][e]<board[s][e]){
                        board[s][e]=board[s][via]+board[via][e];
                    }
                }
            }
        }
    }
}
