import java.io.*;
import java.sql.Array;
import java.util.*;

public class Main {
    static int N,M;
    static int[][] board;
    static int startR,startC,startD;
    static int endR,endC,endD;
    static int[] dr={0,0,1,-1};
    static int[] dc={1,-1,0,0};
    static boolean[][][] visited;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N=Integer.parseInt(st.nextToken());
        M=Integer.parseInt(st.nextToken());
        board=new int[N][M];
        visited=new boolean[N][M][4];

        for(int i=0;i<N;i++){
            st=new StringTokenizer(br.readLine()," ");
            for(int j=0;j<M;j++){
                board[i][j]=Integer.parseInt(st.nextToken());
            }
        }
        st=new StringTokenizer(br.readLine()," ");
        startR=Integer.parseInt(st.nextToken())-1;
        startC=Integer.parseInt(st.nextToken())-1;
        startD=Integer.parseInt(st.nextToken())-1;

        st=new StringTokenizer(br.readLine()," ");
        endR=Integer.parseInt(st.nextToken())-1;
        endC=Integer.parseInt(st.nextToken())-1;
        endD=Integer.parseInt(st.nextToken())-1;

        if(startR==endR && startC==endC && startD==endD){
            System.out.println(0);
            return;
        }

        ArrayDeque<Item>dq=new ArrayDeque<>();

        dq.add(new Item(startR,startC,startD));
        visited[startR][startC][startD]=true;
        int cnt=0;
        while(!dq.isEmpty()){
            int L=dq.size();
            cnt++;
//            System.out.println(dq);
            for(int i=0;i<L;i++){
                Item item=dq.poll();

                //명령 1
                for(int j=1;j<=3;j++){
//                    System.out.println("!!");
//                    System.out.println(item);
                    int curR=item.r+dr[item.d]*j;
                    int curC=item.c+dc[item.d]*j;
//                    System.out.printf("%d %d\n",curR,curC);
                    if(curR==endR && curC==endC && item.d==endD){
                        System.out.println(cnt);
                        return;
                    }
                    if(curR>=0 && curR<N && curC>=0 && curC<M && !visited[curR][curC][item.d]){
                        if(board[curR][curC]==1){
                            break;
                        }
                        visited[curR][curC][item.d]=true;
                        dq.add(new Item(curR,curC,item.d));
                    }
                }
                //명령 2
                if(item.d==1 || item.d==0){
                    int curD=2;
                    if(item.r==endR && item.c==endC && curD==endD){
                        System.out.println(cnt);
                        return;
                    }
                    if(!visited[item.r][item.c][curD]){
                        visited[item.r][item.c][curD]=true;
                        dq.add(new Item(item.r,item.c,curD));
                    }
                    curD=3;
                    if(item.r==endR && item.c==endC && curD==endD){
                        System.out.println(cnt);
                        return;
                    }
                    if(!visited[item.r][item.c][curD]){
                        visited[item.r][item.c][curD]=true;
                        dq.add(new Item(item.r,item.c,curD));
                    }
                }
                if(item.d==2 || item.d==3){
                    int curD=0;
                    if(item.r==endR && item.c==endC && curD==endD){
                        System.out.println(cnt);
                        return;
                    }
                    if(!visited[item.r][item.c][curD]){
                        visited[item.r][item.c][curD]=true;
                        dq.add(new Item(item.r,item.c,curD));
                    }
                    curD=1;
                    if(item.r==endR && item.c==endC && curD==endD){
                        System.out.println(cnt);
                        return;
                    }
                    if(!visited[item.r][item.c][curD]){
                        visited[item.r][item.c][curD]=true;
                        dq.add(new Item(item.r,item.c,curD));
                    }
                }
            }
        }



    }
    static class Item{
        int r;
        int c;
        int d;
        Item(int r,int c,int d){
            this.r=r;
            this.c=c;
            this.d=d;
        }
        public String toString(){
            return r+" "+c+" "+d;
        }
    }
}
