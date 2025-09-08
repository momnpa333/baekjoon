import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int K;
    static int[][] board;
    static Horse[] horses;
    static int[] dr={0,0,-1,1};
    static int[] dc={1,-1,0,0};
    static ArrayList<Horse>[][] boardState;
    static int cnt;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N=Integer.parseInt(st.nextToken());
        K=Integer.parseInt(st.nextToken());

        board=new int[N][N];
        horses=new Horse[K];
        boardState=new ArrayList[N][N];
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                boardState[i][j]=new ArrayList<>();
            }
        }

        for(int i=0;i<N;i++){
            st=new StringTokenizer(br.readLine()," ");
            for(int j=0;j<N;j++){
                board[i][j]=Integer.parseInt(st.nextToken());
            }
        }

        for(int i=0;i<K;i++){
            st=new StringTokenizer(br.readLine()," ");
            int r=Integer.parseInt(st.nextToken())-1;
            int c=Integer.parseInt(st.nextToken())-1;
            int d=Integer.parseInt(st.nextToken())-1;
            horses[i]=new Horse(i,r,c,d);
            boardState[r][c].add(horses[i]);
        }
        while(true){
            cnt++;
            if(move()){
                return;
            }
            if(isDone()){
                System.out.println(cnt);
                return;
            }
            if(cnt>1000){
                System.out.println(-1);
                return;
            }
        }
    }
    static void print(){
        for(int i=0;i<N;i++){
            String s="";
            for(int j=0;j<N;j++){
                s+=boardState[i][j];
            }
            System.out.println(s);
        }
        System.out.println("ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");
    }
    static boolean isDone(){
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                if(boardState[i][j].size()>=4){
                    return true;
                }
            }
        }
        return false;
    }
    static boolean move(){
        for(int i=0;i<K;i++){
//            print();
            int R=horses[i].r; int C=horses[i].c;
            //파랑
            if (horses[i].nextBlock()==2) {
                horses[i].d=(horses[i].d/2)*2+(horses[i].d+1)%2;
                if(horses[i].nextBlock()==2){
                    continue;
                }
            }

            //흰색
            if(horses[i].nextBlock()==0)
                for(int j=0;j<boardState[R][C].size();j++){
                    if(boardState[R][C].get(j)==horses[i]){
                        int cnt=0;
                        for(int k=j;k<boardState[R][C].size();k++){
                            Horse h=boardState[R][C].get(k);
                            if(h.move(horses[i].d)){
                                return true;
                            }
                            cnt++;
                        }
                        for(int t=0;t<cnt;t++)
                            boardState[R][C].remove(j);
                    }
                }
            else if (horses[i].nextBlock()==1) {
                for(int j=0;j<boardState[R][C].size();j++){
                    if(boardState[R][C].get(j)==horses[i]){
                        int cnt=0;
                        for(int k=boardState[R][C].size()-1;k>=j;k--){
                            Horse h=boardState[R][C].get(k);
                            if(h.move(horses[i].d)){
                                return true;
                            }
                            cnt++;
                        }
                        for(int t=0;t<cnt;t++)
                            boardState[R][C].remove(j);
                    }
                }
            }
        }
        return false;
    }


    static class Horse{
        int id;
        int r;
        int c;
        int d;
        Horse(int id,int r,int c,int d){
            this.id=id;
            this.r=r;
            this.c=c;
            this.d=d;
        }
        int nextBlock(){
            int curR=r+dr[d];
            int curC=c+dc[d];
            if(curR>=0 && curR<N && curC>=0 && curC<N) {
                return board[curR][curC];
            }
            return 2;
        }
        boolean move(int dir){
            int curR=r+dr[dir];
            int curC=c+dc[dir];
            if(curR>=0 && curR<N && curC>=0 && curC<N){
                r=curR;
                c=curC;
                boardState[r][c].add(this);
            }
            if(boardState[r][c].size()>=4){
                System.out.println(cnt);
                return true;
            }
            return false;
        }
        public String toString(){
            return id+" "+d;
        }
    }
}
