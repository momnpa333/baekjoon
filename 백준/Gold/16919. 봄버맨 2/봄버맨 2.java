import java.io.*;
import java.util.*;

public class Main {
    static int R,C,N;
    static char[][] op1;
    static char[][] op2;
    static char[][] even;
    static int[] dr={0,1,0,-1};
    static int[] dc={1,0,-1,0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        R=Integer.parseInt(st.nextToken());
        C=Integer.parseInt(st.nextToken());
        N=Integer.parseInt(st.nextToken());

        op1=new char[R][C]; op2=new char[R][C]; even=new char[R][C];

        for(int i=0;i<R;i++){
            String s=br.readLine();
            for(int j=0;j<C;j++){
                op1[i][j]=s.charAt(j);
                op2[i][j]='O';
                even[i][j]='O';
            }
        }
        if(N==1){
            print(op1);
            return;
        }
        op2=bomb(op1);
        op1=bomb(op2);
//        print(op1);
//        print(op2);
        if(N%2==0){
            print(even);
            return;
        }
        if(N%4==1){
            print(op1);
            return;
        }
        print(op2);


    }
    static char[][] bomb(char[][] board){
        char[][] tmp=new char[R][C];
        for(int i=0;i<R;i++){
            for(int j=0;j<C;j++){
                tmp[i][j]='O';
            }
        }

        for(int i=0;i<R;i++){
            for(int j=0;j<C;j++){
                if(board[i][j]=='O'){
                    tmp[i][j]='.';
                    for(int k=0;k<4;k++){
                        int curR=i+dr[k];
                        int curC=j+dc[k];
                        if(curR>=0 && curR<R && curC>=0 && curC<C){
                            tmp[curR][curC]='.';
                        }
                    }
                }
            }
        }
        return tmp;
    }
    static void print(char[][] board){
        for(int i=0;i<R;i++){
            String s="";
            for(int j=0;j<C;j++){
                s+=board[i][j];
            }
            System.out.println(s);
        }
    }

}
