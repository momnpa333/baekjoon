import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class _14719 {
    static int H,W;
    static boolean[][] board;
    static int answer;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        H=Integer.parseInt(st.nextToken()); W=Integer.parseInt(st.nextToken());

        board=new boolean[H][W];

        st=new StringTokenizer(br.readLine()," ");
        for(int i=0;i<W;i++){
            int h=Integer.parseInt(st.nextToken());
            for(int j=0;j<h;j++){
                board[j][i]=true;
            }
        }
//        for(int i=0;i<H;i++)
//            System.out.println(Arrays.toString(board[i]));

        for(int i=0;i<H;i++){
//            System.out.println(answer);
            boolean wall=false;
            int cur=0;
            for(int j=0;j<W;j++){
                if(!wall && board[i][j]){
                    wall=true;
                }
                if(wall && board[i][j]){
                    answer+=cur;
                    cur=0;
                }
                if(wall && !board[i][j]){
                    cur++;
                }
            }
        }

        System.out.println(answer);

    }
}
