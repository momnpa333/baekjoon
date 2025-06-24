import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class _2448 {
    static int N;
    static char[][] board;

    static int answer=0;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());

        int size=N; int posR=0; int posC=(N*2-1)/2;
        board=new char[N][N*2-1];

        for(int i=0;i<N;i++){
            Arrays.fill(board[i],' ');
        }

        makeBoard(N,posR,posC);

        for(char[] v:board){
            for(char c:v){
                bw.append(c);
            }
            bw.append("\n");
        }
        bw.flush();
    }

    private static void makeBoard(int size, int posR, int posC){
        if (size==3){
            printBoard(posR,posC);
            return;
        }
        makeBoard(size/2,posR,posC);
        makeBoard(size/2,posR+size/2,posC-size/2);
        makeBoard(size/2,posR+size/2,posC+size/2);
    }
    private static void printBoard(int posR,int posC){
        board[posR][posC]='*';
        board[posR+1][posC-1]='*'; board[posR+1][posC+1]='*';
        board[posR+2][posC-2]='*'; board[posR+2][posC-1]='*'; board[posR+2][posC]='*'; board[posR+2][posC+1]='*'; board[posR+2][posC+2]='*';
    }

}
