import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class _15685 {
    static boolean[][] board;
    static int[] dirr={0,-1,0,1};
    static int[] dirc={1,0,-1,0};
    static int N;
    static int answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st= new StringTokenizer(br.readLine());

        N=Integer.parseInt(st.nextToken());

        board=new boolean[101][101];

        while(N-->0){
            st=new StringTokenizer(br.readLine()," ");

            int c=Integer.parseInt(st.nextToken());
            int r=Integer.parseInt(st.nextToken());
            int d=Integer.parseInt(st.nextToken());
            int g=Integer.parseInt(st.nextToken());

            board[r][c]=true;
            makeCurve(r,c,d,g,0,new ArrayList<>());

        }

        for(int i=0;i<100;i++){
            for(int j=0;j<100;j++){
                if(isSquare(i,j)){
                    answer++;
                }
            }
        }
        System.out.println(answer);

    }

    static void makeCurve(int r,int c,int d,int g,int cur, List<Integer> prev){
        if(cur>g){
            return;
        }
        int cr=r; int cc=c;
        List<Integer> directions=new ArrayList<>();
        if(cur==0){
            cr+=dirr[d]; cc+=dirc[d];
            board[cr][cc]=true;
            directions.add(d);
        }
        else{
            for(int i=prev.size()-1;i>=0;i--){
                int dir=(prev.get(i)+1)%4;
                cr+=dirr[dir]; cc+=dirc[dir];
                board[cr][cc]=true;
                directions.add(dir);
            }
        }
        prev.addAll(directions);


        makeCurve(cr,cc,d,g,cur+1,prev);
    }
    static boolean isSquare(int r,int c){
        return board[r][c] && board[r + 1][c] && board[r][c + 1] && board[r + 1][c + 1];
    }


}
