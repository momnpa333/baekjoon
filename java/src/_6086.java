import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class _6086 {
    static int N;
    static int[][][] dp;
    static int[] scvHp;
    static int[][] deal={{9,3,1},{9,1,3},{3,9,1},{3,1,9},{1,9,3},{1,3,9}};
    static int answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N=Integer.parseInt(br.readLine());
        scvHp= new int[3];
        st=new StringTokenizer(br.readLine()," ");
        for(int i=0;i<N;i++){
            scvHp[i]=Integer.parseInt(st.nextToken());
        }
        dp=new int[61][61][61];

        answer=Integer.MAX_VALUE;

        dfs(scvHp,0);
        System.out.println(answer);
    }

    static void dfs(int[] curHp,int depth){
        if(answer<=depth){
            return;
        }

        if(dp[curHp[0]][curHp[1]][curHp[2]]!=0 && dp[curHp[0]][curHp[1]][curHp[2]]<=depth){
            return;
        }
        dp[curHp[0]][curHp[1]][curHp[2]]=depth;

        if(curHp[0]==0 && curHp[1]==0 && curHp[2]==0){
            answer=Math.min(answer,depth);
        }

        for(int i=0;i<6;i++){
            int[] next=new int[3];
            for(int j=0;j<3;j++){
                next[j]=Math.max(0,curHp[j]-deal[i][j]);
            }
            dfs(next,depth+1);
        }
    }

}
