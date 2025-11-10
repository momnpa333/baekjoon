import java.io.*;
import java.util.*;

public class Main {
    static int N,M;
    static int[][] board;
    static boolean[][][] visited;
    static int[] dr={0,1,0,-1};
    static int[] dc={1,0,-1,0};
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N=Integer.parseInt(st.nextToken());
        M=Integer.parseInt(st.nextToken());
        board=new int[N+2][N+2];
        visited=new boolean[2][N+2][N+2];
        visited[0][1][1]=true;
        for(int i=0;i<=N+1;i++){
            Arrays.fill(board[i],1);
        }

        for(int i=0;i<N;i++){
            st=new StringTokenizer(br.readLine()," ");
            for(int j=0;j<N;j++){
                board[i+1][j+1]=Integer.parseInt(st.nextToken());
            }
//            System.out.println(Arrays.toString(board[i]));
        }

        ArrayDeque<Item> dq=new ArrayDeque<>();
        dq.add(new Item(0,1,1,0));
        int time=0;

        while(!dq.isEmpty()){
//            System.out.println(time);
//            System.out.println(dq);
            time++;
            int L=dq.size();
            for(int i=0;i<L;i++){
                Item item=dq.poll();
                if(board[item.r][item.c]==1)
                    dq.add(new Item(item.bridge,item.r,item.c,0));
                for(int k=0;k<4;k++){
                    int nextR=item.r+dr[k];
                    int nextC=item.c+dc[k];
                    if(nextR>=1 && nextR<=N && nextC>=1 && nextC<=N && !visited[item.bridge][nextR][nextC]){
                        if(nextR==N && nextC==N){
                            System.out.println(time);
                            return;
                        }
                        if(board[nextR][nextC]==1){
                            visited[item.bridge][nextR][nextC]=true;
                            dq.add(new Item(item.bridge,nextR,nextC,0));
                            continue;
                        }
                        if(item.prev==0 && board[nextR][nextC]>1 && time%board[nextR][nextC]==0){
                            visited[item.bridge][nextR][nextC]=true;
                            dq.add(new Item(item.bridge,nextR,nextC,1));
                            continue;
                        }
                        if(item.prev==0 && item.bridge==0 && time%M==0 && canBridge(nextR,nextC)){
                            visited[item.bridge+1][nextR][nextC]=true;
                            dq.add(new Item(item.bridge+1,nextR,nextC,1));
                        }
                    }
                }
            }
        }
        System.out.println(-1);

    }
    static boolean canBridge(int r,int c){
        if(!(r>=1 && r<=N && c>=1 && c<=N)) return false;
        if(board[r][c]!=0) return false;
        int cnt=0;
        int dirSum=0;
        for(int k=0;k<4;k++){
            int nextR=r+dr[k];
            int nextC=c+dc[k];
            if(board[nextR][nextC]==1) {
                cnt++;
                dirSum+=k;

            }
        }
        if(cnt<=1){
            return false;
        }
        if(cnt==2){
            return dirSum%2==0;
        }
        return true;
    }
    static class Item{
        int bridge,r,c,prev;
        Item(int bridge,int r,int c,int prev){
            this.bridge=bridge;
            this.r=r;
            this.c=c;
            this.prev=prev;
        }
        public String toString(){
            return bridge+" "+r+" "+c;
        }
    }
}