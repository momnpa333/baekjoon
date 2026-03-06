import java.io.*;
import java.util.*;

public class Main {
    static int R,C;
    static int[][] board;
    static int N;
    static int[] dr={0,1,0,-1};
    static int[] dc={1,0,-1,0};
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        R=Integer.parseInt(st.nextToken());
        C=Integer.parseInt(st.nextToken());
        board=new int[R][C];

        for(int i=0;i<R;i++){
            String s=br.readLine();
            for(int j=0;j<C;j++){
                char op = s.charAt(j);
                if(op=='.'){
                    board[i][j]=0;
                }
                if(op=='x'){
                    board[i][j]=1;
                }
            }
        }
        st=new StringTokenizer(br.readLine()," ");
        N=Integer.parseInt(st.nextToken());
        int op=0;
        st=new StringTokenizer(br.readLine()," ");
        while(N-->0){
            int h=R-Integer.parseInt(st.nextToken());
            crash(h,op%2);
            op++;
        }
        for(int i=0;i<R;i++){
            String s="" ;
            for(int j=0;j<C;j++){
                if(board[i][j]==0){
                    s+=".";
                }
                else{
                    s+="x";
                }
            }
            System.out.println(s);
        }
    }
    static void crash(int r,int op){
        int tr=-1; int tc=-1;
        if(op==0){
            for(int i=0;i<C;i++){
                if(board[r][i]==1){
                    tr=r;
                    tc=i;
                    break;
                }
            }
        }
        else{
            for(int i=C-1;i>=0;i--){
                if(board[r][i]==1){
                    tr=r;
                    tc=i;
                    break;
                }
            }
        }
        if(tr==-1 || tc==-1) return;

        board[tr][tc]=0;
        for(int t=0;t<4;t++){
            int nr=tr+dr[t];
            int nc=tc+dc[t];
            if(nr>=0 && nr<R && nc>=0 && nc<C){
                int[][] partBlock=getPartBlock(nr,nc);
                if(partBlock!=null){
                    gravity(partBlock);
                }
            }
        }
    }
    static void gravity(int[][] partBlock){
        ArrayList<Item> blockList=new ArrayList<>();
        for(int i=0;i<R;i++){
            for(int j=0;j<C;j++){
                if(partBlock[i][j]==1){
                    blockList.add(new Item(i,j));
                    board[i][j]=0;
                }
            }
        }
        if(blockList.isEmpty()) return;
//        System.out.println(blockList);
        int h=0;
        A:
        while(true){
            h++;
//            System.out.println(h);
            for(Item item:blockList){
                int nr=item.r+h;
                int nc=item.c;
                if(nr>=R || board[nr][nc]==1){
                    break A;
                }
            }
        }
        h--;
        for(Item item:blockList){
            board[item.r+h][item.c]=1;
        }
    }

    static int[][] getPartBlock(int r,int c){
        ArrayDeque<Item> dq=new ArrayDeque<>();
        dq.add(new Item(r,c));
        int[][] visited;
        visited=new int[R][C];
        if(board[r][c]==1)
            visited[r][c]=1;

        while(!dq.isEmpty()){
//            System.out.println(dq);
            int L=dq.size();
            for(int i=0;i<L;i++){
                Item item=dq.poll();
                for(int k=0;k<4;k++){
                    int nr=item.r+dr[k];
                    int nc=item.c+dc[k];
                    if(nr>=0 && nr<R && nc>=0 && nc<C && visited[nr][nc]==0 && board[nr][nc]==1){
                        visited[nr][nc]=1;
                        dq.add(new Item(nr,nc));
                    }
                }
            }
        }
        for(int i=0;i<C;i++){
            if(visited[R-1][i]==1){
                return null;
            }
        }
        return visited;
    }
    static class Item{
        int r,c;
        Item(int r,int c){
            this.r=r;
            this.c=c;
        }
    }
}
