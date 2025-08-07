import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class _1022 {
    static int r1,r2,c1,c2;
    static int[][] board;
    static final int MIDR=5000;
    static final int MIDC=5000;
    static int[] dr={-1,0,1,0};
    static int[] dc={0,-1,0,1};


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        r1=Integer.parseInt(st.nextToken());
        c1=Integer.parseInt(st.nextToken());
        r2=Integer.parseInt(st.nextToken());
        c2=Integer.parseInt(st.nextToken());

        board=new int[r2-r1+1][c2-c1+1];

        draw(5000,5000,0,1);
        int max=0;
        for(int i=0;i<=r2-r1;i++){
            for(int j=0;j<=c2-c1;j++){
                max=Math.max(String.valueOf(board[i][j]).length(),max);
            }
        }

        for(int i=0;i<=r2-r1;i++){
            String s="";
            for(int j=0;j<=c2-c1;j++){
                for(int k=0;k<max-String.valueOf(board[i][j]).length();k++){
                    s+=" ";
                }
                s+=board[i][j];
                s+=" ";
            }
            System.out.println(s);
        }


    }
    static void draw(int r,int c,int depth,int cur){
        if(depth==5001){
            return;
        }
        for(int i=0;i<4;i++){
            while(Math.abs(r-MIDR)<=depth && Math.abs(c-MIDC)<=depth){
                if(r>=r1+5000 &&r<=r2+5000 && c>=c1+5000 && c<=c2+5000){
                    board[r-r1-5000][c-c1-5000]=cur++;
                }
                else{
                    cur++;
                }
                r+=dr[i];   c+=dc[i];
            }
            r-=dr[i]; c-=dc[i]; cur--;
        }
        draw(r,c+1,depth+1,cur+1);
    }

}
