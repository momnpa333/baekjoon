import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class _3055 {
    static int R,C;
    static char[][] board;
    static int startR,startC;
    static int[] dr={1,0,-1,0};
    static int[] dc={0,1,0,-1};
    static int answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


        R=Integer.parseInt(st.nextToken()); C=Integer.parseInt(st.nextToken());
        board=new char[R][C];

        ArrayDeque<Item> dq=new ArrayDeque<>();
        for(int i=0;i<R;i++){
            String tmp=br.readLine();
            int j=0;
            for(char t:tmp.toCharArray()){
                if(t=='S'){
                    Item item=new Item(t,i,j);
                    dq.add(item);
                }
                if(t=='*'){
                    Item item=new Item(t,i,j);
                    dq.addFirst(item);
                }
                board[i][j++]=t;
            }
        }

        while(!dq.isEmpty()){
            int L=dq.size();
            answer++;
            for(int i=0;i<L;i++){
                Item item=dq.pollLast();
                if(item.v=='S'){
                    if(board[item.r][item.c]=='*'){
                        continue;
                    }
                    for(int j=0;j<4;j++){
                        int curR=item.r+dr[j];  int curC=item.c+dc[j];
                        if(curR>=0 && curR<R && curC>=0 && curC<C){
                            if(board[curR][curC]=='D'){
                                System.out.println(answer);
                                return;
                            }
                            if(board[curR][curC]=='.'){
                                board[curR][curC]='S';
                                dq.addFirst(new Item(item.v,curR,curC));
                            }
                        }
                    }
                }
                if(item.v=='*'){
                    for(int j=0;j<4;j++){
                        int curR=item.r+dr[j];  int curC=item.c+dc[j];
                        if(curR>=0 && curR<R && curC>=0 && curC<C && (board[curR][curC]=='.' || board[curR][curC]=='S')){
                            board[curR][curC]='*';
                            dq.addFirst(new Item(item.v,curR,curC));
                        }
                    }
                }
            }
        }
        System.out.println("KAKTUS");
    }

    static class Item{
        char v;
        int r;
        int c;

        Item(char v,int r,int c){
            this.v=v;
            this.r=r;
            this.c=c;
        }
        public String toString(){
            return v+" "+r+" "+c;
        }

    }

}
