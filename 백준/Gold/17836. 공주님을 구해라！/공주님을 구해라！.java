import java.io.*;
import java.util.*;

public class Main {
    static int N,M,T;
    static int[][] board;
    static boolean[][] visited;
    static int[] dr={0,1,0,-1};
    static int[] dc={1,0,-1,0};
    static int ans=987654321;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N=Integer.parseInt(st.nextToken());
        M=Integer.parseInt(st.nextToken());
        T=Integer.parseInt(st.nextToken());

        board=new int[N][M];
        visited=new boolean[N][M];

        for(int i=0;i<N;i++){
            st=new StringTokenizer(br.readLine()," ");
            for(int j=0;j<M;j++){
                board[i][j]=Integer.parseInt(st.nextToken());
            }
        }

        ArrayDeque<Item> dq=new ArrayDeque<>();
        dq.add(new Item(0,0,0));
        visited[0][0]=true;
        A:
        while(!dq.isEmpty()){
            int L=dq.size();
            for(int i=0;i<L;i++){
                Item item=dq.poll();
                for(int j=0;j<4;j++){
                    int curR=item.r+dr[j];
                    int curC=item.c+dc[j];
                    if(curR>=0 && curR<N && curC>=0 && curC<M && !visited[curR][curC] && board[curR][curC]!=1){
                        visited[curR][curC]=true;
                        if(curR==N-1 && curC==M-1){
                            ans=Math.min(ans,item.t+1);
                            break A;
                        }
                        if(board[curR][curC]==2){
                            ans=Math.min(ans,item.t+1+Math.abs((N-1)-curR)+Math.abs((M-1)-curC));
                        }
                        else{
                            dq.add(new Item(curR,curC,item.t+1));
                        }
                    }
                }
            }
        }
        if(ans>T){
            System.out.println("Fail");
            return;
        }
        System.out.println(ans);

    }
    static class Item{
        int r;
        int c;
        int t;
        boolean gram=false;
        Item(int r,int c,int t){
            this.r=r;
            this.c=c;
            this.t=t;
        }
    }
}
