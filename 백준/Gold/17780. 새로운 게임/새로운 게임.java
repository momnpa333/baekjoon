import java.io.*;
import java.util.*;

public class Main {
    static int N,K;
    static int[][] board;
    static Seq[][] state;
    static int[] dr={0,0,-1,1};
    static int[] dc={1,-1,0,0,};
    static Item[] items;
    static int flag;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N=Integer.parseInt(st.nextToken());
        K=Integer.parseInt(st.nextToken());
        board=new int[N][N];
        items=new Item[K];
        state=new Seq[N][N];
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                state[i][j]=new Seq(i,j);
            }
        }

        for(int i=0;i<N;i++){
            st=new StringTokenizer(br.readLine()," ");
            for(int j=0;j<N;j++){
                board[i][j]=Integer.parseInt(st.nextToken());
            }
        }

        for(int i=1;i<=K;i++){
            st=new StringTokenizer(br.readLine()," ");
            int r=Integer.parseInt(st.nextToken())-1;
            int c=Integer.parseInt(st.nextToken())-1;
            int dir=Integer.parseInt(st.nextToken())-1;
            items[i-1]=new Item(i,r,c,dir);
            state[r][c].seqs.add(items[i-1]);
        }

        int ans=0;
        while(ans<1000){
            ans++;
            if(turn()){
                System.out.println(ans);
                return;
            }
        }

        System.out.println(-1);


    }
    static boolean turn(){
        for(int i=0;i<K;i++){
            state[items[i].r][items[i].c].move(items[i].id);
            if(flag==1) return true;
//            for(int j=0;j<N;j++){
//                for(int k=0;k<N;k++){
//                    System.out.printf("%d %d\n",j,k);
//                    System.out.println(state[j][k].seqs);
//                }
//            }
        }
        return false;
    }

    static class Seq{
        ArrayList<Item> seqs=new ArrayList<>();
        int r,c;
        Seq(int r,int c){
            this.r=r;
            this.c=c;
        }

        void move(int id){
            Item item=seqs.get(0);
            if(item.id!=id){
                return;
            }
            int curR=item.r+dr[item.dir];
            int curC=item.c+dc[item.dir];

            if(isB(curR,curC)){
                moveB(item);
            }
            else if(board[curR][curC]==0){
                goW(curR,curC);
            }
            else if(board[curR][curC]==1){
                goR(curR,curC);
            }
        }
        boolean isB(int r,int c){
            if(r>=N || r<0 || c>=N || c<0){
                return true;
            }
            if(board[r][c]==2){
                return true;
            }
            return false;
        }
        void moveB(Item item){
            item.dir=(item.dir/2)*2+(item.dir+1)%2;
            int curR=item.r+dr[item.dir];
            int curC=item.c+dc[item.dir];
            if(isB(curR,curC)){
                return;
            }
            move(item.id);
        }
        void receive(ArrayList<Item> candies){
            for(Item candi:candies){
                seqs.add(candi);
                candi.r=r;
                candi.c=c;
            }
            if(seqs.size()>=4)
                flag=1;
        }
        void receiveR(ArrayList<Item> candies){
            for(int i=candies.size()-1;i>=0;i--){
                Item item=candies.get(i);
                seqs.add(item);
                item.r=r;
                item.c=c;
            }
            if(seqs.size()>=4)
                flag=1;
        }
        void goW(int r,int c){
            state[r][c].receive(seqs);
            seqs=new ArrayList<>();
        }
        void goR(int r,int c){
            state[r][c].receiveR(seqs);
            seqs=new ArrayList<>();
        }
    }
    static class Item{
        int id,r,c;
        int dir;
        Item(int id,int r,int c,int dir){
            this.id=id;
            this.r=r;
            this.c=c;
            this.dir=dir;
        }
    }
}