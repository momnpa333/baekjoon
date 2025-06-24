import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class _순서대로방문하기 {
    static int N;
    static int M;
    static int startR;
    static int startC;
    static int endR;
    static int endC;
    static int[][] board;
    static int[] dirr = {0,1,0,-1};
    static int[] dirc = {1,0,-1,0};
    static int answer=0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");

        N = Integer.parseInt(st.nextToken()); M = Integer.parseInt(st.nextToken());

        board=new int[N][N];

        for(int r=0;r<N;r++){
            st=new StringTokenizer(br.readLine()," ");
            for(int c=0;c<N;c++){
                int v=Integer.parseInt(st.nextToken());
                if (v==1){
                    board[r][c]=-1;
                }
                else {
                    board[r][c]=v;
                }
            }
        }

        for(int i=1;i<=M;i++){
            st=new StringTokenizer(br.readLine()," ");
            int r=Integer.parseInt(st.nextToken())-1; int c=Integer.parseInt(st.nextToken())-1;
            board[r][c]=i;
            if(i==1){
                startR=r; startC=c;
            }
            if(i==M){
                endR=r; endC=c;
            }
        }

        Item item=new Item(1,startR,startC);

        ArrayDeque<Item> dq= new ArrayDeque<>();

        dq.add(item);

        while(!dq.isEmpty()){
            int L=dq.size();
            for(int i=0;i<L;i++){
                Item tmp=dq.pollFirst();

                if(tmp.posR==endR && tmp.posC==endC){
                    answer+=1;
                    continue;
                }

                for(int j=0;j<4;j++){
                    int curr=tmp.posR+dirr[j]; int curc=tmp.posC+dirc[j];

                    if(curr>=0 && curr<N && curc>=0 && curc<N && !tmp.isExist(curr,curc) && (board[curr][curc]==0 || tmp.stage+1==board[curr][curc])){
                        if(tmp.stage+1==board[curr][curc]){
                            Item newItem=new Item(tmp.stage+1,new HashSet<>(tmp.hist),curr,curc);
                            dq.add(newItem);
                        }
                        else{
                            Item newItem=new Item(tmp.stage,new HashSet<>(tmp.hist),curr,curc);
                            dq.add(newItem);
                        }
                    }
                }
            }
        }
        System.out.println(answer);

    }

    static class Item{
        int stage;
        int posR;
        int posC;
        Set<String>hist;

        public Item(int stage, int r,int c) {
            hist=new HashSet<>();
            hist.add(change(r,c));
            this.stage=stage;
            this.posR=r;
            this.posC=c;
        }

        public Item(int stage, Set<String> hist,int r, int c) {
            this.hist=hist;
            hist.add(change(r,c));
            this.stage=stage;
            this.posR=r;
            this.posC=c;

        }

        public void add(int r,int c){
            hist.add(change(r,c));
        }
        public boolean isExist(int r,int c){
            return hist.contains(change(r, c));
        }
        public String change(int r,int c){
            return "("+Integer.toString(r)+","+Integer.toString(c)+")";
        }
    }
}
