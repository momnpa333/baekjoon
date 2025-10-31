import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static boolean[][] board;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N=Integer.parseInt(st.nextToken());
        board=new boolean[102][102];

        for(int i=0;i<N;i++){
            st=new StringTokenizer(br.readLine());
            int x=Integer.parseInt(st.nextToken());
            int y=Integer.parseInt(st.nextToken());

            paste(x,y);
        }
//        System.out.println(findSize(3,25));
//        System.out.println(findSize(5,13));
        System.out.println(solve());
    }
    static int solve(){
        int ret=0;
        for(int x1=0;x1<=99;x1++){
            for(int x2=x1;x2<=99;x2++){
                ret=Math.max(ret,findSize(x1,x2));
            }
        }
        return ret;
    }
    static int findSize(int x1,int x2){
        int ret=0;
        int curSize=0;
//        int startY=0;
        A:
        for(int y=0;y<=99;y++){
            for(int x=x1;x<=x2;x++){
                if(!board[x][y]) {
                    ret=Math.max(ret,curSize);
                    curSize=0;

                    continue A;
                }
            }
            curSize+=x2-x1+1;
        }

        ret=Math.max(ret,curSize);

        return ret;
    }
    static void paste(int x,int y){
        for(int i=0;i<10;i++){
            for(int j=0;j<10;j++){
                board[x+i][y+j]=true;
            }
        }
    }
}