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
        StringTokenizer st;// = new StringTokenizer(br.readLine(), " ");

        while(true){
            st=new StringTokenizer(br.readLine()," ");
            M=Integer.parseInt(st.nextToken());
            N=Integer.parseInt(st.nextToken());
            int sr=0;
            int sc=0;
            if(N==0 && M==0) return;
            int trash=1;

            board=new int[N][M];
            for(int i=0;i<N;i++){
                String s=br.readLine();
                for(int j=0;j<M;j++){
                    if(s.charAt(j)=='o'){
                        sr=i; sc=j;
                    }
                    if(s.charAt(j)=='*'){
                        board[i][j]=trash++;
                    }
                    if(s.charAt(j)=='x'){
                        board[i][j]=-1;
                    }
                }
//                System.out.println(Arrays.toString(board[i]));
            }
            visited=new boolean[(int)Math.pow(2,trash-1)][N][M];
            System.out.println(solve(sr,sc,trash));
        }
    }
    static int solve(int sr,int sc,int totalTrash){
        int ans=0;
        ArrayDeque<Item>dq=new ArrayDeque<>();
        dq.add(new Item(sr,sc,0));
        visited[0][sr][sc]=true;
//        System.out.println(totalTrash);

        while(!dq.isEmpty()){
            int L=dq.size();
            ans++;
//            System.out.println(dq);
            for(int i=0;i<L;i++){
                Item item=dq.poll();
                for(int k=0;k<4;k++){
                    int curR=item.r+dr[k];
                    int curC=item.c+dc[k];
                    if(curR>=0 && curR<N && curC>=0 && curC<M && board[curR][curC]!=-1){
                        int nextTrash=item.trash;
                        if((item.trash>>(board[curR][curC]-1))%2==0){
                            nextTrash+=(int)Math.pow(2,board[curR][curC]-1);
                        }
                        if(nextTrash==(int)Math.pow(2,totalTrash-1)-1){
                            return ans;
                        }
                        if(!visited[nextTrash][curR][curC]){
                            visited[nextTrash][curR][curC]=true;
                            dq.add(new Item(curR,curC,nextTrash));
                        }
                    }
                }
            }
        }
        return -1;

    }
    static class Item{
        int r,c,trash;
        Item(int r,int c,int trash){
            this.r=r;
            this.c=c;
            this.trash=trash;
        }

        @Override
        public String toString() {
            return r+" "+c+" "+trash;
        }
    }
}
