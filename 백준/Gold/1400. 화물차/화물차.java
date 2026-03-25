import java.io.*;
import java.util.*;

public class Main {
    static int N,M;
    static char[][] board;
    static int[][] visited;
    static Signal[] signals;
    static int startR=-1;
    static int startC=-1;
    static int endR=-1;
    static int endC=-1;
    static int[] dr={1,0,-1,0};
    static int[] dc={0,1,0,-1};
    static int INF=987654321;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st; //= new StringTokenizer(br.readLine(), " ");
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        while(true){
            st=new StringTokenizer(br.readLine()," ");
            N=Integer.parseInt(st.nextToken());
            M=Integer.parseInt(st.nextToken());
            if(M==0 && N==0) return;
            int signalCnt=-1;
            board=new char[N][M];
            visited=new int[N][M];
            for(int i=0;i<N;i++){
                Arrays.fill(visited[i],INF);
            }
            for(int i=0;i<N;i++){
                String s=br.readLine();
                for(int j=0;j<M;j++){
                    board[i][j]=s.charAt(j);
                    if(board[i][j]-'0'>=0 && board[i][j]-'0'<=9){
                        int sig=board[i][j]-'0';
                        signalCnt=Math.max(signalCnt,sig);
                    }
                    if(board[i][j]=='A'){
                        startR=i; startC=j;
                    }
                    if(board[i][j]=='B'){
                        endR=i; endC=j;
                    }

                }
            }
            if(signalCnt>=0)
                signals=new Signal[signalCnt+1];
            else
                signals=null;
            for(int i=0;i<=signalCnt;i++){
                st=new StringTokenizer(br.readLine()," ");
                int no=Integer.parseInt(st.nextToken());
                String op=st.nextToken();
                int a=Integer.parseInt(st.nextToken());
                int b=Integer.parseInt(st.nextToken());
                signals[no]=new Signal(a,b,op.equals("-"));
            }
            br.readLine();
//            System.out.println(Arrays.toString(signals));
            int t=solve();
            if (t == INF) {
                System.out.println("impossible");
            }
            else {
                System.out.println(t);
            }

        }
    }
    static int solve(){
        int ret=INF;
        PriorityQueue<Item> pq=new PriorityQueue<>();
        pq.add(new Item(0,startR,startC));
        visited[startR][startC]=0;
        while(!pq.isEmpty()){
//            System.out.println(pq);
            Item item=pq.poll();
            if(item.time>visited[item.r][item.c]) continue;

            for(int i=0;i<4;i++){
                int nr=item.r+dr[i];
                int nc=item.c+dc[i];
                if(nr>=0 && nr<N && nc>=0 && nc<M){
                    // '#' 일때
                    if(board[nr][nc]=='#' && item.time+1<visited[nr][nc]){
                        visited[nr][nc]=item.time+1;
                        pq.add(new Item(item.time+1,nr,nc));
                    }
                    // 'sig' 일때
                    if(board[nr][nc]-'0'>=0 && board[nr][nc]-'0'<=9){
                        int nt=nextTime(signals[board[nr][nc]-'0'],item.time+1,i%2!=0);
                        if(nt<visited[nr][nc]){
                            visited[nr][nc]=nt;
                            pq.add(new Item(nt,nr,nc));
                        }
                    }
                    // 도착
                    // '#' 일때
                    if(board[nr][nc]=='B'){
                        ret=Math.min(item.time+1,ret);
                    }
                }
            }
        }
        return ret;
    }
    static int nextTime(Signal sig,int curTime,boolean hori){
        //가로일 때
        if(hori){
            int remain=curTime%(sig.a+sig.b);
            //가로시작
            if(sig.op){
                //건너기 가능
                if(remain<=sig.a && remain>0){
                    return curTime;
                }
                //불가능
                else{
                    int add=remain==0?0:1;
                    return (curTime/(sig.a+sig.b)+add)*(sig.a+sig.b)+1;
                }
            }
            //세로시작
            else{
                //건너기 가능
                if(remain>sig.b || remain==0){
                    return curTime;
                }
                //불가능
                else{
                    return (curTime/(sig.a+sig.b))*(sig.a+sig.b)+sig.b+1;
                }
            }
        }
        //세로일때
        else{
            int remain=curTime%(sig.a+sig.b);
            //가로시작
            if(sig.op){
                //건너기 가능
                if(remain>sig.a || remain==0){
                    return curTime;
                }
                //불가능
                else{
                    return (curTime/(sig.a+sig.b))*(sig.a+sig.b)+sig.a+1;
                }
            }
            //세로시작
            else{
                //건너기 가능
                if(remain<=sig.b && remain>0){
                    return curTime;
                }
                //불가능
                else{
                    int add=remain==0?0:1;
                    return (curTime/(sig.a+sig.b)+add)*(sig.a+sig.b)+1;
                }
            }
        }
    }
    static class Item implements Comparable<Item>{
        int time;
        int r;
        int c;
        Item(int t,int r,int c){
            this.time=t;
            this.r=r;
            this.c=c;
        }
        public int compareTo(Item o){
            return this.time-o.time;
        }
        public String toString(){
            return r+" "+c+" "+time;
        }
    }

    static class Signal{
        int a;
        int b;
        boolean op;
        Signal(int a,int b,boolean op){
            this.a=a;
            this.b=b;
            this.op=op;
        }
        public String toString(){
            return a+" "+b+" "+op;
        }
    }
}