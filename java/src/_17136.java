import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class _17136 {
    static int[][] board;
    static int answer=Integer.MAX_VALUE;
    static int[] op;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        board=new int[10][10];
        op=new int[5];


        for(int i=0;i<10;i++){
            st=new StringTokenizer(br.readLine()," ");
            for(int j=0;j<10;j++){
                board[i][j]=Integer.parseInt(st.nextToken());
            }
        }
        dfs(0,0,0);

        if(answer==Integer.MAX_VALUE){
            System.out.println(-1);
        }
        else{
            System.out.println(answer);
        }

    }
    static void dfs(int r,int c,int cnt){
        int nextR=r; int nextC=c;
        if(cnt>answer){
            return;
        }
        if(r==10 && c==0){
            answer=Math.min(answer,cnt);
            return;
        }

        if(c==9){
            nextR++;
            nextC=0;
        }
        else{
            nextC++;
        }

        if(board[r][c]==0){
            dfs(nextR,nextC,cnt);
        }
        else{
            for(int s=5;s>0;s--){
                if(op[s-1]<5 && isPossible(r,c,s)){
                    op[s-1]+=1;
                    erase(r,c,s);
                    dfs(nextR,nextC,cnt+1);
                    back(r,c,s);
                    op[s-1]-=1;
                }
            }
        }

    }

    static boolean isPossible(int r,int c,int size){
        for(int i=0;i<size;i++){
            for(int j=0;j<size;j++){
                if(r+i<0 || r+i >=10 || c+j<0 || c+j>=10 || board[r+i][c+j]!=1){
                    return false;
                }
            }
        }
        return true;
    }
    static void erase(int r,int c,int size){
        for(int i=0;i<size;i++){
            for(int j=0;j<size;j++){
                board[r+i][c+j]=0;
            }
        }
    }
    static void back(int r,int c,int size){
        for(int i=0;i<size;i++){
            for(int j=0;j<size;j++){
                board[r+i][c+j]=1;
            }
        }
    }

}
