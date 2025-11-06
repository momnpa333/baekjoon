import java.io.*;
import java.util.*;

public class Main {
    static int N,M;
    static int H,W,SR,SC,FR,FC;
    static int[][] board;
    static boolean[][] isPossible;
    static boolean[][] visited;
    static int[] dr={0,1,0,-1};
    static int[] dc={1,0,-1,0};
    static int[] tr={1,1,-1,-1};
    static int[] tc={1,-1,1,-1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N=Integer.parseInt(st.nextToken());
        M=Integer.parseInt(st.nextToken());

        board=new int[N][M];
        isPossible=new boolean[N][M];
        visited=new boolean[N][M];

        for(int i=0;i<N;i++){
            Arrays.fill(isPossible[i],true);
            st=new StringTokenizer(br.readLine()," ");
            for(int j=0;j<M;j++){
                board[i][j]=Integer.parseInt(st.nextToken());
            }
        }
        st=new StringTokenizer(br.readLine()," ");

        H=Integer.parseInt(st.nextToken());
        W=Integer.parseInt(st.nextToken());
        SR=Integer.parseInt(st.nextToken())-1;
        SC=Integer.parseInt(st.nextToken())-1;
        FR=Integer.parseInt(st.nextToken())-1;
        FC=Integer.parseInt(st.nextToken())-1;

        makePossible();
//        for(int i=0;i<N;i++){
//            System.out.println(Arrays.toString(isPossible[i]));
//        }
        ArrayDeque<Item> dq=new ArrayDeque<>();

        if (SR == FR && SC == FC) {
            System.out.println(0);
            return;
        }
        dq.add(new Item(SR,SC));
        visited[SR][SC]=true;
        int ans=0;

        while(!dq.isEmpty()){
            ans++;
            int L=dq.size();
            for(int i=0;i<L;i++){
                Item item=dq.poll();
                for(int k=0;k<4;k++){
                    int curR=item.r+dr[k];
                    int curC=item.c+dc[k];
                    if(curR>=0 && curR<N && curC>=0 && curC<M && isPossible[curR][curC] && !visited[curR][curC]){
                        if(curR==FR && curC==FC){
                            System.out.println(ans);
                            return;
                        }
                        visited[curR][curC]=true;
                        dq.add(new Item(curR,curC));
                    }
                }
            }
        }
        System.out.println(-1);

    }
    static void makePossible(){
        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                if(board[i][j]==1){
                    dot(i,j);
                }
            }
        }
    }
    static void dot(int r,int c){
        int sr=r-H+1;
        int sc=c-W+1;
        for(int i=sr;i<=r;i++){
            for(int j=sc;j<=c;j++){
                if(i>=0 && i<N && j>=0 && j<=M){
                    isPossible[i][j]=false;
                }
            }
        }
        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                int nr=i+H-1;
                int nc=j+W-1;
                if(nr>=N || nc>=M){
                    isPossible[i][j]=false;
                }
            }
        }
    }
    static class Item{
        int r,c;
        Item(int r,int c){
            this.r=r;
            this.c=c;
        }
    }
}
