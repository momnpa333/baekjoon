import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class _5427 {
    static int T;
    static int W,H;
    static char[][] board;
    static int[] dr={0,1,0,-1};
    static int[] dc={1,0,-1,0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        T=Integer.parseInt(st.nextToken());

        A:
        while(T-->0){
            st=new StringTokenizer(br.readLine()," ");
            W=Integer.parseInt(st.nextToken()); H=Integer.parseInt(st.nextToken());
            board=new char[H][W];
            ArrayDeque<Item> fireDq=new ArrayDeque<>();
            ArrayDeque<Item> dq=new ArrayDeque<>();
            int flag=0;

            for(int i=0;i<H;i++){
                st=new StringTokenizer(br.readLine()," ");
                String row=st.nextToken();
                int j=0;
                for(char ch:row.toCharArray()){
                    if(ch=='@'){
                        if(i==0 || i==H-1 || j==0 || j==W-1){
                            System.out.println(1);
                            flag=1;
                        }
                        dq.add(new Item(i,j,ch));
                    }
                    if(ch=='*'){
                        fireDq.add(new Item(i,j,ch));
                    }
                    board[i][j++]=ch;
                }
            }
            if(flag==1){
                continue A;
            }
            int time=1;
            while(!fireDq.isEmpty()||!dq.isEmpty()){
//                System.out.println(fireDq);
//                System.out.println(dq);
                int L= fireDq.size();
                for(int k=0;k<L;k++){
                    Item item=fireDq.poll();
                    for(int p=0;p<4;p++){
                        int curR=dr[p]+item.r;  int curC=dc[p]+item.c;
                        if(curR>=0 && curR<H && curC>=0 && curC<W && board[curR][curC]!='#' && board[curR][curC]!='*'){
                            board[curR][curC]='*';
                            fireDq.add(new Item(curR,curC,item.op));
                        }
                    }
                }
                L= dq.size();
                for(int k=0;k<L;k++){
                    Item item=dq.poll();
                    for(int p=0;p<4;p++){
                        int curR=dr[p]+item.r;  int curC=dc[p]+item.c;
                        if(curR>=0 && curR<H && curC>=0 && curC<W && board[curR][curC]=='.'){
                            if(curR==0 || curR==H-1 || curC==0 || curC==W-1){
                                System.out.println(time+1);
                                continue A;
                            }
                            board[curR][curC]='-';
                            dq.add(new Item(curR,curC,item.op));
                        }
                    }
                }
                time+=1;
            }
            System.out.println("IMPOSSIBLE");

        }


    }

    static class Item{
        int r;
        int c;
        char op;
        Item(int r,int c,char op){
            this.r=r;
            this.c=c;
            this.op=op;
        }
        public String toString(){
            return r+" "+c+" "+op;
        }
    }
}
