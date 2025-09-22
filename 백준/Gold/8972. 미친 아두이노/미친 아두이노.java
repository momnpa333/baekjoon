import java.io.*;
import java.util.*;

public class Main {
    static int R,C;
    static char[][] board;
    static String ops;
    static int[] dr={-1000,1,1,1,0,0,0,-1,-1,-1};
    static int[] dc={-1000,-1,0,1,-1,0,1,-1,0,1};
    static int startR,startC;
    static int[][] visit;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        R=Integer.parseInt(st.nextToken());
        C=Integer.parseInt(st.nextToken());

        board=new char[R][C];
        visit=new int[R][C];

        for(int i=0;i<R;i++){
            String s=br.readLine();
            for(int j=0;j<C;j++){
                board[i][j]=s.charAt(j);
                if(board[i][j]=='I'){
                    startR=i;
                    startC=j;
                }
            }
//            System.out.println(Arrays.toString(board[i]));
        }

        ops=br.readLine();

        for(int i=0;i<ops.length();i++){
//            printBoard();
//            System.out.println("ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");
            if(!move(i)){
                System.out.printf("kraj %d",i+1);
                return;
            }
            visit=new int[R][C];
            for(int k=0;k<R;k++){
                for(int l=0;l<C;l++){
                    if(board[k][l]=='R'){
                        if(robotMove(k,l)){
                            System.out.printf("kraj %d",i+1);
                            return;
                        }
                    }
                }
            }
            for(int k=0;k<R;k++){
                for(int l=0;l<C;l++){
                    if(board[k][l]=='I') continue;
                    if(visit[k][l]>1){
                        board[k][l]='.';
                    }
                    if(visit[k][l]==1){
                        board[k][l]='R';
                    }
                    if(visit[k][l]==0){
                        board[k][l]='.';
                    }
                }
            }

        }

        printBoard();
    }
    static int findDir(int r,int c){
        int ret=0;
        int dist=Math.abs(startR-r)+Math.abs(startC-c);
        for(int i=1;i<=9;i++){
            int curR=r+dr[i];
            int curC=c+dc[i];
            if(curR>=0 && curR<R && curC>=0 && curC<C){
                if(Math.abs(curR-startR)+Math.abs(curC-startC)<dist){
                    ret=i;
                    dist=Math.abs(curR-startR)+Math.abs(curC-startC);
                }
            }
        }
        return ret;
    }
    static boolean robotMove(int r,int c){
        int dir=findDir(r,c);
        board[r][c]='.';
        int curR=r+dr[dir];
        int curC=c+dc[dir];
//        System.out.println(curR);
        if(curR==startR && curC==startC){
            return true;
        }
        visit[curR][curC]+=1;
        return false;
    }

    static void printBoard(){
        for(int i=0;i<R;i++){
            String r="";
            for(int j=0;j<C;j++){
                r+=board[i][j];
            }
            System.out.println(r);
        }
    }
    static boolean move(int idx){
        int dir=ops.charAt(idx)-'0';
        int curR=startR+dr[dir]; int curC=startC+dc[dir];
        if(curR>=0 && curR<R && curC>=0 && curC<C){
            if(board[curR][curC]=='R'){
                return false;
            }
            else{
                board[startR][startC]='.';
                board[curR][curC]='I';
                startR=curR;
                startC=curC;
                return true;
            }
        }
        return true;
    }

}
