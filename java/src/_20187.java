import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class _20187 {
    static int K;
    static String[] op;
    static int H;
    static int[][] board;
    static int startR,startC;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= new StringTokenizer(br.readLine()," ");
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


        K=Integer.parseInt(st.nextToken());
        op=new String[2*K];
        st=new StringTokenizer(br.readLine()," ");
        for(int i=0;i<2*K;i++){
            op[i]=st.nextToken();
        }
        H=Integer.parseInt(br.readLine());
        board=new int[(int)Math.pow(2,K)][(int)Math.pow(2,K)];
        findStart(0,0,0,(int)Math.pow(2,K),(int)Math.pow(2,K));
//        System.out.printf("%d %d\n",startR,startC);
        makeBoard(2*K-1,startC,startR,H,1,1,startC,startC+1,startR,startR+1);

        for(int i=0;i<board.length;i++){
            String s="";
            for(int j=0;j<board.length;j++){
                s+=board[i][j]+" ";
            }
            System.out.println(s);
        }
    }
    static void findStart(int depth,int c,int r,int w,int h){
        if(depth>=2*K){
            startR=r;
            startC=c;
            return;
        }
        if(op[depth].equals("R")){
            findStart(depth+1,c+w/2,r,w/2,h);
        }
        if(op[depth].equals("L")){
            findStart(depth+1,c,r,w/2,h);
        }
        if(op[depth].equals("D")){
            findStart(depth+1,c,r+h/2,w,h/2);
        }
        if(op[depth].equals("U")){
            findStart(depth+1,c,r,w,h/2);
        }
    }
    static void makeBoard(int idx,int c,int r,int hole,int w,int h,int LW,int RW,int UW,int DW){
//        System.out.printf("%d %d\n",r,c);
        board[r][c]=hole;
        if(idx<0){
            return;
        }
        for(int i=idx;i>=0;i--){
            if(op[i].equals("R")){
                makeBoard(i-1,LW-(c-LW+1),r,(hole/2)*2+(hole+1)%2,w*2,h,LW-w,RW,UW,DW);
                LW-=w;
                w*=2;
            }
            if(op[i].equals("L")){
                makeBoard(i-1,RW+(RW-c)-1,r,(hole/2)*2+(hole+1)%2,w*2,h,LW,RW+w,UW,DW);
                RW+=w;
                w*=2;
            }
            if(op[i].equals("D")){
                makeBoard(i-1,c,UW-(r-UW+1),(hole+2)%4,w,h*2,LW,RW,UW-h,DW);
                UW-=h;
                h*=2;
            }
            if(op[i].equals("U")){
                makeBoard(i-1,c,DW+(DW-r)-1,(hole+2)%4,w,h*2,LW,RW,UW,DW+h);
                DW+=h;
                h*=2;
            }

        }
    }


}
