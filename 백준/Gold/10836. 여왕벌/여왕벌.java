import java.io.*;
import java.sql.Array;
import java.util.*;

public class Main {
    static int M,N;
    static int[] growthSum;
    static int[][] board;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        M=Integer.parseInt(st.nextToken());
        N=Integer.parseInt(st.nextToken());

        board=new int[M][M];
        growthSum=new int[2*M-1];
        growthSum[0]+=1;
        for(int i=0;i<N;i++){
            st=new StringTokenizer(br.readLine()," ");
            int oneStart=Integer.parseInt(st.nextToken());
            int twoStart=Integer.parseInt(st.nextToken());
            int trash=Integer.parseInt(st.nextToken());

            growthSum[oneStart]+=1;
            if((twoStart+oneStart)<2*M-1)
                growthSum[twoStart+oneStart]+=1;
        }
        for(int i=1;i<2*M-1;i++){
            growthSum[i]+=growthSum[i-1];
        }
//        System.out.println(Arrays.toString(growthSum));
        makeBoard();
        for(int i=0;i<M;i++){
            for(int j=0;j<M;j++){
                bw.write(board[i][j]+" ");
            }
            bw.write("\n");
            bw.flush();
        }

    }
    static void makeBoard(){
        int idx=0;
        for(int r=M-1;r>=0;r--){
            board[r][0]=growthSum[idx++];
        }
        for(int c=1;c<M;c++){
            board[0][c]=growthSum[idx++];
        }

        for(int i=1;i<M;i++){
            for(int c=i;c<M;c++){
                board[i][c]=Math.max(board[i-1][c-1],board[i-1][c]);
                board[i][c]=Math.max(board[i][c],board[i][c-1]);
            }
            for(int r=i;r<M;r++){
                board[r][i]=Math.max(board[r-1][i-1],board[r-1][i]);
                board[r][i]=Math.max(board[r][i],board[r][i-1]);
            }
        }
    }


}
