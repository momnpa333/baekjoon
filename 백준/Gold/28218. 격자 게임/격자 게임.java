import java.io.*;
import java.util.*;

public class Main {
    static int N,M,K;
    static char[][] board;
    static int[][] dp;
    static boolean[][] result;
    static boolean[][] visited;
    static int Q;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N=Integer.parseInt(st.nextToken());
        M=Integer.parseInt(st.nextToken());
        K=Integer.parseInt(st.nextToken());

        board=new char[N][M];
        dp=new int[N][M];
        result=new boolean[N][M];
        visited=new boolean[N][M];

        for(int i=0;i<N;i++){
            String s= br.readLine();
            for(int j=0;j<M;j++){
                board[i][j]=s.charAt(j);
                if(board[i][j]=='#'){
                    dp[i][j]=-1;
                }
            }
//            System.out.println(Arrays.toString(board[i]));
        }
        makeDp(N-1,M-1,0);
//        for(int i=0;i<N;i++){
//            System.out.println(Arrays.toString(dp[i]));
//        }

        st=new StringTokenizer(br.readLine()," ");
        Q=Integer.parseInt(st.nextToken());
        while(Q-->0){
            st=new StringTokenizer(br.readLine()," ");
            int r=Integer.parseInt(st.nextToken())-1;
            int c=Integer.parseInt(st.nextToken())-1;
            if(!game(r,c)){
                System.out.println("Second");
            }
            else{
                System.out.println("First");
            }
        }

    }
    static boolean game(int r,int c){
//        System.out.println(r+" "+c);
        if(visited[r][c]) return result[r][c];
        visited[r][c]=true;
        if(dp[r][c]==1){
            result[r][c]=true;
            return true;
        }
        if(r+1<N && board[r+1][c]!='#' && !game(r+1,c)){
            result[r][c]=true;
            return true;
        }
        if(c+1<M && board[r][c+1]!='#' && !game(r,c+1)){
            result[r][c]=true;
            return true;
        }
        for(int i=1;i<=K;i++){
            if(r+i<N && c+i<M && board[r+i][c+i]!='#' && !game(r+i,c+i)){
                result[r][c]=true;
                return true;
            }
        }
        return false;
    }
    static void makeDp(int r,int c,int l){
        if(r<0 || c<0) return;
        if(dp[r][c]!=0) return;
//        System.out.println("!"+" "+r+" "+c);
        dp[r][c]=l;
        makeDp(r-1,c,l+1);
        makeDp(r,c-1,l+1);
        for(int i=1;i<=K;i++){
            makeDp(r-1,c-1,l+1);
        }
    }

}