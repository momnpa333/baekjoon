import java.io.*;
import java.util.*;

public class Main {
    static boolean[][] board1;
    static boolean[][] board2;
    static int[] dr={-1,0,0,1};
    static int[] dc={-1,0,1,0};
    static int N,op,r,c;
    static int score;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
//        BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
        N=Integer.parseInt(st.nextToken());
        board1=new boolean[6][4];
        board2=new boolean[6][4];

        for(int i=0;i<N;i++){
            st=new StringTokenizer(br.readLine()," ");
            op=Integer.parseInt(st.nextToken());
            r=Integer.parseInt(st.nextToken());
            c=Integer.parseInt(st.nextToken());
            putBlock1(op,r,c);
            putBlock2(op,r,c);
            bomb(board1);
            gravity(board1);
            bomb(board2);
            gravity(board2);
            check(board1);
            check(board1);
            check(board2);
            check(board2);

//            for(int j=0;j<6;j++){
//                System.out.println(Arrays.toString(board1[j]));
//            }
//            System.out.println();
        }
        System.out.println(score);
        System.out.println(countBlock(board1)+countBlock(board2));

    }
    static int countBlock(boolean[][] board){
        int ret=0;
        for(int i=0;i<6;i++){
            for(int j=0;j<4;j++){
                if(board[i][j])
                    ret++;
            }
        }
        return ret;
    }
    static void putBlock1(int op,int startR,int startC){
        int putR=0;
        int putC=0;
        int r=startR;
        int c=startC;
        for(r=0;r<6;r++){
            //안되면
            if(r+dr[op]>5 || board1[r][c] || board1[r+dr[op]][c+dc[op]]){
                break;
            }
            putR=r;
            putC=c;
        }
//        System.out.println(putR+" "+putC);
        board1[putR][putC]=true;
        board1[putR+dr[op]][putC+dc[op]]=true;
    }
    static void putBlock2(int op,int startR,int startC){
        int putR=0;
        int putC=0;
        int r=startC;
        int c=startR;
        if(op==1){
            op=1;
        }
        else if(op==2) {
            op=3;
        }
        else if(op==3) {
            op=2;
        }
        for(r=0;r<6;r++){
            //안되면
            if(r+dr[op]>5 || board2[r][c] || board2[r+dr[op]][c+dc[op]]){
                break;
            }
            putR=r;
            putC=c;
        }
//        System.out.println(putR+" "+putC);
        board2[putR][putC]=true;
        board2[putR+dr[op]][putC+dc[op]]=true;

    }
    static void bomb(boolean[][] board){
        A:
        for(int r=0;r<6;r++){
            for(int c=0;c<4;c++){
                if(!board[r][c]){
                    continue A;
                }
            }
            score++;
            for(int c=0;c<4;c++){
                board[r][c]=false;
            }
        }
    }
    static void gravity(boolean[][] board){
        int r=5;
        A:
        for(int h=0;h<4;h++){
            for(int c=0;c<4;c++){
                if(board[r][c]){
                    r--;
                    continue A;
                }
            }
//            System.out.println(r);
            down(r,board);
        }
    }
    static void down(int r,boolean[][] board){
        for(int h=r;h>0;h--){
            for(int c=0;c<4;c++){
                board[h][c]=board[h-1][c];
            }
        }
        for(int c=0;c<4;c++){
            board[0][c]=false;
        }
    }
    static void check(boolean[][] board){
        for(int r=0;r<2;r++){
            for(int c=0;c<4;c++){
                if(board[r][c]){
                    down(5,board);
                }
            }
        }
    }
}