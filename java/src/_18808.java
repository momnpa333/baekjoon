
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class _18808 {
    static int N,M,K;
    static Sticker[] stickers;
    static int[][] note;
    static int answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N=Integer.parseInt(st.nextToken()); M=Integer.parseInt(st.nextToken()); K=Integer.parseInt(st.nextToken());

        note=new int[N][M];
        stickers=new Sticker[K];

        for(int i=0;i<K;i++){
            st=new StringTokenizer(br.readLine()," ");
            int r=Integer.parseInt(st.nextToken()); int c=Integer.parseInt(st.nextToken());
            int[][] board=new int[r][c];
            for(int j=0;j<r;j++){
                st=new StringTokenizer(br.readLine()," ");
                for (int k=0;k<c;k++){
                    board[j][k]=Integer.parseInt(st.nextToken());
                }
            }
            stickers[i]=new Sticker(r,c,board);
        }

        for(int i=0;i<K;i++){
            for(int j=0;j<4;j++){
                if(putSticker(stickers[i])){
                    break;
                }
                stickers[i].rotate();
            }
        }

        System.out.println(answer);

    }
    static boolean putSticker(Sticker s){
        for(int i=0;i<N-s.r+1;i++){
            for(int j=0;j<M-s.c+1;j++){
                if(pushSticker(i,j,s)){
                    return true;
                }
            }
        }
        return false;
    }
    static boolean pushSticker(int r,int c, Sticker s){
        for(int i=r;i<r+s.r;i++){
            for(int j=c;j<c+s.c;j++){
                if(s.board[i-r][j-c]==1 && note[i][j]!=0){
                    return false;
                }
            }
        }
        for(int i=r;i<r+s.r;i++){
            for(int j=c;j<c+s.c;j++){
                if(s.board[i-r][j-c]==1){
                    note[i][j]=1;
                    answer++;
                }
            }
        }
        return true;

    }

    static class Sticker{
        int r;
        int c;
        int[][] board;
        Sticker(int r,int c,int[][] board){
            this.r=r;
            this.c=c;
            this.board=board;
        }

        public String toString(){
            return r+" "+c;
        }
        void rotate(){
            int newR=this.c;    int newC=this.r;

            int[][] newBoard=new int[newR][newC];

            for(int i=0;i<r;i++){
                for(int j=0;j<c;j++){
                    newBoard[j][r-i-1]=board[i][j];
                }
            }
            board=newBoard;
            this.r=newR;    this.c=newC;
        }
    }

}
