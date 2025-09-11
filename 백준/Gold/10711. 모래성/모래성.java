import java.io.*;
import java.util.*;

public class Main {
    static int H,W;
    static int[][] board;
    static Set<Send> candi;
    static boolean[][] visited;
    static int T;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        H=Integer.parseInt(st.nextToken());
        W=Integer.parseInt(st.nextToken());
        board=new int[H][W];
        candi=new HashSet<>();
        visited=new boolean[H][W];

        for(int i=0;i<H;i++){
            String s=br.readLine();
            for(int j=0;j<W;j++){
                if(s.charAt(j)=='.'){
                    board[i][j]=0;
                }
                else{
                    board[i][j]=s.charAt(j)-'0';
                }
            }
        }
        ArrayDeque<Send> dq=new ArrayDeque<>();

        for(int i=1;i<H-1;i++){
            for(int j=1;j<W-1;j++){
                dq.add(new Send(i,j));
            }
        }
        while(!dq.isEmpty()){
            int L=dq.size();
            candi=new HashSet<>();
            for(int i=0;i<L;i++){
                Send item=dq.poll();
                for(int j=-1;j<=1;j++){
                    for(int k=-1;k<=1;k++){
                        if(j==0 && k==0) continue;
                        if(!visited[j+item.r][k+item.c] && isCrush(j+item.r,k+item.c)){
                            visited[j+item.r][k+item.c]=true;
                            candi.add(new Send(j+item.r,k+item.c));
                        }
                    }
                }
            }
            if(candi.size()==0){
                System.out.println(T);
                return;
            }
            for(Send item:candi){
                board[item.r][item.c]=0;
                dq.add(item);
            }
            T++;
        }
    }
    static boolean isCrush(int r,int c){
        int nonCnt=0;
        if(board[r][c]==0) return false;
        for(int i=-1;i<=1;i++){
            for(int j=-1;j<=1;j++){
                if(i==0 && j==0) continue;
                if(board[i+r][j+c]==0){
                    nonCnt++;
                }
            }
        }
        if(board[r][c]<=nonCnt){
            return true;
        }
        return false;
    }
    static class Send{
        int r,c;
        Send(int r,int c){
            this.r=r;
            this.c=c;
        }
        public String toString(){
            return r+" "+c;
        }
    }
}
