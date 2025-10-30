import java.io.*;
import java.util.*;

public class Main {
    static int R,C;
    static char[][] board;
    static int[] dr={0,1,0,-1};
    static int[] dc={1,0,-1,0};
    static boolean[][][] visited;
    static int startR,startC;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        C=Integer.parseInt(st.nextToken());
        R=Integer.parseInt(st.nextToken());

        board=new char[R][C];
        int num='0';
        for(int i=0;i<R;i++){
            String s=br.readLine();
            for(int j=0;j<C;j++){
                board[i][j]=s.charAt(j);
                if(board[i][j]=='S'){
                    startR=i;
                    startC=j;
                }
                if(board[i][j]=='X'){
                    board[i][j]=(char)(num++);
                }
            }
//            System.out.println(Arrays.toString(board[i]));
        }

        visited=new boolean[32][R][C];

        ArrayDeque<Item> dq=new ArrayDeque<>();
        dq.add(new Item(startR,startC,0));
        visited[0][startR][startC]=true;
        int cnt=0;
        while(!dq.isEmpty()){
            int L=dq.size();
//            System.out.println(dq);
            for(int i=0;i<L;i++){
                Item item=dq.poll();
                for(int j=0;j<4;j++){
                    int curR=item.r+dr[j];
                    int curC=item.c+dc[j];
                    if(curR>=0 && curR<R && curC>=0 && curC<C && board[curR][curC]!='#'){
                        if(board[curR][curC]=='E' && item.cur==(int)Math.pow(2,num-'0')-1){
                            System.out.println(cnt+1);
                            return;
                        }
                        int c=item.cur;
                        if(Character.isDigit(board[curR][curC])){
                            if((item.cur>>board[curR][curC]-'0')%2==0){
                                c=(int) (item.cur+Math.pow(2,board[curR][curC]-'0'));
                            }
                        }
                        if(visited[c][curR][curC]) continue;
                        dq.add(new Item(curR,curC,c));
                        visited[c][curR][curC]=true;
                    }
                }
            }
            cnt++;
        }

    }

    static class Item{
        int cur;
        int r,c;
        Item(int r,int c,int cur){
            this.r=r;
            this.c=c;
            this.cur=cur;
        }
        public String toString(){
            return r+" "+c+" "+cur;
        }
    }
}