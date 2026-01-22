import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[][] board;
    static int[] dr={-1,0,1,0};
    static int[] dc={0,-1,0,1};
    static int size=2;
    static int remainToUp=2;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));

        N=Integer.parseInt(st.nextToken());

        board=new int[N][N];
        int r=-1; int c=-1;
        for(int i=0;i<N;i++){
            st=new StringTokenizer(br.readLine()," ");
            for(int j=0;j<N;j++){
                board[i][j]=Integer.parseInt(st.nextToken());
                if(board[i][j]==9){
                    r=i;
                    c=j;
                    board[i][j]=0;
                }
            }
        }
        int time=0;
        while(true){
            int[] moveT=getTime(r,c);
//            System.out.println(Arrays.toString(moveT));
            if(moveT[0]==-1){
                System.out.println(time);
                return;
            }
            remainToUp-=1;
            time+=moveT[0];
            r=moveT[1];
            c=moveT[2];
            if(remainToUp==0){
                size++;
                remainToUp=size;
            }
        }
    }
    static int[] getTime(int r,int c){
//        System.out.println("!"+r+" "+c);
        ArrayDeque<Item> dq=new ArrayDeque<>();
        int time=0;
        int[] ret=new int[]{-1,100,100};
        boolean[][] visited=new boolean[N][N];
        visited[r][c]=true;
        dq.add(new Item(r,c));

        while(!dq.isEmpty()){
//            System.out.println(dq);
            int L=dq.size();
            for(int i=0;i<L;i++){
                Item item=dq.poll();
                for(int j=0;j<4;j++){
                    int nr=item.r+dr[j];
                    int nc=item.c+dc[j];
                    if(nr>=0 && nr<N && nc>=0 && nc<N && !visited[nr][nc]){
                        visited[nr][nc]=true;
                        if(board[nr][nc]>0){
                            if(board[nr][nc]<size){
                                int[] tmp=new int[]{time+1,nr,nc};
                                if(nr<ret[1]){
                                    ret=tmp;
                                }
                                if(nr==ret[1] && nc<ret[2]){
                                    ret=tmp;
                                }
                            }
                            if(board[nr][nc]==size){
                                dq.add(new Item(nr,nc));
                            }
                        }
                        if(board[nr][nc]==0){
                            dq.add(new Item(nr,nc));
                        }
                    }
                }
            }
            if(ret[0]!=-1){
                board[ret[1]][ret[2]]=0;
                return ret;
            }
            time++;
        }
        return ret;

    }
    static class Item{
        int r;
        int c;
        Item(int r,int c){
            this.r=r;
            this.c=c;
        }
        public String toString(){
            return r+" "+c;
        }
    }


}

