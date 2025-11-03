import java.io.*;
import java.util.*;

public class Main {
    static int N,M,P;
    static int[] s;
    static int[][] board;
    static int[] ans;
    static int[] dr = {0,1,0,-1};
    static int[] dc = {1,0,-1,0};
    static ArrayDeque<Item>[] dqList;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N=Integer.parseInt(st.nextToken());
        M=Integer.parseInt(st.nextToken());
        P=Integer.parseInt(st.nextToken());

        s=new int[P+1];
        ans=new int[P+1];
        dqList=new ArrayDeque[P+1];
        st=new StringTokenizer(br.readLine()," ");
        for(int i=1;i<P+1;i++){
            s[i]=Integer.parseInt(st.nextToken());
        }

        board=new int[N][M];
        for(int i=0;i<N;i++){
            String s=br.readLine();
            for(int j=0;j<M;j++){
                if(s.charAt(j)=='#'){
                    board[i][j]=-1;
                    continue;
                }
                if(s.charAt(j)=='.'){
                    board[i][j]=0;
                    continue;
                }
                board[i][j]=s.charAt(j)-'0';
            }
        }
        while(round()){
        }
//        for(int i=0;i<N;i++){
//            System.out.println(Arrays.toString(board[i]));
//        }
//        System.out.println(Arrays.toString(s));
        round();
        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                if(board[i][j]>0 && board[i][j]<=9){
                    ans[board[i][j]]++;
                }
            }
        }
        String ret="";
        for(int i=1;i<=P;i++){
            ret+=ans[i]+" ";
        }
        System.out.println(ret);
    }
    static boolean round(){
        boolean ret = false;
        for(int i=1;i<=P;i++){
            play(i);
        }
        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                if(board[i][j]>10){
                    ret=true;
                    board[i][j]-=10;
                }
            }
        }
        return ret;
    }
    static void play(int op){
        if(dqList[op]==null){
            ArrayDeque<Item> dq=new ArrayDeque<>();
            for(int i=0;i<N;i++){
                for(int j=0;j<M;j++){
                    if(board[i][j]==op){
                        dq.add(new Item(i,j,0));
                    }
                }
            }
            dqList[op]=dq;
        }
        dye(op,dqList[op]);
    }
    static void dye(int p,ArrayDeque<Item> dq){
        int cnt=0;
        while(!dq.isEmpty()){
            int L=dq.size();
            if(cnt++>=s[p]) {
                break;
            }
            for(int i=0;i<L;i++){
                Item item=dq.poll();
                for(int j=0;j<4;j++){
                    int curR=item.r+dr[j];
                    int curC=item.c+dc[j];
                    if(curR>=0 && curR<N && curC>=0 && curC<M ){
                        if(board[curR][curC]==0){
                            board[curR][curC]=10+p;
                            dq.add(new Item(curR,curC, item.depth+1));
                        }
//                        if(board[curR][curC]==10+p)
//                            dq.add(new Item(curR,curC, item.depth+1));
                    }
                }
            }
        }

    }
    static class Item{
        int r,c,depth;
        Item(int r,int c,int depth){
            this.r=r;
            this.c=c;
            this.depth=depth;
        }
    }

}
