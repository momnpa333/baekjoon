import java.io.*;
import java.util.*;

public class Main {
    static int R,C;
    static char[][] board;
    static int targetR=-1,targetC=-1;
    static int[] dr={0,1,0,-1};
    static int[] dc={1,0,-1,0};
    static char ans;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        R=Integer.parseInt(st.nextToken());
        C=Integer.parseInt(st.nextToken());

        board=new char[R][C];

        for(int i=0;i<R;i++){
            String s=br.readLine();
            for(int j=0;j<C;j++){
                board[i][j]=s.charAt(j);
            }
        }

        for(int i=0;i<R;i++){
            for(int j=0;j<C;j++){
                if((board[i][j]=='M'|| board[i][j]=='Z') && targetR==-1){
                    findBlock(i,j);
                }
            }
        }
        makeBlock();
        System.out.printf("%d %d %c\n",targetR+1,targetC+1,ans);
    }
    static void makeBlock(){
        boolean left=false,right=false,up=false,down=false;
        for(int j=0;j<4;j++){
            int curR=targetR+dr[j];
            int curC=targetC+dc[j];
            if(curR>=0 && curR<R && curC>=0 && curC<C){
                if(j==0){
                    if(board[curR][curC]=='-'||board[curR][curC]=='+'||board[curR][curC]=='4'||board[curR][curC]=='3'){
                        right=true;
                    }
                }
                if(j==1){
                    if(board[curR][curC]=='|'||board[curR][curC]=='+'||board[curR][curC]=='2'||board[curR][curC]=='3'){
                        down=true;
                    }
                }
                if(j==2){
                    if(board[curR][curC]=='-'||board[curR][curC]=='+'||board[curR][curC]=='1'||board[curR][curC]=='2'){
                        left=true;
                    }
                }
                if(j==3){
                    if(board[curR][curC]=='|'||board[curR][curC]=='+'||board[curR][curC]=='1'||board[curR][curC]=='4'){
                        up=true;
                    }
                }
            }
        }

        if(left && right && up && down){
            ans='+';
            return;
        }
        if(left && right){
            ans='-';
            return;
        }
        if(up && down){
            ans='|';
            return;
        }
        if(right && down){
            ans='1';
        }
        if(right && up){
            ans='2';
        }
        if(left && up){
            ans='3';
        }
        if(left && down){
            ans='4';
        }
    }

    static void findBlock(int r,int c){
        boolean[][] visited=new boolean[R][C];
        ArrayDeque<Item> dq=new ArrayDeque<>();
        dq.add(new Item(r,c,board[r][c]));
        visited[r][c]=true;

        while(!dq.isEmpty()){
            int L=dq.size();
            for(int i=0;i<L;i++){
                Item item=dq.poll();
                if(item.op=='M'||item.op=='Z'){
                    for(int j=0;j<4;j++){
                        int curR=item.r+dr[j];
                        int curC=item.c+dc[j];
                        if(curR>=0 && curR<R && curC>=0 && curC<C && !visited[curR][curC] && board[curR][curC]!='.'){
                            dq.add(new Item(curR,curC,board[curR][curC]));
                            visited[curR][curC]=true;
                        }
                    }
                }
                if(item.op=='-'){
                    for(int j=0;j<4;j+=2){
                        int curR=item.r+dr[j];
                        int curC=item.c+dc[j];
                        if(curR>=0 && curR<R && curC>=0 && curC<C && !visited[curR][curC]){
                            if(board[curR][curC]!='.'){
                                dq.add(new Item(curR,curC,board[curR][curC]));
                                visited[curR][curC]=true;
                            }
                            else{
                                targetR = curR;
                                targetC = curC;
                                return;
                            }
                        }
                    }
                }
                if(item.op=='|'){
                    for(int j=1;j<4;j+=2){
                        int curR=item.r+dr[j];
                        int curC=item.c+dc[j];
                        if(curR>=0 && curR<R && curC>=0 && curC<C && !visited[curR][curC]){
                            if(board[curR][curC]!='.'){
                                dq.add(new Item(curR,curC,board[curR][curC]));
                                visited[curR][curC]=true;
                            }
                            else{
                                targetR = curR;
                                targetC = curC;
                                return;
                            }
                        }
                    }
                }
                if(item.op=='+'){
                    for(int j=0;j<4;j++){
                        int curR=item.r+dr[j];
                        int curC=item.c+dc[j];
                        if(curR>=0 && curR<R && curC>=0 && curC<C && !visited[curR][curC]){
                            if(board[curR][curC]!='.'){
                                dq.add(new Item(curR,curC,board[curR][curC]));
                                visited[curR][curC]=true;
                            }
                            else{
                                targetR = curR;
                                targetC = curC;
                                return;
                            }
                        }
                    }
                }
                if(item.op=='1'||item.op=='2'||item.op=='3'||item.op=='4'){
                    int[] ops=findDir(item.op);
                    for(int j=0;j<2;j++){
                        int curR=item.r+dr[ops[j]];
                        int curC=item.c+dc[ops[j]];
                        if(curR>=0 && curR<R && curC>=0 && curC<C && !visited[curR][curC]){
                            if(board[curR][curC]!='.'){
                                dq.add(new Item(curR,curC,board[curR][curC]));
                                visited[curR][curC]=true;
                            }
                            else{
                                targetR = curR;
                                targetC = curC;
                                return;
                            }
                        }
                    }
                }
            }
        }
    }
    static int[] findDir(char op){
        if(op=='1'){
            return new int[]{0,1};
        }
        if(op=='2'){
            return new int[]{0,3};
        }
        if(op=='3'){
            return new int[]{2,3};
        }
        if(op=='4'){
            return new int[]{2,1};
        }
        return new int[]{};
    }
    static class Item{
        int r,c;
        char op;
        Item(int r,int c,char op){
            this.r=r;
            this.c=c;
            this.op=op;
        }
    }
}
