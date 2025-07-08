import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class _1405 {
    static int N;
    static double[] prob;
    static int[] dr={0,0,1,-1};
    static int[] dc={1,-1,0,0};
    static boolean[][] visited = new boolean[40][40];
    static double answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        st=new StringTokenizer(br.readLine()," ");

        N=Integer.parseInt(st.nextToken());

        prob=new double[4];

        for(int i=0;i<4;i++){
            prob[i]=(double)Integer.parseInt(st.nextToken())/100;
        }
        visited[14][14]=true;
        dfs(14, 14, 1, 0);

        System.out.println(answer);

    }
    static void dfs(int r,int c,double curP,int depth){
        if(depth==N){
            answer+=curP;
            return;
        }

        for(int i=0;i<4;i++){
            int R=r+dr[i]; int C=c+dc[i];
            if(0<=R && R<30 && 0<=C && C<30 && !visited[R][C]){
                visited[R][C]=true;
                dfs(R,C,curP*prob[i],depth+1);
                visited[R][C]=false;
            }
        }

    }


}
